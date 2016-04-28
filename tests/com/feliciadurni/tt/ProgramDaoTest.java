package com.feliciadurni.tt;

import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
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

    @Test
    public void testGetAllPrograms() throws Exception {

        ProgramDao dao = new ProgramDao();
        List<Program> programs = dao.getAllPrograms();

        assertTrue("There is the wrong amount in the list", programs.size() > 0);
    }

    @Test
    public void testGetProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        Program program = dao.getProgram(7);
        assertNotNull("Could not get program", program);
    }

    @Test
    public void testUpdateProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        Program program = new Program();
        program.setProgramId(7);
        program.setProgramName("Program-Name");
        program.setProgramType("Program-Type");
        program.setProgramDescription("Updated-Description");

        dao.updateProgram(program);
        assertNotNull("Could not update program", program.getProgramId());
    }

    @Test
    public void testDeleteProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        Program program = new Program();
        program.setProgramId(11);

        Boolean siteDeleted = dao.deleteProgram(program);
        assertTrue(siteDeleted);
    }

    @Test
    public void testAddProgram() throws Exception {

        ProgramDao dao = new ProgramDao();
        int insertProgramId = 0;

        Program program = new Program();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String beginDate = "2016-01-01";
        Date formattedBeginDate = format.parse(beginDate);

        int numberOfWeeks = 12;

        Date endDate = program.calculateEndDate(formattedBeginDate,numberOfWeeks);

        program.setProgramName("Program-Name");
        program.setProgramType("Program-Type");
        program.setProgramDescription("Program-Description");
        program.setBeginDate(formattedBeginDate);
        program.setEndDate(endDate);

        insertProgramId = dao.addProgram(program);

        assertTrue(insertProgramId > 0);
    }
}