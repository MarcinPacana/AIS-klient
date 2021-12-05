package pl.marcin.aisklient.model;

import javax.persistence.*;

@Entity
@Table(name = "uzytkownicy_statki")
@IdClass(UserVesselsID.class)
public class UserVessels {

    @Id
    @Column(name = "uzytkownik_id")
    private Integer userId;

    @Id
    @Column(name = "statek_id")
    private Integer vesselId;

    public UserVessels(){
    }

    public UserVessels(Integer userId, Integer vesselId) {
        this.userId = userId;
        this.vesselId = vesselId;
    }

    public Integer getUzytkownikId() {
        return this.userId;
    }

    public void setUzytkownikId(Integer uzytkownikId) {
        this.userId = uzytkownikId;
    }

    public Integer getStatekId() {
        return this.vesselId;
    }

    public void setStatekId(Integer statekId) {
        this.vesselId = statekId;
    }

    @Override
    public String toString() {
        return "UserVessels{" +
                "userId=" + userId +
                ", vesselId=" + vesselId +
                '}';
    }


}
