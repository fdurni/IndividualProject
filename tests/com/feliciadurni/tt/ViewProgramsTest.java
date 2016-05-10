package com.feliciadurni.tt;

import com.feliciadurni.tt.controller.ViewPrograms;
import com.feliciadurni.tt.entity.Routine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by felic on 5/8/2016.
 */
public class ViewProgramsTest {

    ViewPrograms viewPrograms;
    List<Routine> routines;
    Integer week;

    @Before
    public void setUp() throws Exception {
        viewPrograms = new ViewPrograms();
        routines = new ArrayList<Routine>();
        week = 1;

        Routine routine = new Routine();
        routine.setWeek(1);
        routines.add(routine);
    }

    @Test
    public void testGetSelectedRoutine() throws Exception {

        Routine routine = viewPrograms.getSelectedRoutine(routines, week);

        assertNotNull("Could not get routine", routine);
    }
}
