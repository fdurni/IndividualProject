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
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/17/2016.
 */
@WebServlet(name = "AddProgram", urlPatterns = { "/addProgram" } )

public class AddProgram extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Program> allPrograms = new ArrayList<Program>();
        ProgramDao dao = new ProgramDao();

        allPrograms = dao.getAllPrograms();

        session.setAttribute("programInfo", allPrograms);

        String url = "/person/addProgram.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Program program = new Program();
        ProgramDao dao = new ProgramDao();

        program.setProgramName(req.getParameter("programName"));
        program.setProgramType(req.getParameter("programType"));
        program.setProgramDescription(req.getParameter("programDescription"));

        dao.addProgram(program);

        resp.sendRedirect("/person/addRoutine.jsp");
    }
}
