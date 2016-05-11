package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.Person;
import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by felic on 5/4/2016.
 */
@WebServlet(name = "ViewPrograms", urlPatterns = { "/person/viewPrograms" } )

public class ViewPrograms extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method displays viewPrograms.jsp.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/viewPrograms.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    /**
     * This method gets a routine based on the program selected.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        RoutineDao dao = new RoutineDao();

        /*
         * get the name of the routine selected by the user
         */
        String routineName = req.getParameter("selectRoutine");

        /*
         * create a list of routines with the selected name
         */
        List<Routine> routines = dao.getRoutinesByName(routineName);

        /*
         * get the week selected by the user
         */
        Integer week = Integer.parseInt(req.getParameter("selectWeek"));

        /*
         * get the correct routine from the list, based on the selected week
         */
        Routine selectedRoutine = getSelectedRoutine(routines, week);

        session.setAttribute("selectedRoutine", selectedRoutine);

        resp.sendRedirect("viewRoutines");
    }

    /**
     * Gets a routine from a list based on the week.
     *
     * @param routines the routines
     * @param week     the week
     * @return the selected routine
     */
    public Routine getSelectedRoutine(List<Routine> routines, Integer week) {

        Routine selectedRoutine = new Routine();

        for (Routine routine : routines) {

            if (routine.getWeek().equals(week)) {

                selectedRoutine = routine;
            }
        }
        return selectedRoutine;
    }
}
