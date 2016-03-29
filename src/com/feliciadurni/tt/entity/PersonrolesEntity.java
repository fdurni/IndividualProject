package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personroles", schema = "trainingtracker", catalog = "")
@IdClass(PersonrolesEntityPK.class)
public class PersonrolesEntity {
    private int personId;
    private String role;

    @Id
    @Column(name = "personId")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Id
    @Column(name = "role")
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

        PersonrolesEntity that = (PersonrolesEntity) o;

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
        return "PersonrolesEntity{" +
                "personId=" + personId +
                ", role='" + role + '\'' +
                '}';
    }
}
