package com.example.demo.servlet;

import com.example.demo.bean.Course;
import com.example.demo.dao.AffectDao;
import com.example.demo.dao.Coursedao;
import com.example.demo.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class affectServlet extends HttpServlet {
private Coursedao cd;
private StudentDao sd;
private AffectDao affd;

    @Override
    public void init() {
        cd = new Coursedao();
        sd = new StudentDao();
        affd = new AffectDao();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("assign".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            List<Course> courseList = cd.getallCourses();
            req.setAttribute("courselist", courseList);
            req.getRequestDispatcher("assign.jsp").forward(req, resp);
           
        }
    }
}
