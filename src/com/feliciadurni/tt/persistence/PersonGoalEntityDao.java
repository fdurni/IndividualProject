package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersongoalEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonGoalEntityDao {

    /**
     * Return a list of all persongoals
     * @return all personGoals
     */
    public List<PersongoalEntity> getAllPersonGoals();

    /**
     * Get a personGoal by id
     * @param id to get
     */
    public PersongoalEntity getPersonGoal(Integer id);

    /**
     * Update a personGoal
     * @param personGoal to be updated
     */
    public void updatePersonGoal(PersongoalEntity personGoal);

    /**
     * Delete a personGoal
     *
     * @param personGoal to be deleted
     */
    public Boolean deletePersonGoal(PersongoalEntity personGoal);

    /**
     * Add a personGoal
     *
     * @param personGoal to be added
     * @return id of the inserted personGoal
     */
    public int addPersonGoal(PersongoalEntity personGoal);
}
