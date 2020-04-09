package model;

public class Amphibian extends Animal {
    private boolean haveTail;
    private int numberOfLegs;

    public Amphibian(String commonName, String scientificName, boolean haveTail, int numberOfLegs) {
        super(commonName, scientificName);
        this.haveTail = haveTail;
        this.numberOfLegs = numberOfLegs;
    }

    public Amphibian() {
        super();
    }

    public boolean isHaveTail() {
        return haveTail;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String toString() {
        return super.toString() + " have tail: " + haveTail + " number of legs: " + numberOfLegs;
    }
}
