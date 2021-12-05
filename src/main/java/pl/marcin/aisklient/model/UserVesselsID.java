package pl.marcin.aisklient.model;

import java.io.Serializable;
import java.util.Objects;

public class UserVesselsID implements Serializable {

    private Integer userId;
    private Integer vesselId;

    public UserVesselsID(){
    }

    public UserVesselsID(Integer userId, Integer vesselId) {
        this.userId = userId;
        this.vesselId = vesselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVesselsID)) return false;
        UserVesselsID that = (UserVesselsID) o;
        return Objects.equals(userId, that.userId) && Objects.equals(vesselId, that.vesselId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, vesselId);
    }
}
