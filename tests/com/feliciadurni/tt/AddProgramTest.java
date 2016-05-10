package com.feliciadurni.tt;

import com.feliciadurni.tt.controller.AddProgram;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by felic on 5/8/2016.
 */
public class AddProgramTest {

    AddProgram addProgram;

    @Before
    public void setUp() throws Exception {
        addProgram = new AddProgram();
    }

    @Test
    public void testFormatBeginDateAndCalculateEndDate() throws Exception {

        Date formattedBeginDate = addProgram.formatBeginDate("2016-01-01");
        Date calculatedEndDate = addProgram.calculateEndDate(formattedBeginDate, 4);

        assertNotNull("Could not calculate end date", calculatedEndDate);
    }
}
