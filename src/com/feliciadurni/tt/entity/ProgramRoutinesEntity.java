package com.feliciadurni.tt.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "programroutines", schema = "trainingtracker")
public class ProgramRoutinesEntity {
    private int programRoutinesId;

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

        ProgramRoutinesEntity that = (ProgramRoutinesEntity) o;

        if (programRoutinesId != that.programRoutinesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return programRoutinesId;
    }

}
