package mediator;

import java.util.*;
import component.*;

public class ExamController implements Mediator {
    private Examiner examiner;
    private ArrayList<Student> students;

    @Override
    public void notify(Object sender, Event event) {
        if (sender instanceof Student && event == Event.RE_EXAMINE) {
            Student student = (Student) sender;
            int studentId = student.getStudentId();

            System.out.println("re-examine request got from student id " + studentId);

            ArrayList<Integer> marks = examiner.reExamineMark(studentId);
            student.setMark(marks.get(studentId));
        }

        if (sender instanceof Examiner && event == Event.PUBLISH_MARKS) {
            System.out.println("publish marks request sent from examiner.");

            ArrayList<Integer> marks = examiner.getMarks();
            for (int i = 0; i < marks.size(); i++) {
                System.out.println("student id " + i + " marks: " + marks.get(i));
            }
            System.out.println();

            Random random = new Random();
            int studentId = random.nextInt(students.size());
            int prevMarks = marks.get(studentId);
            marks.set(studentId, random.nextInt(100));
            int newMarks = marks.get(studentId);

            System.out.println(
                    "Marks of student id " + (studentId) + " are corrected from " + prevMarks + " to " + newMarks);

            for (int i = 0; i < marks.size(); i++) {
                students.get(i).setMark(marks.get(i));
            }
        }
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}