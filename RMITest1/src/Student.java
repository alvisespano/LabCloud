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

    private final List<Exam> items = new ArrayList<>();

    public Student(String name, String surname, String address, int age) {
        super(name, surname, address, age);
    }

    public void pass(Exam i) {
        items.add(i);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
}
