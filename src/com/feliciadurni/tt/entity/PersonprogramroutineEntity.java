package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personprogramroutine", schema = "trainingtracker", catalog = "")
public class PersonprogramroutineEntity {
    private int personProgramRoutineId;
    private int personProgramId;
    private int programRoutinesId;

    @Id
    @Column(name = "personProgramRoutineId")
    public int getPersonProgramRoutineId() {
        return personProgramRoutineId;
    }

    public void setPersonProgramRoutineId(int personProgramRoutineId) {
        this.personProgramRoutineId = personProgramRoutineId;
    }

    @Id
    @Column(name = "personProgramId")
    public int getPersonProgramId() {
        return personProgramId;
    }

    public void setPersonProgramId(int personProgramId) {
        this.personProgramId = personProgramId;
    }

    @Id
    @Column(name = "programRoutinesId")
    public int getProgramRoutinesId() {
        return programRoutinesId;
    }

    public void setProgramRoutinesId(int programRoutinesId) {
        this.programRoutinesId = programRoutinesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonprogramroutineEntity that = (PersonprogramroutineEntity) o;

        if (personProgramRoutineId != that.personProgramRoutineId) return false;
        if (personProgramId != that.personProgramId) return false;
        return programRoutinesId == that.programRoutinesId;

    }

    @Override
    public int hashCode() {
        int result = personProgramRoutineId;
        result = 31 * result + personProgramId;
        result = 31 * result + programRoutinesId;
        return result;
    }

    @Override
    public String toString() {
        return "PersonprogramroutineEntity{" +
                "personProgramRoutineId=" + personProgramRoutineId +
                ", personProgramId=" + personProgramId +
                ", programRoutinesId=" + programRoutinesId +
                '}';
    }
}
