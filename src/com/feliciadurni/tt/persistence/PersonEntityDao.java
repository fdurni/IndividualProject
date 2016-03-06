package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonEntity;

import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public interface PersonEntityDao {
    /**
     * Return a list of all people
     * @return all people
     */
    public List<PersonEntity> getAllPeople();

    /**
     * Get a person by id
     * @param id to get
     */
    public PersonEntity getPerson(Integer id);

    /**
     * Update a person
     * @param person to be updated
     */
    public void updatePerson(PersonEntity person);

    /**
     * Delete a person
     *
     * @param person to be deleted
     */
    public Boolean deletePerson(PersonEntity person);

    /**
     * Add a person
     *
     * @param person to be added
     * @return id of the inserted person
     */
    public int addPerson(PersonEntity person);

}
