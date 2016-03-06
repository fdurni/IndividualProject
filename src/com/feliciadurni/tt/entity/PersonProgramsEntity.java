package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "personprograms", schema = "trainingtracker")
public class PersonProgramsEntity {
    private int personProgramId;

    @Id
    @Column(name = "personProgramId")
    public int getPersonProgramId() {
        return personProgramId;
    }

    public void setPersonProgramId(int personProgramId) {
        this.personProgramId = personProgramId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonProgramsEntity that = (PersonProgramsEntity) o;

        if (personProgramId != that.personProgramId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return personProgramId;
    }

}
