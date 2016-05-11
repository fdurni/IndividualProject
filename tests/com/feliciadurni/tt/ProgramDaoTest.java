package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 4/13/2016.
 */
public class ProgramDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    ProgramDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new ProgramDao();
    }

    @Test
    public void testGetAllPrograms() throws Exception {

        List<Program> programs = dao.getAllPrograms();

        assertTrue("There is the wrong amount in the list", programs.size() > 0);
    }

    @Test
    public void testGetProgram() throws Exception {

        Program program = dao.getProgram(56);
        assertNotNull("Could not get program", program);
    }

    @Test
    public void testGetProgramByName() throws Exception {

        Program program = dao.getProgramByName("Felicia Program");

        log.info(program);

        assertNotNull("Could not get program", program);
    }

    @Test
    public void testUpdateProgram() throws Exception {

        Program program = new Program();
        program.setProgramId(58);
        program.setProgramName("Program-Name");
        program.setProgramType("Program-Type");
        program.setProgramDescription("Updated-Description");

        dao.updateProgram(program);
        assertNotNull("Could not update program", program.getProgramId());
    }

    @Test
    public void testDeleteProgram() throws Exception {

        Program program = new Program();
        program.setProgramId(60);

        Boolean siteDeleted = dao.deleteProgram(program);
        assertTrue(siteDeleted);
    }

    @Test
    public void testAddProgram() throws Exception {

        int insertProgramId = 0;

        Program program = new Program();

        program.setProgramName("Program-Name");
        program.setProgramType("Program-Type");
        program.setProgramDescription("Program-Description");

        insertProgramId = dao.addProgram(program);

        assertTrue(insertProgramId > 0);
    }
}