package pl.marcin.aisklient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uzytkownicy")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "uzytkownicy_statki",
            joinColumns = {
                @JoinColumn(name = "uzytkownik_id",referencedColumnName = "id",
                nullable = false,updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "statek_id",referencedColumnName = "mmsi",
                nullable = false,updatable = false)})
    @JsonIgnore
    private Set<Vessel> favoritesVessels = new HashSet<>(0);





    public Set<Vessel> getFavoritesVessels() {
        return favoritesVessels;
    }

    public void setFavoritesVessels(Set<Vessel> favoritesVessels) {
        this.favoritesVessels = favoritesVessels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
