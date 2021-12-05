package pl.marcin.aisklient;

import org.junit.jupiter.api.Test;
import pl.marcin.aisklient.model.weather.WeatherData;
import pl.marcin.aisklient.services.WeatherService;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void getWeather() {
        WeatherService weatherService = new WeatherService();
        WeatherData krakow = weatherService.getWeather("Krakow");

        assertTrue(krakow.getMain().getFeelsLike() > 0);
    }

    @Test
    void createLink() {

    }
}