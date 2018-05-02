package kz.kaznitu.footballplayer.models;

import javax.persistence.*;

@Entity
public class MadeIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long madeInId;

    private String bikeName;

    private String location;

    public MadeIn() {
    }

    public MadeIn(String bikeName, String location) {
        this.bikeName =bikeName;
        this.location = location;
    }

    public Long getMadeInId() {
        return madeInId;
    }

    public void setMadeInId(Long madeInId) {
        this.madeInId= madeInId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName= bikeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
