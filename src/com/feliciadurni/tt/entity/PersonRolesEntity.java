package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "personroles", schema = "trainingtracker")
@IdClass(PersonRolesEntityPK.class)
public class PersonRolesEntity {
    private String userName;
    private String role;

    @Id
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

        PersonRolesEntity that = (PersonRolesEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
