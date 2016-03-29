package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramroutinesEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface ProgramRoutinesEntityDao {

    /**
     * Return a list of all programRoutines
     * @return all programRoutines
     */
    public List<ProgramroutinesEntity> getAllProgramRoutines();

    /**
     * Get a programRoutine by id
     * @param id to get
     */
    public ProgramroutinesEntity getProgramRoutine(Integer id);

    /**
     * Update a programRoutine
     * @param programRoutine to be updated
     */
    public void updateProgramRoutine(ProgramroutinesEntity programRoutine);

    /**
     * Delete a programRoutine
     *
     * @param programRoutine to be deleted
     */
    public Boolean deleteProgramRoutine(ProgramroutinesEntity programRoutine);

    /**
     * Add a programRoutine
     *
     * @param programRoutine to be added
     * @return id of the inserted programRoutine
     */
    public int addProgramRoutine(ProgramroutinesEntity programRoutine);
}
