package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramroutineEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonProgramRoutineEntityDao {

    /**
     * Return a list of all personProgramRoutines
     * @return all personProgramRoutines
     */
    public List<PersonprogramroutineEntity> getAllPersonProgramRoutines();

    /**
     * Get a personProgramRoutine by id
     * @param id to get
     */
    public PersonprogramroutineEntity getPersonProgramRoutine(Integer id);

    /**
     * Update a personProgramRoutine
     * @param personProgramRoutine to be updated
     */
    public void updatePersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine);

    /**
     * Delete a personProgramRoutine
     *
     * @param personProgramRoutine to be deleted
     */
    public Boolean deletePersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine);

    /**
     * Add a personProgramRoutine
     *
     * @param personProgramRoutine to be added
     * @return id of the inserted personProgramRoutine
     */
    public int addPersonProgramRoutine(PersonprogramroutineEntity personProgramRoutine);
}
