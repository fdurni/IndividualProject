package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/5/2016.
 */
@Entity
@Table(name = "personprogramroutineexercise", schema = "trainingtracker")
public class PersonProgramRoutineExerciseEntity {
    private int exerciseId;
    private String numberOfSetsExecuted;
    private String numberOfRepsExecuted;
    private String weightExecuted;

    @Id
    @Column(name = "exerciseId")
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "numberOfSetsExecuted")
    public String getNumberOfSetsExecuted() {
        return numberOfSetsExecuted;
    }

    public void setNumberOfSetsExecuted(String numberOfSetsExecuted) {
        this.numberOfSetsExecuted = numberOfSetsExecuted;
    }

    @Basic
    @Column(name = "numberOfRepsExecuted")
    public String getNumberOfRepsExecuted() {
        return numberOfRepsExecuted;
    }

    public void setNumberOfRepsExecuted(String numberOfRepsExecuted) {
        this.numberOfRepsExecuted = numberOfRepsExecuted;
    }

    @Basic
    @Column(name = "weightExecuted")
    public String getWeightExecuted() {
        return weightExecuted;
    }

    public void setWeightExecuted(String weightExecuted) {
        this.weightExecuted = weightExecuted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonProgramRoutineExerciseEntity that = (PersonProgramRoutineExerciseEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (numberOfSetsExecuted != null ? !numberOfSetsExecuted.equals(that.numberOfSetsExecuted) : that.numberOfSetsExecuted != null)
            return false;
        if (numberOfRepsExecuted != null ? !numberOfRepsExecuted.equals(that.numberOfRepsExecuted) : that.numberOfRepsExecuted != null)
            return false;
        if (weightExecuted != null ? !weightExecuted.equals(that.weightExecuted) : that.weightExecuted != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + (numberOfSetsExecuted != null ? numberOfSetsExecuted.hashCode() : 0);
        result = 31 * result + (numberOfRepsExecuted != null ? numberOfRepsExecuted.hashCode() : 0);
        result = 31 * result + (weightExecuted != null ? weightExecuted.hashCode() : 0);
        return result;
    }
}
