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
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.joda.time.DateTime;
import org.joda.time.Days;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.commons.lang.time.DateUtils;
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
        ProgramDao programDao = new ProgramDao();
        String username = req.getRemoteUser();
        Person loggedInPerson = personDao.getPersonByUsername(username);
        String firstName = loggedInPerson.getFirstName();
        String lastName = loggedInPerson.getLastName();
        String fullName = firstName + " " + lastName;
        Program currentProgram = null;
        long currentWeek = 0;
        long remainingWeeks = 0;

        Set<Program> programs = loggedInPerson.getPrograms();

        for (Program program : programs) {

            DateTime beginDate = new DateTime(program.getBeginDate());
            DateTime endDate = new DateTime(program.getEndDate());
            DateTime today = new DateTime();

            if (today.isAfter(beginDate) && today.isBefore(endDate)) {

                currentProgram = programDao.getProgram(program.getProgramId());

                currentWeek = Weeks.weeksBetween(beginDate, today).getWeeks() + 1;
                remainingWeeks = Weeks.weeksBetween(today, endDate).getWeeks();
            }
        }

        List<String> routineList = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();

        Set<Routine> routines = currentProgram.getRoutines();
        ArrayList<Routine> weekRoutines = new ArrayList<Routine>();

        Integer numberOfRoutines = 0;

        for (Routine routine : routines) {

            if (currentWeek == routine.getWeek()) {

                numberOfRoutines++;
                weekRoutines.add(routine);
            }
        }

        session.setAttribute("name", fullName);
        session.setAttribute("currentProgram", currentProgram);
        session.setAttribute("currentWeek", currentWeek);
        session.setAttribute("numberOfRoutines", numberOfRoutines);
        session.setAttribute("remainingWeeks", remainingWeeks);
        session.setAttribute("weekRoutines", weekRoutines);

        String url = "/person/main.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
