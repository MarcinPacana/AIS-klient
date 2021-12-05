package pl.marcin.aisklient.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.marcin.aisklient.model.weather.WeatherData;

@Service
public class WeatherService {

    private final String baseURLweatherAPI = "https://api.openweathermap.org/data/2.5/weather?";
    public  String apiKey = "ad520b43b9253f6dd0956d89dd178b2d";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeather(String place) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<WeatherData> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(createLink(place, apiKey), HttpMethod.GET, httpEntity, WeatherData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return responseEntity.getBody();
    }

    public String createLink(String place, String apiKey) {
        StringBuilder link = new StringBuilder();
        link.append(baseURLweatherAPI).append("q=").append(place)
                .append("&appid=").append(apiKey);
        return link.toString();
    }
}
