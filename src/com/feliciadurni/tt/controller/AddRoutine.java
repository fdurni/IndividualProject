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
@WebServlet(name = "AddRoutine", urlPatterns = { "/person/addRoutine" } )

public class AddRoutine extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ExerciseDao exerciseDao = new ExerciseDao();

        List<Exercise> exercises = exerciseDao.getAllExercises();

        session.setAttribute("exercises", exercises);

        String url = "/person/addRoutine.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProgramDao programDao = new ProgramDao();
        ExerciseDao exerciseDao = new ExerciseDao();

        String program = req.getParameter("program");
        Program selectedProgram = programDao.getProgram(Integer.parseInt(program));

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

            Set<RoutineExercise> routineExercises = new HashSet<RoutineExercise>();

            String[] exercises = req.getParameterValues("exercise");
            String[] exerciseSets = req.getParameterValues("sets");
            String[] exerciseReps = req.getParameterValues("reps");
            String[] exerciseWeights = req.getParameterValues("weight");

            for (int n = 0; n < exercises.length; n++) {

                Exercise exercise = exerciseDao.getExercise(Integer.parseInt(exercises[n]));

                RoutineExercise routineExercise = new RoutineExercise();
                routineExercise.setRoutine(routine);
                routineExercise.setExercise(exercise);
                routineExercise.setExpectedSets(Integer.parseInt(exerciseSets[n]));
                routineExercise.setExpectedReps(exerciseReps[n]);
                routineExercise.setExpectedWeight(Integer.parseInt(exerciseWeights[n]));

                routineExercises.add(routineExercise);
                routine.setRoutineExercises(routineExercises);
            }
        }

        programDao.updateProgram(selectedProgram);

        resp.sendRedirect("/person/addRoutine");
    }
}