package com.feliciadurni.tt;

import com.feliciadurni.tt.controller.Main;
import com.feliciadurni.tt.entity.Person;
import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.PersonDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

/**
 * Created by felic on 5/8/2016.
 */
public class MainTest {

    Main main;
    Person loggedInPerson;
    Set<Program> programs;

    @Before
    public void setUp() throws Exception {
        main = new Main();
        PersonDao personDao = new PersonDao();
        loggedInPerson = personDao.getPersonByUsername("Storm");
        programs = loggedInPerson.getPrograms();
    }

    @Test
    public void testGetCurrentProgram() throws Exception {

        Program currentProgram = main.getCurrentProgram(loggedInPerson, programs);
        ArrayList<Routine> weekRoutines = main.getRoutinesForWeek(currentProgram);

        assertNotNull("Could not get current program", currentProgram);
        assertNotNull("Could not get routines for week", weekRoutines);
    }
}
