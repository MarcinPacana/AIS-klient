package pl.marcin.aisklient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.aisklient.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel,Integer> {


    Vessel findVesselByMmsi(Integer mmsi);
}
