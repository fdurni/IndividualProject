package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.GoalsEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface GoalsEntityDao {

    /**
     * Return a list of all goals
     * @return all goals
     */
    public List<GoalsEntity> getAllGoals();

    /**
     * Get a goal by id
     * @param id to get
     */
    public GoalsEntity getGoal(Integer id);

    /**
     * Update a goal
     * @param goal to be updated
     */
    public void updateGoal(GoalsEntity goal);

    /**
     * Delete a goal
     *
     * @param goal to be deleted
     */
    public Boolean deleteGoal(GoalsEntity goal);

    /**
     * Add a personGoal
     *
     * @param goal to be added
     * @return id of the inserted goal
     */
    public int addGoal(GoalsEntity goal);
}
