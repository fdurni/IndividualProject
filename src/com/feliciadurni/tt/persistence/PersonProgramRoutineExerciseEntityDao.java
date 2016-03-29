package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramroutineexerciseEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonProgramRoutineExerciseEntityDao {

    /**
     * Return a list of all personProgramRoutineExercises
     * @return all personProgramRoutineExercises
     */
    public List<PersonprogramroutineexerciseEntity> getAllPersonProgramRoutineExercises();

    /**
     * Get a personProgramRoutineExercise by id
     * @param id to get
     */
    public PersonprogramroutineexerciseEntity getPersonProgramRoutineExercise(Integer id);

    /**
     * Update a personProgramRoutineExercise
     * @param personProgramRoutineExercise to be updated
     */
    public void updatePersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise);

    /**
     * Delete a personProgramRoutineExercise
     *
     * @param personProgramRoutineExercise to be deleted
     */
    public Boolean deletePersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise);

    /**
     * Add a personProgramRoutineExercise
     *
     * @param personProgramRoutineExercise to be added
     * @return id of the inserted personProgramRoutineExercise
     */
    public int addPersonProgramRoutineExercise(PersonprogramroutineexerciseEntity personProgramRoutineExercise);
}
