package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ExerciseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "AddNewExercises", urlPatterns = { "/person/addNewExercises" } )

public class AddNewExercises extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    /**
     * This method displays the jsp page.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/addNewExercises.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    /**
     * This method inserts new exercises into the exercise table.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        int insertedExercise = 0;

        String[] exerciseName = req.getParameterValues("exerciseName");
        String[] exerciseType = req.getParameterValues("exerciseType");
        String[] exerciseDescription = req.getParameterValues("exerciseDescription");

        for (int i = 0; i < exerciseName.length; i++) {

            Exercise exercise = new Exercise();
            exercise.setExerciseName(exerciseName[i]);
            exercise.setExerciseType(exerciseType[i]);
            exercise.setExerciseDescription(exerciseDescription[i]);

            insertedExercise += exerciseDao.addExercise(exercise);
        }

        PrintWriter out = resp.getWriter();

        if (insertedExercise > 0) {
            resp.sendRedirect("addNewExercises");
        } else {
            out.println("<font color=red>Could not add exercise(s). Try again.</font>");
        }
    }
}