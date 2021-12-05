package pl.marcin.aisklient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.marcin.aisklient.model.User;
import pl.marcin.aisklient.model.UserVessels;
import pl.marcin.aisklient.model.Vessel;
import pl.marcin.aisklient.repository.UserRepository;
import pl.marcin.aisklient.repository.UserVesselsRepository;
import pl.marcin.aisklient.repository.VesselRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackService trackService;

    @Autowired
    private UserVesselsRepository userVesselsRepository;

    @Autowired
    private VesselRepository vesselRepository;

    public List<User> getAll() {
        return  userRepository.findAll();
    }

    public void addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public List<Vessel> addToFavorite(int mmis) {
        CustomUserDetails customUserDetails =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = customUserDetails.getUser();
        List<Vessel> vesselList = trackService.searchShip(String.valueOf(mmis),false);
        Vessel vessel = vesselList.get(0);

        Vessel vesselByMmsi = vesselRepository.findVesselByMmsi(vessel.getMmsi());
        if (vesselByMmsi == null){
            vesselRepository.save(vessel);
        }
        userRepository.flush();
        UserVessels userVessels = new UserVessels(user.getId(),vessel.getMmsi());
        userVesselsRepository.save(userVessels);
        userRepository.flush();
        return null;
    }

    public Model getCurrentLoggedInUsser(Model model) {
        CustomUserDetails customUserDetails =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = customUserDetails.getUser();

        Set<Vessel> favoritesVessels = user.getFavoritesVessels();
        model.addAttribute("user",user);
        model.addAttribute("favoritesVessels",favoritesVessels);
        return model;
    }
}
