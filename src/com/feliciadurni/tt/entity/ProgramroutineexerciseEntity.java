package com.feliciadurni.tt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "programroutineexercise", schema = "trainingtracker", catalog = "")
public class ProgramroutineexerciseEntity {
    private int programRoutineExerciseId;
    private int programRoutinesId;
    private int routineExercisesId;

    @Id
    @Column(name = "programRoutineExerciseId")
    public int getProgramRoutineExerciseId() {
        return programRoutineExerciseId;
    }

    public void setProgramRoutineExerciseId(int programRoutineExerciseId) {
        this.programRoutineExerciseId = programRoutineExerciseId;
    }

    @Id
    @Column(name = "programRoutinesId")
    public int getProgramRoutinesId() {
        return programRoutinesId;
    }

    public void setProgramRoutinesId(int programRoutinesId) {
        this.programRoutinesId = programRoutinesId;
    }

    @Id
    @Column(name = "routineExercisesId")
    public int getRoutineExercisesId() {
        return routineExercisesId;
    }

    public void setRoutineExercisesId(int routineExercisesId) {
        this.routineExercisesId = routineExercisesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramroutineexerciseEntity that = (ProgramroutineexerciseEntity) o;

        if (programRoutineExerciseId != that.programRoutineExerciseId) return false;
        if (programRoutinesId != that.programRoutinesId) return false;
        return routineExercisesId == that.routineExercisesId;

    }

    @Override
    public int hashCode() {
        int result = programRoutineExerciseId;
        result = 31 * result + programRoutinesId;
        result = 31 * result + routineExercisesId;
        return result;
    }

    @Override
    public String toString() {
        return "ProgramroutineexerciseEntity{" +
                "programRoutineExerciseId=" + programRoutineExerciseId +
                ", programRoutinesId=" + programRoutinesId +
                ", routineExercisesId=" + routineExercisesId +
                '}';
    }
}
