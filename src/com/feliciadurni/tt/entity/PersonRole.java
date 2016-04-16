package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
public class PersonRole {
    private String userName;
    private String role;
    private Integer personId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
