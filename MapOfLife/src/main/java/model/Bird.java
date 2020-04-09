package model;

public class Bird extends Animal {
    private boolean canFly;
    private boolean isDiurnal;

    public Bird(String commonName, String scientificName, boolean canFly, boolean isDiurnal) {
        super(commonName, scientificName);
        this.canFly = canFly;
        this.isDiurnal = isDiurnal;
    }

    public Bird() {
    }

    public boolean getCanFly() {
        return canFly;
    }
    public boolean getIsDiurnal() {
        return isDiurnal;
    }

    @Override
    public String toString() {
        return super.toString() + " can fly: " + canFly + " is diurnal: " + isDiurnal;
    }
}
