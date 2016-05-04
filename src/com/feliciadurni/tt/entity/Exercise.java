package com.feliciadurni.tt.entity;

import java.util.Set;

/**
 * Created by felic on 3/29/2016.
 */
public class Exercise {
    private int exerciseId;
    private String exerciseName;
    private String exerciseType;
    private String exerciseDescription;
    private Set<RoutineExercise> exerciseRoutines;

    /**
     * Instantiates a new Exercise.
     */
    public Exercise() {}

    /**
     * Instantiates a new Exercise.
     *
     * @param exerciseId          the exercise id
     * @param exerciseName        the exercise name
     * @param exerciseType        the exercise type
     * @param exerciseDescription the exercise description
     */
    public Exercise(int exerciseId, String exerciseName, String exerciseType, String exerciseDescription) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.exerciseDescription = exerciseDescription;
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
     * Gets exercise name.
     *
     * @return the exercise name
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * Sets exercise name.
     *
     * @param exerciseName the exercise name
     */
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    /**
     * Gets exercise type.
     *
     * @return the exercise type
     */
    public String getExerciseType() {
        return exerciseType;
    }

    /**
     * Sets exercise type.
     *
     * @param exerciseType the exercise type
     */
    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    /**
     * Gets exercise description.
     *
     * @return the exercise description
     */
    public String getExerciseDescription() {
        return exerciseDescription;
    }

    /**
     * Sets exercise description.
     *
     * @param exerciseDescription the exercise description
     */
    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    /**
     * Gets exercise routines.
     *
     * @return the exercise routines
     */
    public Set<RoutineExercise> getExerciseRoutines() {
        return exerciseRoutines;
    }

    /**
     * Sets exercise routines.
     *
     * @param exerciseRoutines the exercise routines
     */
    public void setExerciseRoutines(Set<RoutineExercise> exerciseRoutines) {
        this.exerciseRoutines = exerciseRoutines;
    }

    /**
     * Add exercise routine.
     *
     * @param exerciseRoutine the exercise routine
     */
    public void addExerciseRoutine(RoutineExercise exerciseRoutine) {
        this.exerciseRoutines.add(exerciseRoutine);
    }
}
