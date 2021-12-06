package pl.marcin.aisklient.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.marcin.aisklient.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {

    RestTemplate restTemplate = new RestTemplate();
    private AisToken aisToken;
    private final Coordinates defaultCoordinates;

    private final String URL_AIS_GET_TOKEN = "https://id.barentswatch.no/connect/token";
    private final String URL_AIS_API = "https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?";
    private final String URL_AIS_search = "https://www.barentswatch.no/bwapi/v1/geodata/vessel/open?q=";

    public TrackService() {
        this.aisToken = getAisToken();
        this.defaultCoordinates = new Coordinates(10.09094, 10.67047, 63.3989, 63.58645);
    }


    public List<Point> getTracks() {
        return getTracks(null);
    }

    public List<Point> getTracks(String place) {
        String link;
        if (place == null || getCoordinatesByPlace(place) == null) {
            link = createLink(URL_AIS_API, defaultCoordinates);
        } else {
            System.out.println("tworzy podany w zadaniu");
            link = createLink(URL_AIS_API, getCoordinatesByPlace(place));
        }

        Ship[] element = getElement(link, Ship[].class);

        List<Point> pointList = mapToPoint(element);
        return pointList;
    }

    private  <T>T getElement( String link, Class<T> type){
        checkToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + aisToken.getAccessToken());
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<T> exchange = restTemplate
                .exchange(link, HttpMethod.GET, httpEntity,type);
        return exchange.getBody();
    }

    // gets a token if this one is out of date
    private void checkToken() {
        boolean actual = aisToken.isActual();
        if (!actual) {
            this.aisToken = getAisToken();
        }
    }

    private List<Point> mapToPoint(Ship[] ships) {
        List<Point> pointList = Stream.of(ships).map(
                ship -> new Point(
                        ship.getGeometry().getCoordinates().get(1),
                        ship.getGeometry().getCoordinates().get(0),
                        ship.getName(),
                        ship.getDestination(),
                        ShipType.getByTypeCode(ship.getShipType()).getTypeName(),
                        ship.getMmsi(),
                        ship.getCountry()
                )).collect(Collectors.toList());
        for (Point point : pointList) {
            Datum destination = getDestination(point.getDestinationName());
            point.setDestinationX(destination.getLatitude());
            point.setDestinationY(destination.getLongitude());
        }
        return pointList;
    }

    public Coordinates getCoordinatesByPlace(String place) {
        Datum datum = getDestination(place);
        if (datum == null) {
            return null;
        } else {
            Double latitude = datum.getLatitude();
            Double longitude = datum.getLongitude();

            Coordinates coordinates = new Coordinates();
            coordinates.setLatitudeMIN(longitude - 0.5);
            coordinates.setLatitudeMAX(longitude + 0.5);
            coordinates.setLongitudeMIN(latitude - 0.5);
            coordinates.setLongitudeMAX(latitude + 0.5);
            System.out.println(coordinates.getLatitudeMIN());
            System.out.println(coordinates.getLatitudeMAX());
            System.out.println(coordinates.getLongitudeMIN());
            System.out.println(coordinates.getLongitudeMAX());
            return coordinates;
        }
    }


    public Datum getDestination(String destynationName) {
        try {
            ResponseEntity<Destination> exchange = restTemplate.exchange("http://api.positionstack.com/v1/forward?access_key=f2cbcbba93ae4d0f222db632d1d8b42d&query=" + destynationName,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    Destination.class);
            Destination destination = (Destination) exchange.getBody();
            if (destination.getData().isEmpty()) {
                return new Datum(null, null);
            } else {
                return exchange.getBody().getData().get(0);
            }
        } catch (Exception e) {
            return new Datum(null, null);
        }
    }

    public AisToken getAisToken() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("client_id", "marcinfiber@gmail.com:Marcin");
        map.add("scope", "api");
        map.add("client_secret", "H1Ih3&QJD6ONncTrbBb5");
        map.add("grant_type", "client_credentials");
        RequestEntity requestEntity = RequestEntity
                .post(URL_AIS_GET_TOKEN)
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .body(map);
        ResponseEntity<AisToken> response = restTemplate.exchange(requestEntity, AisToken.class);
        AisToken aisToken = response.getBody();
        return aisToken;
    }


    public String createLink(String url, Coordinates coordinates) {
        StringBuilder link = new StringBuilder();
        link.append(URL_AIS_API)
                .append("Xmin=").append(coordinates.getLatitudeMIN()).append("&")
                .append("Xmax=").append(coordinates.getLatitudeMAX()).append("&")
                .append("Ymin=").append(coordinates.getLongitudeMIN()).append("&")
                .append("Ymax=").append(coordinates.getLongitudeMAX());
        return link.toString();
    }


    public List<Vessel> searchShip(String name, boolean aisOnly) {
        System.out.println("start searchShip method");
        StringBuilder stringBuilder = new StringBuilder(URL_AIS_search);
        stringBuilder.append(name).append("&onlyIncludeAis=").append(aisOnly);
        String link = stringBuilder.toString();
        Vessel[] vessels = getElement(link,Vessel[].class);
        List<Vessel> vesselList =  Arrays.asList(vessels);

        for (Vessel v:vesselList) {
            System.out.println("searchShip: "+v.getMmsi());
        }

        return vesselList;
    }


}
