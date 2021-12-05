package pl.marcin.aisklient.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.marcin.aisklient.services.WeatherService;

@ComponentScan
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(  "/weather/{place}")
    public String getWeather(@PathVariable String place, Model model){
        model.addAttribute("weather",weatherService.getWeather(place));
        return "weather";
    }


}