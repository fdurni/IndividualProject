package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "programroutineexercise", schema = "trainingtracker")
public class ProgramRoutineExerciseEntity {
    private int programRoutineExerciseId;
    private String defaultSets;
    private String defaultReps;
    private String defaultWeight;

    @Id
    @Column(name = "programRoutineExerciseId")
    public int getProgramRoutineExerciseId() {
        return programRoutineExerciseId;
    }

    public void setProgramRoutineExerciseId(int programRoutineExerciseId) {
        this.programRoutineExerciseId = programRoutineExerciseId;
    }

    @Basic
    @Column(name = "defaultSets")
    public String getDefaultSets() {
        return defaultSets;
    }

    public void setDefaultSets(String defaultSets) {
        this.defaultSets = defaultSets;
    }

    @Basic
    @Column(name = "defaultReps")
    public String getDefaultReps() {
        return defaultReps;
    }

    public void setDefaultReps(String defaultReps) {
        this.defaultReps = defaultReps;
    }

    @Basic
    @Column(name = "defaultWeight")
    public String getDefaultWeight() {
        return defaultWeight;
    }

    public void setDefaultWeight(String defaultWeight) {
        this.defaultWeight = defaultWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramRoutineExerciseEntity that = (ProgramRoutineExerciseEntity) o;

        if (programRoutineExerciseId != that.programRoutineExerciseId) return false;
        if (defaultSets != null ? !defaultSets.equals(that.defaultSets) : that.defaultSets != null) return false;
        if (defaultReps != null ? !defaultReps.equals(that.defaultReps) : that.defaultReps != null) return false;
        if (defaultWeight != null ? !defaultWeight.equals(that.defaultWeight) : that.defaultWeight != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = programRoutineExerciseId;
        result = 31 * result + (defaultSets != null ? defaultSets.hashCode() : 0);
        result = 31 * result + (defaultReps != null ? defaultReps.hashCode() : 0);
        result = 31 * result + (defaultWeight != null ? defaultWeight.hashCode() : 0);
        return result;
    }
}
