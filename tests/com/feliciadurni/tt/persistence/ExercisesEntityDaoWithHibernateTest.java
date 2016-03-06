package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.ExercisesEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 3/6/2016.
 */
public class ExercisesEntityDaoWithHibernateTest {

    @Test
    public void testGetAllExercises() throws Exception {

        ExercisesEntityDaoWithHibernate dao = new ExercisesEntityDaoWithHibernate();
        List<ExercisesEntity> exercises = dao.getAllExercises();

        assertTrue("There is the wrong amount in the list", exercises.size() > 0);
    }

    @Test
    public void testGetExercise() throws Exception {

        ExercisesEntityDaoWithHibernate dao = new ExercisesEntityDaoWithHibernate();
        ExercisesEntity exercise = dao.getExercise(2);

        assertNotNull("Could not get exercise", exercise);
    }

    @Test
    public void testUpdateExercise() throws Exception {

        ExercisesEntityDaoWithHibernate dao = new ExercisesEntityDaoWithHibernate();
        ExercisesEntity exercise = new ExercisesEntity(2, "Deadlift", "Main", "Sumo Deadlift");

        dao.updateExercise(exercise);
        assertEquals("This is the wrong exercise", "Deadlift", exercise.getExerciseName());
    }

    @Test
    public void testDeleteExercise() throws Exception {

        ExercisesEntityDaoWithHibernate dao = new ExercisesEntityDaoWithHibernate();
        ExercisesEntity exercise = new ExercisesEntity();
        int sizeBefore;
        int sizeAfter;
        exercise.setExerciseName("Squat");
        exercise.setExerciseType("Main");
        exercise.setExerciseDescription("Barbell Back Squat");
        exercise.setExerciseId(1);
        sizeBefore = dao.getAllExercises().size();
        dao.deleteExercise(exercise);
        sizeAfter = dao.getAllExercises().size();

        assertTrue("The user was not deleted", sizeBefore > sizeAfter);
    }

    @Test
    public void testAddExercise() throws Exception {

        ExercisesEntityDaoWithHibernate dao = new ExercisesEntityDaoWithHibernate();
        int insertExerciseId = 0;

        //create user to add
        ExercisesEntity exercise = new ExercisesEntity();
        exercise.setExerciseName("Squat");
        exercise.setExerciseType("Main");
        exercise.setExerciseDescription("Barbell Back Squat");
        exercise.setExerciseId(1);

        insertExerciseId = dao.addExercise(exercise);

        assertTrue(insertExerciseId > 0);
    }
}
