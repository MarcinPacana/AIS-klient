package pl.marcin.aisklient.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.marcin.aisklient.model.Vessel;
import pl.marcin.aisklient.services.TrackService;
import pl.marcin.aisklient.services.UserService;

import java.util.List;

@Controller
public class ShipController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/search")
    public String search(@RequestParam String name, Model model){
        System.out.println("parametr name: "+name);
        List<Vessel> vesselList = trackService.searchShip(name, true);
        model.addAttribute("vesselList",vesselList);
        model.addAttribute("name",name);
        return "vessel-list";
    }

    @GetMapping("/user/add-vessel")
    public String addToFavorites(@RequestParam int mmsi, Model model){
        System.out.println("add-vessel: mmsi: "+mmsi);
        List<Vessel> favoriteVesselList =  userService.addToFavorite(mmsi);
        model.addAttribute("favoriteVesselList",favoriteVesselList);
        return "vessel-list";
    }

}
