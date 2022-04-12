
public class Example1 {
    public static class Person {
        public String name, surname;
        public int age;


        public void makerOlderBy(int n) {
            this.age += n;
        }
    }

    public static class Student extends Person {
        public int idNumber;
    }

    public static void main(String[] args) {
        Person gigi = new Person();
        gigi.name = "Gigi";
        gigi.surname = "Rossi";
        gigi.age = 40;
        gigi.makerOlderBy(10);

        Student riccardo = new Student();
        riccardo.name = "Riccardo";
        riccardo.surname = "Zuliani";
        riccardo.age = 22;
        riccardo.idNumber = 875532;

        Person p = riccardo;
        p.makerOlderBy(20);

    }
}
