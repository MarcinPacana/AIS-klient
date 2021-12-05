package pl.marcin.aisklient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.aisklient.model.UserVessels;
import pl.marcin.aisklient.model.UserVesselsID;
import pl.marcin.aisklient.model.Vessel;

import java.util.List;

public interface UserVesselsRepository extends JpaRepository<UserVessels, UserVesselsID> {

        List<Vessel> findUserVesselsByUserId(Integer id);
}
