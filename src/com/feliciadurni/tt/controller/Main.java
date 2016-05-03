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

import com.feliciadurni.tt.impl.MainImpl;
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
        MainImpl mainImpl = new MainImpl();
        PersonDao personDao = new PersonDao();
        String username;
        Person loggedInPerson;
        String firstName;
        String lastName;
        String fullName;
        Program currentProgram;
        long currentWeek;
        long remainingWeeks;
        Integer numberOfRoutines;

        username = req.getRemoteUser();
        loggedInPerson = personDao.getPersonByUsername(username);

        firstName = loggedInPerson.getFirstName();
        lastName = loggedInPerson.getLastName();
        fullName = firstName + " " + lastName;

        currentProgram = mainImpl.getCurrentProgram(loggedInPerson);
        ArrayList<Routine> weekRoutines = mainImpl.getRoutinesForWeek(currentProgram);

        currentWeek = currentProgram.getCurrentWeek();
        remainingWeeks = currentProgram.getRemainingWeeks();
        numberOfRoutines = currentProgram.getNumberOfRoutines();

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
