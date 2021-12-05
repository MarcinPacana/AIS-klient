package pl.marcin.aisklient;

import org.junit.jupiter.api.Test;
import pl.marcin.aisklient.model.AisToken;
import pl.marcin.aisklient.services.TrackService;

import static org.junit.jupiter.api.Assertions.*;


class ShipServiceTest {

    @Test
    void getAisToken() {
       TrackService trackService = new TrackService();
        AisToken aisToken = trackService.getAisToken();

        System.out.println(aisToken.getAccessToken());

       assertTrue(aisToken.getAccessToken().length() > 10);
    }
}