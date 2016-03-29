package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramsEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface ProgramsEntityDao {

    /**
     * Return a list of all programs
     * @return all programs
     */
    public List<ProgramsEntity> getAllPrograms();

    /**
     * Get an program by id
     * @param id to get
     */
    public ProgramsEntity getProgram(Integer id);

    /**
     * Update an program
     * @param program to be updated
     */
    public void updateProgram(ProgramsEntity program);

    /**
     * Delete an program
     *
     * @param program to be deleted
     */
    public Boolean deleteProgram(ProgramsEntity program);

    /**
     * Add an program
     *
     * @param program to be added
     * @return id of the inserted program
     */
    public int addProgram(ProgramsEntity program);
}
