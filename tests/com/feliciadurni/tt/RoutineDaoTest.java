package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.ProgramDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/16/2016.
 */
public class RoutineDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetAllRoutines() throws Exception {

        RoutineDao dao = new RoutineDao();
        List<Routine> routines = dao.getAllRoutines();

        assertTrue("There is the wrong amount in the list", routines.size() > 0);
    }

    @Test
    public void testGetRoutine() throws Exception {

        RoutineDao dao = new RoutineDao();
        Routine routine = dao.getRoutine(5);
        assertNotNull("Could not get routine", routine);
    }

    @Test
    public void testUpdateRoutine() throws Exception {

        RoutineDao dao = new RoutineDao();
        Routine routine = new Routine();
        routine.setRoutineId(1);
        routine.setDay(1);
        routine.setRoutineName("Updated-Routine-Name");
        routine.setWeek(1);
        routine.setRoutineDescription("Updated-Routine-Description");

        dao.updateRoutine(routine);
        assertNotNull("Could not update routine", routine.getRoutineId());
    }

    @Test
    public void testDeleteRoutine() throws Exception {

        RoutineDao dao = new RoutineDao();
        Routine routine = new Routine();
        routine.setRoutineId(6);

        Boolean routineDeleted = dao.deleteRoutine(routine);
        assertTrue(routineDeleted);
    }

    @Test
    public void testAddRoutine() throws Exception {

        RoutineDao dao = new RoutineDao();
        int insertRoutineId = 0;

        Routine routine = new Routine();
        routine.setDay(1);
        routine.setRoutineName("Routine-Name");
        routine.setWeek(1);
        routine.setRoutineDescription("Routine-Description");

        insertRoutineId = dao.addRoutine(routine);

        assertTrue(insertRoutineId > 0);
    }
}
