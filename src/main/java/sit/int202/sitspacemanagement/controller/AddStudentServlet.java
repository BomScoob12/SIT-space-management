package sit.int202.sitspacemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.SneakyThrows;
import sit.int202.sitspacemanagement.models.Student;
import sit.int202.sitspacemanagement.models.StudentRepository;

import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("studentId"));
        String name = (String) req.getParameter("studentName");
        double score = Double.parseDouble(req.getParameter("studentScore"));
        char grade = StudentRepository.calculateGrade(score);

        Student student = new Student(id, name, score, grade);
        StudentRepository studentRepository = (StudentRepository) session.getAttribute("repo");
        if(studentRepository == null){
            studentRepository = new StudentRepository();
        }
        studentRepository.addStudent(student);
        //update session
        session.setAttribute("repo", studentRepository);
        resp.sendRedirect("addRemoveStudent.jsp");
    }

}
