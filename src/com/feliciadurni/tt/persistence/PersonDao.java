package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;

import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public interface PersonDao {
    /**
     * Return a list of all people
     * @return all people
     */
    public List<Person> getAllPeople();

    /**
     * Update a person
     * @param person to be updated
     */
    public void updatePerson(Person person);

    /**
     * Delete a person
     *
     *  @param person to be deleted
     */
    public void deletePerson(Person person);

    /**
     * Add a person
     *
     * @param person to be added
     * @return id of the inserted person
     */
    public int addPerson(Person person);

}
