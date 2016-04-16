package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.RoutineExercise;
import com.feliciadurni.tt.persistence.RoutineExerciseDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/16/2016.
 */
public class RoutineExerciseDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetAllRoutineExercises() throws Exception {

        RoutineExerciseDao dao = new RoutineExerciseDao();
        List<RoutineExercise> routineExercises = dao.getAllRoutineExercises();

        assertTrue("There is the wrong amount in the list", routineExercises.size() > 0);
    }

    @Test
    public void testGetRoutineExercise() throws Exception {

        RoutineExerciseDao dao = new RoutineExerciseDao();
        RoutineExercise routineExercise = dao.getRoutineExercise(5);
        assertNotNull("Could not get routineExercise", routineExercise);
    }

    @Test
    public void testUpdateRoutineExercise() throws Exception {

        RoutineExerciseDao dao = new RoutineExerciseDao();
        RoutineExercise routineExercise = new RoutineExercise();
        routineExercise.setRoutineexerciseId(1);
        routineExercise.setExpectedSets(2);
        routineExercise.setExpectedReps("2");
        routineExercise.setExpectedWeight(100);
        routineExercise.setActualSets(2);
        routineExercise.setActualReps(2);
        routineExercise.setActualWeight(100);

        dao.updateRoutineExercise(routineExercise);
        assertNotNull("Could not update routineExercise", routineExercise.getRoutineexerciseId());
    }

    @Test
    public void testDeleteRoutineExercise() throws Exception {

        RoutineExerciseDao dao = new RoutineExerciseDao();
        RoutineExercise routineExercise = new RoutineExercise();
        routineExercise.setRoutineexerciseId(1);

        Boolean routineExerciseDeleted = dao.deleteRoutineExercise(routineExercise);
        assertTrue(routineExerciseDeleted);
    }

    @Test
    public void testAddRoutineExercise() throws Exception {

        RoutineExerciseDao dao = new RoutineExerciseDao();
        int insertRoutineExerciseId = 0;

        RoutineExercise routineExercise = new RoutineExercise();
        routineExercise.setExpectedSets(1);
        routineExercise.setExpectedReps("1");
        routineExercise.setExpectedWeight(100);
        routineExercise.setActualSets(1);
        routineExercise.setActualReps(1);
        routineExercise.setActualWeight(100);

        insertRoutineExerciseId = dao.addRoutineExercise(routineExercise);

        assertTrue(insertRoutineExerciseId > 0);
    }
}
