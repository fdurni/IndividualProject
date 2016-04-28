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
        routine1.setWeek(4);
        routine1.setRoutineDescription("Routine-Description");

        Integer squatId = exerciseDao.getExerciseByName("Squat").getExerciseId();
        Exercise squat = exerciseDao.getExercise(squatId);

        Integer deadliftId = exerciseDao.getExerciseByName("Deadlift").getExerciseId();
        Exercise deadlift = exerciseDao.getExercise(deadliftId);

        Integer benchId = exerciseDao.getExerciseByName("Bench Press").getExerciseId();
        Exercise bench = exerciseDao.getExercise(benchId);

        RoutineExercise routineExercise1 = new RoutineExercise();
        routineExercise1.setRoutine(routine1);
        routineExercise1.setExercise(squat);
        routineExercise1.setExpectedSets(1);
        routineExercise1.setExpectedReps("1");
        routineExercise1.setExpectedWeight(225);
        routineExercise1.setActualSets(1);
        routineExercise1.setActualReps(1);
        routineExercise1.setActualWeight(225);

        RoutineExercise routineExercise2 = new RoutineExercise();
        routineExercise2.setRoutine(routine1);
        routineExercise2.setExercise(deadlift);
        routineExercise2.setExpectedSets(1);
        routineExercise2.setExpectedReps("1");
        routineExercise2.setExpectedWeight(325);
        routineExercise2.setActualSets(1);
        routineExercise2.setActualReps(1);
        routineExercise2.setActualWeight(325);

        RoutineExercise routineExercise3 = new RoutineExercise();
        routineExercise3.setRoutine(routine1);
        routineExercise3.setExercise(bench);
        routineExercise3.setExpectedSets(1);
        routineExercise3.setExpectedReps("1");
        routineExercise3.setExpectedWeight(130);
        routineExercise3.setActualSets(1);
        routineExercise3.setActualReps(1);
        routineExercise3.setActualWeight(130);

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