import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addToAge(int n) {
        age += n;
    }

    @Override
    public String toString() {
        return String.format("Person { name = \"%s\"; age = %d }", name, age);
    }
}
