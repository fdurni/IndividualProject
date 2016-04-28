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
import java.util.List;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "SelectProgram", urlPatterns = { "/person/selectProgram" } )
public class SelectProgram extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Program> allPrograms = new ArrayList<Program>();
        ProgramDao dao = new ProgramDao();

        allPrograms = dao.getAllPrograms();

        log.info("The Program List: " + allPrograms);

        session.setAttribute("programInfo", allPrograms);

        String url = "/person/selectProgram.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ProgramDao dao = new ProgramDao();

        Exercise exercise = new Exercise();

        int programId = Integer.parseInt(req.getParameter("selectbasic"));
        Program selectedProgram = dao.getProgram(programId);

        log.info("The Program: " + selectedProgram);

        session.setAttribute("selectedProgram", selectedProgram);

        resp.sendRedirect("/person/addRoutine");
    }
}
