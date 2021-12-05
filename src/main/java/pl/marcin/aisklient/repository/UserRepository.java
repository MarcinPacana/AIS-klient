package pl.marcin.aisklient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.aisklient.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

  //  void addVesselToFavoritesList(Vessel vessel);


}