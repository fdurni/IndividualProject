package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.RoutinesEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface RoutinesEntityDao {

    /**
     * Return a list of all routines
     * @return all routines
     */
    public List<RoutinesEntity> getAllRoutines();

    /**
     * Get a routine by id
     * @param id to get
     */
    public RoutinesEntity getRoutine(Integer id);

    /**
     * Update a routine
     * @param routine to be updated
     */
    public void updateRoutine(RoutinesEntity routine);

    /**
     * Delete a routine
     *
     * @param routine to be deleted
     */
    public Boolean deleteRoutine(RoutinesEntity routine);

    /**
     * Add a routine
     *
     * @param routine to be added
     * @return id of the inserted routine
     */
    public int addRoutine(RoutinesEntity routine);
}
