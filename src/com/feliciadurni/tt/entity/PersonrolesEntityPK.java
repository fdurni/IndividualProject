package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by felic on 3/29/2016.
 */
public class PersonrolesEntityPK implements Serializable {
    private String userName;
    private String role;

    @Column(name = "userName", nullable = false, length = 30)
    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "role", nullable = false, length = 30)
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
