package sit.int202.sitspacemanagement.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sit.int202.sitspacemanagement.exceptions.InvalidIdException;
import sit.int202.sitspacemanagement.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Setter
@Getter
public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository (){
        this.studentList = new ArrayList<>();
    }

    public static char calculateGrade(double score) throws Exception {
        if (isValidGrade(score)){
            if (score >= 80) {
                return 'A';
            } else if (score >= 70) {
                return 'B';
            } else if (score >= 60) {
                return 'C';
            } else if (score >= 50) {
                return 'D';
            } else {
                return 'F';
            }
        } else {
            throw new Exception("Grade should not be 0 or less than 0");
        }
    }

    public void addStudent(Student student) throws Exception {
        if (student == null || isStudentInvalid(student)) return;
        this.studentList.add(student);
    }

    public void removeStudentById(int id) throws InvalidIdException, StudentNotFoundException {
        if (isValidId(id)) {
            Student std = studentList.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
            if(std == null) {
                throw new StudentNotFoundException("Can not find the student");
            }
            studentList.remove(std);
        } else {
            throw new InvalidIdException("id should be more than 0");
        }
    }

    private boolean isStudentInvalid(Student newStudent){
        for (Student student : studentList){
            if(student.getId() == newStudent.getId()) return true;
        }
        return false;
    }

    private boolean isValidId(int number) {
        return number > 0;
    }

    private static boolean isValidGrade(double number) {
        return number >= 0;
    }
}
