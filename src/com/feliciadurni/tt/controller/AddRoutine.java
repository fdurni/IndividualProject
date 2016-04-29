package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ProgramDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "AddRoutine", urlPatterns = { "/person/addRoutine" } )

public class AddRoutine extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/addRoutine.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProgramDao programDao = new ProgramDao();

        String program = req.getParameter("program");
        Program selectedProgram = programDao.getProgramByName(program);

        String[] weeks = req.getParameterValues("checkboxes");

        for (int i = 0; i < weeks.length; i++) {

            Integer day = Integer.parseInt(req.getParameter("radios"));
            Integer week = Integer.parseInt(weeks[i]);

            Routine routine = new Routine();
            routine.setDay(day);
            routine.setRoutineName(req.getParameter("routineName"));
            routine.setWeek(week);
            routine.setRoutineDescription(req.getParameter("routineDescription"));
            selectedProgram.addRoutine(routine);
        }

        programDao.updateProgram(selectedProgram);

        /*
         * Logic to redirect user
         * if the button was clicked
         */
        if (req.getParameter("submit") != null) {
            resp.sendRedirect("/person/addRoutine");
        }
        else if (req.getParameter("submitAndAdd") != null) {
            resp.sendRedirect("/person/addExercises");
        }
    }
}