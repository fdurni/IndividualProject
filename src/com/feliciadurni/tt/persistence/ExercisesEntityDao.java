package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ExercisesEntity;
import com.feliciadurni.tt.entity.PersonEntity;

import java.util.List;

/**
 * Created by felic on 3/6/2016.
 */
public interface ExercisesEntityDao {

    /**
     * Return a list of all exercises
     * @return all exercises
     */
    public List<ExercisesEntity> getAllExercises();

    /**
     * Get an exercise by id
     * @param id to get
     */
    public ExercisesEntity getExercise(Integer id);

    /**
     * Update an exercise
     * @param exercise to be updated
     */
    public void updateExercise(ExercisesEntity exercise);

    /**
     * Delete an exercise
     *
     * @param exercise to be deleted
     */
    public Boolean deleteExercise(ExercisesEntity exercise);

    /**
     * Add an exercise
     *
     * @param exercise to be added
     * @return id of the inserted exercise
     */
    public int addExercise(ExercisesEntity exercise);

}
