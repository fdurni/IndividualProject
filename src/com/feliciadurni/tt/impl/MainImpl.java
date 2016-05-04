package com.feliciadurni.tt.impl;

import com.feliciadurni.tt.entity.Person;
import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 * Created by felic on 5/3/2016.
 */
public class MainImpl {

    private Date calculatedEndDate;
    private DateTime programBeginDate;
    private DateTime programEndDate;
    private DateTime today;

    /**
     * Calculate end date date.
     *
     * @param beginDate     the begin date
     * @param numberOfWeeks the number of weeks
     * @return the date
     */
    public Date calculateEndDate(Date beginDate, int numberOfWeeks) {

        calculatedEndDate = DateUtils.addDays(beginDate, (numberOfWeeks * 7));

        return calculatedEndDate;
    }

    /**
     * Gets current program.
     *
     * @param loggedInPerson the logged in person
     * @return the current program
     */
    public Program getCurrentProgram(Person loggedInPerson) {

        ProgramDao programDao = new ProgramDao();
        Program currentProgram = new Program();
        Set<Program> programs = loggedInPerson.getPrograms();

        for (Program program : programs) {

            programBeginDate = new DateTime(program.getBeginDate());
            programEndDate = new DateTime(program.getEndDate());
            today = new DateTime();

            if (today.isAfter(programBeginDate) && today.isBefore(programEndDate)) {

                currentProgram = programDao.getProgram(program.getProgramId());
                currentProgram.setCurrentWeek(Weeks.weeksBetween(programBeginDate, today).getWeeks() + 1);
                currentProgram.setRemainingWeeks(Weeks.weeksBetween(today, programEndDate).getWeeks());
            }
        }
        return currentProgram;
    }

    /**
     * Gets routines for week.
     *
     * @param currentProgram the current program
     * @return the routines for week
     */
    public ArrayList<Routine> getRoutinesForWeek(Program currentProgram) {

        Set<Routine> routines = currentProgram.getRoutines();
        ArrayList<Routine> weekRoutines = new ArrayList<Routine>();

        Integer numberOfRoutines = 0;

        for (Routine routine : routines) {

            if (currentProgram.getCurrentWeek() == routine.getWeek()) {

                numberOfRoutines++;
                weekRoutines.add(routine);
            }
        }
        currentProgram.setNumberOfRoutines(numberOfRoutines);
        return weekRoutines;
    }
}
