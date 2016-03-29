package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "programroutines", schema = "trainingtracker", catalog = "")
public class ProgramroutinesEntity {
    private int programRoutinesId;
    private int routineId;
    private int programId;

    @Id
    @Column(name = "programRoutinesId")
    public int getProgramRoutinesId() {
        return programRoutinesId;
    }

    public void setProgramRoutinesId(int programRoutinesId) {
        this.programRoutinesId = programRoutinesId;
    }

    @Id
    @Column(name = "routineId")
    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
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

        ProgramroutinesEntity that = (ProgramroutinesEntity) o;

        if (programRoutinesId != that.programRoutinesId) return false;
        if (routineId != that.routineId) return false;
        return programId == that.programId;

    }

    @Override
    public int hashCode() {
        int result = programRoutinesId;
        result = 31 * result + routineId;
        result = 31 * result + programId;
        return result;
    }

    @Override
    public String toString() {
        return "ProgramroutinesEntity{" +
                "programRoutinesId=" + programRoutinesId +
                ", routineId=" + routineId +
                ", programId=" + programId +
                '}';
    }
}
