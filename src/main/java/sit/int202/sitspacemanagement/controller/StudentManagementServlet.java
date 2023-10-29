package sit.int202.sitspacemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import sit.int202.sitspacemanagement.exceptions.InvalidIdException;
import sit.int202.sitspacemanagement.exceptions.StudentNotFoundException;
import sit.int202.sitspacemanagement.models.Student;
import sit.int202.sitspacemanagement.models.StudentRepository;

import java.io.IOException;

@WebServlet(name = "StudentManagementServlet", value = "/student-management")
public class StudentManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("remove") != null) {
            int stdId = Integer.parseInt(req.getParameter("removeId"));
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        addNewStudent(req, resp);
    }

    protected void addNewStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception, StudentNotFoundException, InvalidIdException {
        int id = Integer.parseInt(req.getParameter("studentId"));
        String name = req.getParameter("studentName");
        double score = Double.parseDouble(req.getParameter("studentScore"));

        Student student = new Student(id, name, score);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student);

    }

}
