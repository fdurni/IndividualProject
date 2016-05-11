package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Exercise;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.entity.RoutineExercise;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import com.feliciadurni.tt.persistence.RoutineExerciseDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/16/2016.
 */
public class ExerciseDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    ExerciseDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new ExerciseDao();
    }

    @Test
    public void testGetAllExercises() throws Exception {

        List<Exercise> exercises = dao.getAllExercises();

        assertTrue("There is the wrong amount in the list", exercises.size() > 0);
    }

    @Test
    public void testGetExercise() throws Exception {

        Exercise exercise = dao.getExercise(19);
        assertNotNull("Could not get exercise", exercise);
    }

    @Test
    public void testGetExerciseByName() throws Exception {

        Exercise exercise = dao.getExerciseByName("Squat");
        RoutineExerciseDao routineExerciseDao = new RoutineExerciseDao();

        //RoutineExercise routineExercise = routineExerciseDao.getRoutineExercise(exercise.getExerciseId());
        log.info(exercise);

        assertNotNull("Could not get exercise", exercise);
    }

    @Test
    public void testUpdateExercise() throws Exception {

        Exercise exercise = new Exercise();
        exercise.setExerciseId(20);
        exercise.setExerciseName("Updated-Exercise-Name");
        exercise.setExerciseType("Updated-Exercise-Type");
        exercise.setExerciseDescription("Updated-Exercise-Description");

        dao.updateExercise(exercise);
        assertNotNull("Could not update exercise", exercise.getExerciseId());
    }

    @Test
    public void testDeleteExercise() throws Exception {

        Exercise exercise = new Exercise();
        exercise.setExerciseId(25);

        Boolean exerciseDeleted = dao.deleteExercise(exercise);
        assertTrue(exerciseDeleted);
    }

    @Test
    public void testAddExercise() throws Exception {

        int insertExerciseId = 0;

        Exercise exercise = new Exercise();
        exercise.setExerciseName("Exercise-Name");
        exercise.setExerciseType("Exercise-Type");
        exercise.setExerciseDescription("Exercise-Description");

        insertExerciseId = dao.addExercise(exercise);

        assertTrue(insertExerciseId > 0);
    }
}
