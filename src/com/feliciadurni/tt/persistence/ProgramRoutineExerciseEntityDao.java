package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ProgramroutineexerciseEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface ProgramRoutineExerciseEntityDao {

    /**
     * Return a list of all programRoutineExercises
     * @return all programRoutineExercises
     */
    public List<ProgramroutineexerciseEntity> getAllProgramRoutineExercises();

    /**
     * Get a programRoutineExercise by id
     * @param id to get
     */
    public ProgramroutineexerciseEntity getProgramRoutineExercise(Integer id);

    /**
     * Update a programRoutineExercise
     * @param programRoutineExercise to be updated
     */
    public void updateProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise);

    /**
     * Delete a programRoutineExercise
     *
     * @param programRoutineExercise to be deleted
     */
    public Boolean deleteProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise);

    /**
     * Add a programRoutineExercise
     *
     * @param programRoutineExercise to be added
     * @return id of the inserted programRoutineExercise
     */
    public int addProgramRoutineExercise(ProgramroutineexerciseEntity programRoutineExercise);
}
