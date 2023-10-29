package sit.int202.sitspacemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import sit.int202.sitspacemanagement.models.StudentRepository;

import java.io.IOException;

@WebServlet(name = "RemoveStudentServlet", value = "/remove-student")
public class RemoveStudentServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int removeId = Integer.parseInt(req.getParameter("removeId"));
        StudentRepository studentRepository = (StudentRepository) session.getAttribute("repo");
        if(studentRepository == null){
            System.out.println("Can't find student repository");
        }
        studentRepository.removeStudentById(removeId);
        resp.sendRedirect("addRemoveStudent.jsp");
    }
}
