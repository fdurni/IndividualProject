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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by felic on 5/4/2016.
 */
@WebServlet(name = "DeleteRoutine", urlPatterns = { "/person/deleteRoutine" } )
public class DeleteRoutine extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer routineId = Integer.parseInt(req.getParameter("routineId"));
        boolean deletedRoutine;

        RoutineDao routineDao = new RoutineDao();
        Routine routine = routineDao.getRoutine(routineId);
        deletedRoutine = routineDao.deleteRoutine(routine);

        /*
         * used to output a message if the insert was unsuccessful
         */
        PrintWriter out = resp.getWriter();

        /*
         * output a message if unable to delete the routine
         */
        if (!deletedRoutine) {
            out.println("<font color=red>Could not delete routine. Try again.</font>");
        }
    }
}
