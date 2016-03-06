package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "personprogramroutine", schema = "trainingtracker")
public class PersonProgramRoutineEntity {
    private int personProgramRoutineId;

    @Id
    @Column(name = "personProgramRoutineId")
    public int getPersonProgramRoutineId() {
        return personProgramRoutineId;
    }

    public void setPersonProgramRoutineId(int personProgramRoutineId) {
        this.personProgramRoutineId = personProgramRoutineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonProgramRoutineEntity that = (PersonProgramRoutineEntity) o;

        if (personProgramRoutineId != that.personProgramRoutineId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return personProgramRoutineId;
    }
}
