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

    public Exercise() {}

    public Exercise(int exerciseId, String exerciseName, String exerciseType, String exerciseDescription) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.exerciseDescription = exerciseDescription;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public Set<RoutineExercise> getExerciseRoutines() {
        return exerciseRoutines;
    }

    public void setExerciseRoutines(Set<RoutineExercise> exerciseRoutines) {
        this.exerciseRoutines = exerciseRoutines;
    }

    public void addExerciseRoutine(RoutineExercise exerciseRoutine) {
        this.exerciseRoutines.add(exerciseRoutine);
    }
}
