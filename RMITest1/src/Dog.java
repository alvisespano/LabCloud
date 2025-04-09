public class Dog extends Animal {
    private boolean pedigree;

    public Dog(int weight, boolean pedigree) {
        super(weight);
        this.pedigree = pedigree;
    }

    @Override
    public void eat(Animal a) {
        this.weight += a.weight * 2;
    }

}
