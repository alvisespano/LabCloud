import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    public static class Exam {
        private final String name;
        private final int mark;

        public Exam(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        @Override
        public String toString() {
            return String.format("%s (%d)", name, mark);
        }
    }

    public class PassedExam extends Exam {
        public PassedExam(String name, int mark) {
            super(name, mark);
            Student.this.pass(this);
        }
    }

    private final List<Exam> exams = new ArrayList<>();

    public Student(String name, String surname, String address, int age) {
        super(name, surname, address, age);
    }

    public void pass(Exam i) {
        exams.add(i);
    }
    public void pass(String name, int mark) {
        pass(new Exam(name, mark));
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString() {
        return String.format("%s exams=%s", super.toString(), exams);
    }
}
