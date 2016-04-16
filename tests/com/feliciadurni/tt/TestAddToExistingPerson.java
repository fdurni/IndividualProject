package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/10/2016.
 */
public class TestAddToExistingPerson {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testAddToExistingPerson() throws Exception {

        PersonDao dao = new PersonDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int sizeBefore;
        int sizeAfter;

        Person person = dao.getPerson(1);

        sizeBefore = person.getPrograms().size();

        Program program1 = new Program();
        program1.setProgramName("Program-Name");
        program1.setProgramType("Program-Type");
        program1.setProgramDescription("Program-Description");
        person.addProgram(program1);

        Routine routine1 = new Routine();
        routine1.setDay(1);
        routine1.setRoutineName("Routine-Name");
        routine1.setWeek(1);
        routine1.setRoutineDescription("Routine-Description");

        Exercise exercise1 = new Exercise();
        exercise1.setExerciseName("Exercise-Name");
        exercise1.setExerciseType("Exercise-Type");
        exercise1.setExerciseDescription("Exercise-Description");
        exerciseDao.addExercise(exercise1);

        RoutineExercise routineExercise1 = new RoutineExercise();
        routineExercise1.setRoutine(routine1);
        routineExercise1.setExercise(exercise1);
        routineExercise1.setExpectedSets(1);
        routineExercise1.setExpectedReps("1");
        routineExercise1.setExpectedWeight(100);
        routineExercise1.setActualSets(1);
        routineExercise1.setActualReps(1);
        routineExercise1.setActualWeight(100);

        Set<Routine> routines = new HashSet<Routine>();
        routines.add(routine1);
        program1.setRoutines(routines);

        Set<RoutineExercise> routineExercises = new HashSet<RoutineExercise>();
        routineExercises.add(routineExercise1);
        routine1.setRoutineExercises(routineExercises);

        dao.updatePerson(person);

        sizeAfter = person.getPrograms().size();

        assertTrue("The programs were not added", sizeBefore < sizeAfter);
    }
}