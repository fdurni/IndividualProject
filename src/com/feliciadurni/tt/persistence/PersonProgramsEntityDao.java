package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonprogramsEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonProgramsEntityDao {

    /**
     * Return a list of all personPrograms
     * @return all personPrograms
     */
    public List<PersonprogramsEntity> getAllPersonPrograms();

    /**
     * Get a personProgram by id
     * @param id to get
     */
    public PersonprogramsEntity getPersonProgram(Integer id);

    /**
     * Update a personProgram
     * @param personProgram to be updated
     */
    public void updatePersonProgram(PersonprogramsEntity personProgram);

    /**
     * Delete a personProgram
     *
     * @param personProgram to be deleted
     */
    public Boolean deletePersonProgram(PersonprogramsEntity personProgram);

    /**
     * Add a personProgram
     *
     * @param personProgram to be added
     * @return id of the inserted personProgram
     */
    public int addPersonProgram(PersonprogramsEntity personProgram);
}
