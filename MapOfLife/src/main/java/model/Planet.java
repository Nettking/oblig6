package model;

public class Planet implements Comparable<Planet> {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public Planet() {
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Planet other) {
        return name.compareTo(other.getName());
    }
}
