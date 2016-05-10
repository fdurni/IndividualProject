package com.feliciadurni.tt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.joda.time.DateTime;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;
import org.joda.time.Weeks;

/**
 * Created by felic on 4/28/2016.
 */
@WebServlet(name = "Main", urlPatterns = { "/person/home" } )
public class Main extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        PersonDao personDao = new PersonDao();

        /*
         * get the username of the currently logged in user
         */
        String username = req.getRemoteUser();
        Person loggedInPerson = personDao.getPersonByUsername(username);

        /*
         * create the full name of the currently logged in user, then sets the attribute
         */
        String firstName = loggedInPerson.getFirstName();
        String lastName = loggedInPerson.getLastName();
        String fullName = firstName + " " + lastName;

        session.setAttribute("name", fullName);

        /*
         * create a Set of all programs for the logged in user
         */
        Set<Program> programs = loggedInPerson.getPrograms();

        /*
         * checks to see if the user has programs before continuing
         */
        if (programs.size() > 0) {

            /*
         * create a list of the routines for the current week, for the user's current program
         */
            Program currentProgram = getCurrentProgram(loggedInPerson, programs);

            ArrayList<Routine> weekRoutines = getRoutinesForWeek(currentProgram);

        /*
         * get the current week to display on the dashboard
         */
            long currentWeek = currentProgram.getCurrentWeek();

        /*
         * get the remaining weeks to display on the dashboard
         */
            long remainingWeeks = currentProgram.getRemainingWeeks();

        /*
         * get the number of routines to display on the dashboard
         */
            Integer numberOfRoutines = currentProgram.getNumberOfRoutines();

        /*
         * set dashboard attributes
         */

            session.setAttribute("currentProgram", currentProgram);
            session.setAttribute("currentWeek", currentWeek);
            session.setAttribute("numberOfRoutines", numberOfRoutines);
            session.setAttribute("remainingWeeks", remainingWeeks);
            session.setAttribute("weekRoutines", weekRoutines);
            session.setAttribute("personPrograms", programs);
        }

        String url = "/person/main.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    /**
     * Gets current program.
     *
     * @param loggedInPerson the logged in person
     * @return the current program
     */
    public Program getCurrentProgram(Person loggedInPerson, Set<Program> programs) {

        DateTime programBeginDate;
        DateTime programEndDate;
        DateTime today;

        ProgramDao programDao = new ProgramDao();
        Program currentProgram = new Program();

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
