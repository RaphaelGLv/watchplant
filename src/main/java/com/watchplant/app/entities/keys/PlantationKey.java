package com.watchplant.app.entities.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlantationKey implements Serializable {
    private String userEmail;
    private String name;

    public PlantationKey() {}

    public PlantationKey(String userEmail, String name) {
        this.userEmail = userEmail;
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlantationKey that)) return false;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, name);
    }
}
