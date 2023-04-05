public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void addToAge(int n) {
        age += n * 2;
    }
}
