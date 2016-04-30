package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import com.feliciadurni.tt.persistence.RoutineDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "AddExercises", urlPatterns = { "/person/addExercises" } )

public class AddExercises extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ExerciseDao exerciseDao = new ExerciseDao();
        RoutineDao routineDao = new RoutineDao();

        List<Exercise> exercises = exerciseDao.getAllExercises();
        List<Routine> routines = routineDao.getAllRoutines();

        session.setAttribute("exercises", exercises);
        session.setAttribute("routines", routines);

        String url = "/person/addExercises.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RoutineDao routineDao = new RoutineDao();
        ExerciseDao exerciseDao = new ExerciseDao();

        String routine = req.getParameter("routine");
        Routine selectedRoutine = routineDao.getRoutine(Integer.parseInt(routine));

        Set<RoutineExercise> routineExercises = new HashSet<RoutineExercise>();

        String[] exercises = req.getParameterValues("exercise");
        String[] exerciseSets = req.getParameterValues("sets");
        String[] exerciseReps = req.getParameterValues("reps");
        String[] exerciseWeights = req.getParameterValues("weight");

        for (int n = 0; n < exercises.length; n++) {

            Exercise exercise = exerciseDao.getExercise(Integer.parseInt(exercises[n]));

            RoutineExercise routineExercise = new RoutineExercise();
            routineExercise.setRoutine(selectedRoutine);
            routineExercise.setExercise(exercise);
            routineExercise.setExpectedSets(Integer.parseInt(exerciseSets[n]));
            routineExercise.setExpectedReps(exerciseReps[n]);
            routineExercise.setExpectedWeight(Integer.parseInt(exerciseWeights[n]));
            selectedRoutine.addRoutineExercise(routineExercise);
        }

        routineDao.updateRoutine(selectedRoutine);

        resp.sendRedirect("/person/addExercises");
    }
}