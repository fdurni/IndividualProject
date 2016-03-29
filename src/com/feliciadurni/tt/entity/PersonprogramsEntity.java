package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personprograms", schema = "trainingtracker", catalog = "")
public class PersonprogramsEntity {
    private int personProgramId;
    private int personId;
    private int programId;

    @Id
    @Column(name = "personProgramId")
    public int getPersonProgramId() {
        return personProgramId;
    }

    public void setPersonProgramId(int personProgramId) {
        this.personProgramId = personProgramId;
    }

    @Id
    @Column(name = "personId")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Id
    @Column(name = "programId")
    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonprogramsEntity that = (PersonprogramsEntity) o;

        if (personProgramId != that.personProgramId) return false;
        if (personId != that.personId) return false;
        return programId == that.programId;

    }

    @Override
    public int hashCode() {
        int result = personProgramId;
        result = 31 * result + personId;
        result = 31 * result + programId;
        return result;
    }

    @Override
    public String toString() {
        return "PersonprogramsEntity{" +
                "personProgramId=" + personProgramId +
                ", personId=" + personId +
                ", programId=" + programId +
                '}';
    }
}
