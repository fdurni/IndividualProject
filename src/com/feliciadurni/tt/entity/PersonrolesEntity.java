package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personroles", schema = "trainingtracker", catalog = "")
@IdClass(PersonrolesEntityPK.class)
public class PersonrolesEntity {
    private String userName;
    private String role;
    private Integer personId;

    @Id
    @Column(name = "userName", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "role", nullable = false, length = 30)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "personId", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonrolesEntity that = (PersonrolesEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return personId != null ? personId.equals(that.personId) : that.personId == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonrolesEntity{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", personId=" + personId +
                '}';
    }
}
