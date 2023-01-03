package component;

import mediator.*;

public class Student extends Component {
    private int mark;
    private int studentId;

    public Student(Mediator mediator, int studentId) {
        super(mediator);
        this.studentId = studentId;
    }

    public void reExamineMark() {
        System.out.println("re-examine request sent from student id " + (studentId));
        mediator.notify(this, Event.RE_EXAMINE);
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public int getStudentId() {
        return studentId;
    }
}