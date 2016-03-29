package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by felic on 3/29/2016.
 */
public class PersonrolesEntityPK implements Serializable {
    private int personId;
    private String role;

    @Column(name = "personId")
    @Id
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Column(name = "role")
    @Id
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonrolesEntityPK that = (PersonrolesEntityPK) o;

        if (personId != that.personId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonrolesEntityPK{" +
                "personId=" + personId +
                ", role='" + role + '\'' +
                '}';
    }
}
