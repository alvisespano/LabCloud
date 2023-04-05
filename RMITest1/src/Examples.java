public class Examples {

    public static class Animal {
        protected int weight;

        public Animal(int weight) {
            this.weight = weight;
        }

        public void eat(Animal a) {
            this.weight = this.weight + a.weight;
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
        private int factor;

        public Cat(int weight, int factor) {
            super(weight);
            this.factor = factor;
        }

        @Override
        public void eat(Animal a) {   // ===> void eat(Animal a, Cat this)
            this.weight = this.weight + a.weight * this.factor;
        }

        // TODO write a serialize() method here for the hyierarchy
    }

    public static void examplePolymorpshim() {
        Animal speck = new Cat(10, 3);
        Dog biri = new Dog(50);
        speck.eat(biri);
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
