package model;

public class Location implements Comparable<Location> {
    private String name;
    private Planet planet;
    private Position position;

    public Location(String name, Planet planet, Position position) {
        this.name = name;
        this.planet = planet;
        this.position = position;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() {
        return planet;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " on planet " + planet + ". " + position + ". ";
    }

    @Override
    public int compareTo(Location other) {
        return name.compareTo(other.getName());
    }
}
