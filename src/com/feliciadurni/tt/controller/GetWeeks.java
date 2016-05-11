package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.persistence.RoutineDao;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 5/4/2016.
 */
@WebServlet(name = "GetWeeks", urlPatterns = { "/person/getWeeks" } )
public class GetWeeks extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /*
     * Creates a list of weeks that a routine occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String routineName = req.getParameter("routineName");
        List<Integer> list = new ArrayList<Integer>();
        String json = null;

        /*
         * Create a list of routines with the selected name
         */
        RoutineDao routineDao = new RoutineDao();
        List<Routine> routines = routineDao.getRoutinesByName(routineName);

        /*
         * add each week to the List, if the week does not already exist
         */
        for (Routine routine : routines) {
            list.add(routine.getWeek());
        }

        /*
         * return the json list of weeks
         */
        json = new Gson().toJson(list);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
