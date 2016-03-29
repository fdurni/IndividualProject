package com.feliciadurni.tt.entity;

import javax.persistence.*;

/**
 * Created by felic on 3/29/2016.
 */
@Entity
@Table(name = "personprogramroutineexercise", schema = "trainingtracker", catalog = "")
public class PersonprogramroutineexerciseEntity {
    private int exerciseId;
    private String expectedReps;
    private int expectedSets;
    private int expectedWeight;
    private int actualReps;
    private int actualSets;
    private int actualWeight;
    private int personProgramRoutineId;
    private int programRoutineExerciseId;

    @Id
    @Column(name = "exerciseId")
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "expectedReps")
    public String getExpectedReps() {
        return expectedReps;
    }

    public void setExpectedReps(String expectedReps) {
        this.expectedReps = expectedReps;
    }

    @Basic
    @Column(name = "expectedSets")
    public int getExpectedSets() {
        return expectedSets;
    }

    public void setExpectedSets(int expectedSets) {
        this.expectedSets = expectedSets;
    }

    @Basic
    @Column(name = "expectedWeight")
    public int getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(int expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    @Basic
    @Column(name = "actualReps")
    public int getActualReps() {
        return actualReps;
    }

    public void setActualReps(int actualReps) {
        this.actualReps = actualReps;
    }

    @Basic
    @Column(name = "actualSets")
    public int getActualSets() {
        return actualSets;
    }

    public void setActualSets(int actualSets) {
        this.actualSets = actualSets;
    }

    @Basic
    @Column(name = "actualWeight")
    public int getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(int actualWeight) {
        this.actualWeight = actualWeight;
    }

    @Basic
    @Column(name = "programRoutineExerciseId")
    public int getProgramRoutineExerciseId() {
        return programRoutineExerciseId;
    }

    public void setProgramRoutineExerciseId(int programRoutineExerciseId) {
        this.programRoutineExerciseId = programRoutineExerciseId;
    }

    @Basic
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

        PersonprogramroutineexerciseEntity that = (PersonprogramroutineexerciseEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (expectedSets != that.expectedSets) return false;
        if (expectedWeight != that.expectedWeight) return false;
        if (actualReps != that.actualReps) return false;
        if (actualSets != that.actualSets) return false;
        if (actualWeight != that.actualWeight) return false;
        if (personProgramRoutineId != that.personProgramRoutineId) return false;
        if (programRoutineExerciseId != that.programRoutineExerciseId) return false;
        return expectedReps != null ? expectedReps.equals(that.expectedReps) : that.expectedReps == null;

    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + (expectedReps != null ? expectedReps.hashCode() : 0);
        result = 31 * result + expectedSets;
        result = 31 * result + expectedWeight;
        result = 31 * result + actualReps;
        result = 31 * result + actualSets;
        result = 31 * result + actualWeight;
        result = 31 * result + personProgramRoutineId;
        result = 31 * result + programRoutineExerciseId;
        return result;
    }

    @Override
    public String toString() {
        return "PersonprogramroutineexerciseEntity{" +
                "exerciseId=" + exerciseId +
                ", expectedReps='" + expectedReps + '\'' +
                ", expectedSets=" + expectedSets +
                ", expectedWeight=" + expectedWeight +
                ", actualReps=" + actualReps +
                ", actualSets=" + actualSets +
                ", actualWeight=" + actualWeight +
                ", personProgramRoutineId=" + personProgramRoutineId +
                ", programRoutineExerciseId=" + programRoutineExerciseId +
                '}';
    }
}
