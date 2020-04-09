package model;

public class Invertebrate extends Animal {
    private boolean haveCoelom;

    public Invertebrate(String commonName, String scientificName, boolean haveCoelom) {
        super(commonName, scientificName);
        this.haveCoelom = haveCoelom;
    }

    public Invertebrate() {
        super();
    }

    public boolean isHaveCoelom() {
        return haveCoelom;
    }

    @Override
    public String toString() {
        return super.toString() + " have coelom: " + haveCoelom;
    }
}
