package pl.marcin.aisklient.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.marcin.aisklient.model.User;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        String password = user.getPassword();
        System.out.println("CustomerUserDetails: getPassword: "+password);
        return password;
    }

    @Override
    public String getUsername() {
        String email = user.getEmail();
        System.out.println("CustomerUserDetails: getUsername: "+email);
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
