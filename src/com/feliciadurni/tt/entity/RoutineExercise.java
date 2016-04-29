package com.feliciadurni.tt.entity;

import javax.persistence.Transient;

/**
 * Created by felic on 4/16/2016.
 */
public class RoutineExercise {

    private Integer routineexerciseId;
    private Integer exerciseId;
    private Integer routineId;
    private Integer expectedSets;
    private String expectedReps;
    private Integer expectedWeight;
    private Integer actualSets;
    private Integer actualReps;
    private Integer actualWeight;
    private Routine routine;
    private Exercise exercise;

    public RoutineExercise() {}

    public RoutineExercise(Integer routineexerciseId, Integer expectedSets, String expectedReps, Integer actualSets, Integer expectedWeight, Integer actualReps, Integer actualWeight) {
        this.routineexerciseId = routineexerciseId;
        this.expectedSets = expectedSets;
        this.expectedReps = expectedReps;
        this.actualSets = actualSets;
        this.expectedWeight = expectedWeight;
        this.actualReps = actualReps;
        this.actualWeight = actualWeight;
    }

    public Integer getRoutineexerciseId() {
        return routineexerciseId;
    }

    public void setRoutineexerciseId(Integer routineexerciseId) {
        this.routineexerciseId = routineexerciseId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public Integer getExpectedSets() {
        return expectedSets;
    }

    public void setExpectedSets(Integer expectedSets) {
        this.expectedSets = expectedSets;
    }

    public String getExpectedReps() {
        return expectedReps;
    }

    public void setExpectedReps(String expectedReps) {
        this.expectedReps = expectedReps;
    }

    public Integer getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(Integer expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    public Integer getActualSets() {
        return actualSets;
    }

    public void setActualSets(Integer actualSets) {
        this.actualSets = actualSets;
    }

    public Integer getActualReps() {
        return actualReps;
    }

    public void setActualReps(Integer actualReps) {
        this.actualReps = actualReps;
    }

    public Integer getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Integer actualWeight) {
        this.actualWeight = actualWeight;
    }

    @Transient
    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    @Transient
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public String toString() {
        return "RoutineExercise{" +
                "routineexerciseId=" + routineexerciseId +
                ", exerciseId=" + exerciseId +
                ", routineId=" + routineId +
                ", expectedSets=" + expectedSets +
                ", expectedReps='" + expectedReps + '\'' +
                ", expectedWeight=" + expectedWeight +
                '}';
    }
}
