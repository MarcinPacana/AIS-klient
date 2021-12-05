package pl.marcin.aisklient.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "tomkowe";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }
}
