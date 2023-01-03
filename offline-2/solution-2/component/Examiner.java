package component;

import java.util.*;
import mediator.*;

public class Examiner extends Component {
    int numberOfStudents;
    ArrayList<Integer> marks;

    public Examiner(Mediator mediator, int numberOfStudents) {
        super(mediator);
        this.numberOfStudents = numberOfStudents;
        this.marks = new ArrayList<Integer>();
    }

    public void publishMarks() {
        generateMarks();

        System.out.print("scripts and marks of student id");
        for (int i = 0; i < this.numberOfStudents; i++) {
            System.out.print(" " + i);
        }
        System.out.println(" sent to exam controller office.\n");

        mediator.notify(this, Event.PUBLISH_MARKS);
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public ArrayList<Integer> reExamineMark(int studentId) {
        Random random = new Random();
        marks.set(studentId, random.nextInt(100));
        return marks;
    }

    private void generateMarks() {
        Random random = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
            marks.add(random.nextInt(100));
        }
    }
}
