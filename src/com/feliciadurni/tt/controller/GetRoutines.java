package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.Program;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.ProgramDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

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
@WebServlet(name = "GetRoutines", urlPatterns = { "/person/getRoutines" } )
public class GetRoutines extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /*
     * Creates a list of routine names
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer programId = Integer.parseInt(req.getParameter("programId"));
        List<String> list = new ArrayList<String>();
        String json = null;

        /*
         * get the routines for the program that was selected from the dropdown
         */
        ProgramDao programDao = new ProgramDao();
        Program program = programDao.getProgram(programId);
        Set<Routine> routines = program.getRoutines();

        /*
         * add the name of each routine to the Set, if the name does not already exist
         */
        for (Routine routine : routines) {
            if (!list.contains(routine.getRoutineName())) {
                list.add(routine.getRoutineName());
            }
        }

        /*
         * return the json list of routines
         */
        json = new Gson().toJson(list);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
