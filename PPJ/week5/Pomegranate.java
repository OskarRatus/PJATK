package week5;

public
    class Pomegranate
        extends Fruit {

    protected int seedCount;

    @Override
    public String toString() {
        return "Pomegranate{" +
                "name='" + super.name + '\'' +
                ", seedCount=" + this.seedCount +
                '}';
    }
}
