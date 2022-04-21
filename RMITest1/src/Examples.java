
public class Examples {
    public static class Animal {
        protected int weight;

        public Animal(int weight) {
            this.weight = weight;
        }

        public void eat(Animal a) {
            weight = weight + a.weight;
        }
    }

    public static class Dog extends Animal {
        public Dog(int weight) {
            super(weight);
        }

        @Override
        public void eat(Animal a) {
            weight = weight + a.weight / 2;
        }
    }

    public static class Cat extends Animal {
        public Cat(int weight) {
            super(weight);
        }

        @Override
        public void eat(Animal a) {
            weight = weight + a.weight * 2;
        }
    }




    public static void examplePolymorpshim() {

        Animal speck = new Cat(10);
        Dog biri = new Dog(50);
        Animal alvise = new Animal(80);

        speck.eat(biri);
        alvise.eat(speck);

    }



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
