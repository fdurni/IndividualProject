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

    /**
     * Instantiates a new Routine exercise.
     */
    public RoutineExercise() {}

    /**
     * Instantiates a new Routine exercise.
     *
     * @param routineexerciseId the routineexercise id
     * @param expectedSets      the expected sets
     * @param expectedReps      the expected reps
     * @param actualSets        the actual sets
     * @param expectedWeight    the expected weight
     * @param actualReps        the actual reps
     * @param actualWeight      the actual weight
     */
    public RoutineExercise(Integer routineexerciseId, Integer expectedSets, String expectedReps, Integer actualSets, Integer expectedWeight, Integer actualReps, Integer actualWeight) {
        this.routineexerciseId = routineexerciseId;
        this.expectedSets = expectedSets;
        this.expectedReps = expectedReps;
        this.actualSets = actualSets;
        this.expectedWeight = expectedWeight;
        this.actualReps = actualReps;
        this.actualWeight = actualWeight;
    }

    /**
     * Gets routineexercise id.
     *
     * @return the routineexercise id
     */
    public Integer getRoutineexerciseId() {
        return routineexerciseId;
    }

    /**
     * Sets routineexercise id.
     *
     * @param routineexerciseId the routineexercise id
     */
    public void setRoutineexerciseId(Integer routineexerciseId) {
        this.routineexerciseId = routineexerciseId;
    }

    /**
     * Gets exercise id.
     *
     * @return the exercise id
     */
    public int getExerciseId() {
        return exerciseId;
    }

    /**
     * Sets exercise id.
     *
     * @param exerciseId the exercise id
     */
    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    /**
     * Gets routine id.
     *
     * @return the routine id
     */
    public int getRoutineId() {
        return routineId;
    }

    /**
     * Sets routine id.
     *
     * @param routineId the routine id
     */
    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    /**
     * Gets expected sets.
     *
     * @return the expected sets
     */
    public Integer getExpectedSets() {
        return expectedSets;
    }

    /**
     * Sets expected sets.
     *
     * @param expectedSets the expected sets
     */
    public void setExpectedSets(Integer expectedSets) {
        this.expectedSets = expectedSets;
    }

    /**
     * Gets expected reps.
     *
     * @return the expected reps
     */
    public String getExpectedReps() {
        return expectedReps;
    }

    /**
     * Sets expected reps.
     *
     * @param expectedReps the expected reps
     */
    public void setExpectedReps(String expectedReps) {
        this.expectedReps = expectedReps;
    }

    /**
     * Gets expected weight.
     *
     * @return the expected weight
     */
    public Integer getExpectedWeight() {
        return expectedWeight;
    }

    /**
     * Sets expected weight.
     *
     * @param expectedWeight the expected weight
     */
    public void setExpectedWeight(Integer expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    /**
     * Gets actual sets.
     *
     * @return the actual sets
     */
    public Integer getActualSets() {
        return actualSets;
    }

    /**
     * Sets actual sets.
     *
     * @param actualSets the actual sets
     */
    public void setActualSets(Integer actualSets) {
        this.actualSets = actualSets;
    }

    /**
     * Gets actual reps.
     *
     * @return the actual reps
     */
    public Integer getActualReps() {
        return actualReps;
    }

    /**
     * Sets actual reps.
     *
     * @param actualReps the actual reps
     */
    public void setActualReps(Integer actualReps) {
        this.actualReps = actualReps;
    }

    /**
     * Gets actual weight.
     *
     * @return the actual weight
     */
    public Integer getActualWeight() {
        return actualWeight;
    }

    /**
     * Sets actual weight.
     *
     * @param actualWeight the actual weight
     */
    public void setActualWeight(Integer actualWeight) {
        this.actualWeight = actualWeight;
    }

    /**
     * Gets routine.
     *
     * @return the routine
     */
    @Transient
    public Routine getRoutine() {
        return routine;
    }

    /**
     * Sets routine.
     *
     * @param routine the routine
     */
    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    /**
     * Gets exercise.
     *
     * @return the exercise
     */
    @Transient
    public Exercise getExercise() {
        return exercise;
    }

    /**
     * Sets exercise.
     *
     * @param exercise the exercise
     */
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
