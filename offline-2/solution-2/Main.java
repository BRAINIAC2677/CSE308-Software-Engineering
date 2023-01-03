
import java.util.ArrayList;
import java.io.*;
import component.*;
import mediator.*;

public class Main {
    public static void main(String[] args) {

        Console console = System.console();

        ExamController examController = new ExamController();
        Examiner examiner = new Examiner(examController, 5);
        examController.setExaminer(examiner);

        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student(examController, i);
            students.add(student);
        }
        examController.setStudents(students);

        examiner.publishMarks();
        for (int i = 0; i < 5; i++) {
            System.out.println("student id " + students.get(i).getStudentId() + " marks: " + students.get(i).getMark());
        }
        System.out.println();

        int reExamineStudentId = Integer.parseInt(console.readLine("Id of the student to be re-examined: "));
        students.get(reExamineStudentId).reExamineMark();
        for (int i = 0; i < 5; i++) {
            System.out.println("student id " + students.get(i).getStudentId() + " marks: " + students.get(i).getMark());
        }

    }
}