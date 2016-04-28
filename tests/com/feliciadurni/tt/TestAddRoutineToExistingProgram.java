package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Exercise;
import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.entity.RoutineExercise;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/10/2016.
 */
public class TestAddRoutineToExistingProgram {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testAddRoutineToExistingProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int sizeBefore;
        int sizeAfter;

        Program program = dao.getProgram(56);

        sizeBefore = program.getRoutines().size();

        Routine routine1 = new Routine();
        routine1.setDay(1);
        routine1.setRoutineName("Routine-Name");
        routine1.setWeek(1);
        routine1.setRoutineDescription("Routine-Description");

        Exercise exercise1 = new Exercise();
        exercise1.setExerciseName("Squat");
        exercise1.setExerciseType("T1");
        exercise1.setExerciseDescription("Barbell Back Squat");
        exerciseDao.addExercise(exercise1);

        Exercise exercise2 = new Exercise();
        exercise2.setExerciseName("Sumo Deadlift");
        exercise2.setExerciseType("T1");
        exercise2.setExerciseDescription("Sumo Deadlift");
        exerciseDao.addExercise(exercise2);

        Exercise exercise3 = new Exercise();
        exercise3.setExerciseName("Bench Press");
        exercise3.setExerciseType("T1");
        exercise3.setExerciseDescription("Bench Press");
        exerciseDao.addExercise(exercise3);

        RoutineExercise routineExercise1 = new RoutineExercise();
        routineExercise1.setRoutine(routine1);
        routineExercise1.setExercise(exercise1);
        routineExercise1.setExpectedSets(1);
        routineExercise1.setExpectedReps("1");
        routineExercise1.setExpectedWeight(100);
        routineExercise1.setActualSets(1);
        routineExercise1.setActualReps(1);
        routineExercise1.setActualWeight(100);

        RoutineExercise routineExercise2 = new RoutineExercise();
        routineExercise2.setRoutine(routine1);
        routineExercise2.setExercise(exercise2);
        routineExercise2.setExpectedSets(1);
        routineExercise2.setExpectedReps("1");
        routineExercise2.setExpectedWeight(100);
        routineExercise2.setActualSets(1);
        routineExercise2.setActualReps(1);
        routineExercise2.setActualWeight(100);

        RoutineExercise routineExercise3 = new RoutineExercise();
        routineExercise3.setRoutine(routine1);
        routineExercise3.setExercise(exercise3);
        routineExercise3.setExpectedSets(1);
        routineExercise3.setExpectedReps("1");
        routineExercise3.setExpectedWeight(100);
        routineExercise3.setActualSets(1);
        routineExercise3.setActualReps(1);
        routineExercise3.setActualWeight(100);

        Set<Routine> routines = new HashSet<Routine>();
        routines.add(routine1);
        program.setRoutines(routines);

        Set<RoutineExercise> routineExercises = new HashSet<RoutineExercise>();
        routineExercises.add(routineExercise1);
        routineExercises.add(routineExercise2);
        routineExercises.add(routineExercise3);
        routine1.setRoutineExercises(routineExercises);

        dao.updateProgram(program);

        sizeAfter = program.getRoutines().size();

        assertTrue("The routines were not added", sizeBefore < sizeAfter);
    }
}