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
    private Map<Integer, Character> studentGrade;

    public StudentRepository (){
        this.studentList = new ArrayList<>();
        this.studentGrade = new HashMap<>();
    }

    private static boolean isValidGrade(double number) {
        return number >= 0;
    }

    public static char calculateGrade(double grade) throws Exception {
        if (isValidGrade(grade)){
            if (grade >= 80) {
                return 'A';
            } else if (grade >= 70) {
                return 'B';
            } else if (grade >= 60) {
                return 'C';
            } else if (grade >= 50) {
                return 'D';
            } else {
                return 'F';
            }
        } else {
            throw new Exception("Grade should not be 0 or less than 0");
        }
    }

    private boolean isStudentInvalid(Student newStudent){
        for (Student student : studentList){
            if(student.getId() == newStudent.getId()) return true;
        }
        return false;
    }

    public void addStudent(Student student) throws Exception {
        if (student == null || isStudentInvalid(student)) return;
        this.studentList.add(student);
        studentGrade.put(student.getId(), calculateGrade(student.getScore()));
    }

    private boolean isValidId(int number) {
        return number > 0;
    }

    public void removeStudentById(int id) throws InvalidIdException, StudentNotFoundException {
        if (isValidId(id)) {
            Student std = studentList.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
            if(std == null) {
                throw new StudentNotFoundException("Can not find the student");
            }
            studentGrade.remove(std.getId());
            studentList.remove(std);
        } else {
            throw new InvalidIdException("id should be more than 0");
        }
    }
}
