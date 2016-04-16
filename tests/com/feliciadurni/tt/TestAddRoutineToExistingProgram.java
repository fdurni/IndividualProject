package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/10/2016.
 */
public class TestAddRoutineToExistingProgram {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testAddRoutineToExistingProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        int sizeBefore;
        int sizeAfter;

        Program program = dao.getProgram(11);

        sizeBefore = program.getRoutines().size();

        Routine routine1 = new Routine();
        routine1.setDay(1);
        routine1.setRoutineName("Routine-Name");
        routine1.setWeek(1);
        routine1.setRoutineDescription("Routine-Description");
        program.addRoutine(routine1);

        dao.updateProgram(program);

        sizeAfter = program.getRoutines().size();

        assertTrue("The routines were not added", sizeBefore < sizeAfter);
    }
}