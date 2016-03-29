package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.RoutineexercisesEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface RoutineExercisesEntityDao {

    /**
     * Return a list of all routineExercises
     * @return all routineExercises
     */
    public List<RoutineexercisesEntity> getAllRoutineExercises();

    /**
     * Get a routineExercise by id
     * @param id to get
     */
    public RoutineexercisesEntity getRoutineExercise(Integer id);

    /**
     * Update a routineExercise
     * @param routineExercise to be updated
     */
    public void updateRoutineExercise(RoutineexercisesEntity routineExercise);

    /**
     * Delete a routineExercise
     *
     * @param routineExercise to be deleted
     */
    public Boolean deleteRoutineExercise(RoutineexercisesEntity routineExercise);

    /**
     * Add a routineExercise
     *
     * @param routineExercise to be added
     * @return id of the inserted routineExercise
     */
    public int addRoutineExercise(RoutineexercisesEntity routineExercise);
}
