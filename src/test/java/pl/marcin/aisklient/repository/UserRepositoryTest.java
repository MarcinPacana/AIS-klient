package pl.marcin.aisklient.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import pl.marcin.aisklient.model.User;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void findUserByEmail() {
        String email = "tomek@gmail.com";
        User userByEmail = userRepository.findUserByEmail(email);
        assertTrue(userByEmail.getEmail().equals(email));
    }

    @Test
    void createUser(){
        User user = new User();
        user.setEmail("malina@gmail.com");
        user.setName("Malina");
        user.setPassword("malina");

        User saved = userRepository.save(user);
        User findUser = entityManager.find(User.class, saved.getId());
        assertTrue(findUser.getId() == saved.getId());
    }
}