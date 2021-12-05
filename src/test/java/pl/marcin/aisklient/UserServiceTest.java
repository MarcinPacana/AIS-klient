package pl.marcin.aisklient;

import org.junit.jupiter.api.Test;
import pl.marcin.aisklient.model.User;
import pl.marcin.aisklient.services.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getAll() {
        UserService userService = new UserService();
        List<User> userList = userService.getAll();

        assertTrue(userList.size()>0);
    }
}