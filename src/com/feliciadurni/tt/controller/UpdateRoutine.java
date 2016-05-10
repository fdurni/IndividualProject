package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import com.feliciadurni.tt.persistence.RoutineExerciseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "UpdateRoutine", urlPatterns = { "/person/updateRoutine" } )

public class UpdateRoutine extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/updateRoutine.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer routineId = Integer.parseInt(req.getParameter("routineId"));
        Integer programId = Integer.parseInt(req.getParameter("programId"));
        String name = req.getParameter("routineName");
        String description = req.getParameter("routineDescription");
        Integer week = Integer.parseInt(req.getParameter("week"));
        Integer day = Integer.parseInt(req.getParameter("day"));

        /*
         * get the program based on the program id
         */
        ProgramDao programDao = new ProgramDao();
        Program program = programDao.getProgram(programId);

        /*
         * setters for a routine
         */
        RoutineDao dao = new RoutineDao();
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        routine.setDay(day);
        routine.setRoutineName(name);
        routine.setWeek(week);
        routine.setRoutineDescription(description);
        routine.setProgram(program);

        /*
         * update the routine in the database
         */
        dao.updateRoutine(routine);

        String[] routineexerciseId = req.getParameterValues("routineexerciseId");
        String[] routineexerciseexerciseId = req.getParameterValues("routineexerciseexerciseId");
        String[] routineexerciseroutineId = req.getParameterValues("routineexerciseroutineId");
        String[] sets = req.getParameterValues("expectedSets");
        String[] reps = req.getParameterValues("expectedReps");
        String[] weight = req.getParameterValues("expectedWeight");

        RoutineExerciseDao routineExerciseDao = new RoutineExerciseDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        RoutineDao routineDao = new RoutineDao();

        /*
         * setters for a routineexercise
         * update the routineexercise
         */

        for (int i = 0; i < routineexerciseId.length; i++) {

            Exercise re_exercise = exerciseDao.getExercise(Integer.parseInt(routineexerciseexerciseId[i]));
            Routine re_routine = routineDao.getRoutine(Integer.parseInt(routineexerciseroutineId[i]));

            RoutineExercise routineExercise = new RoutineExercise();
            routineExercise.setRoutineexerciseId(Integer.parseInt(routineexerciseId[i]));
            routineExercise.setExercise(re_exercise);
            routineExercise.setRoutine(re_routine);
            routineExercise.setExpectedSets(Integer.parseInt(sets[i]));
            routineExercise.setExpectedReps(reps[i]);
            routineExercise.setExpectedWeight(Integer.parseInt(weight[i]));

            routineExerciseDao.updateRoutineExercise(routineExercise);
        }

        /*
         * Logic to redirect user
         * if the button was clicked
         */
        if (req.getParameter("submit") != null) {
            resp.sendRedirect("/person/viewPrograms");
        }
        else {
            resp.sendRedirect("/person/viewRoutines");
        }
    }
}