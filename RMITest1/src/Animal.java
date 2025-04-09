public class Animal {
    protected int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    public void eat(Animal a) {
        this.weight += a.weight;
    }

    public static void main(String[] args) {
        Animal toby = new Dog(10, true);
        Animal pipy = new Animal(5);
        toby.eat(pipy);
    }

}
