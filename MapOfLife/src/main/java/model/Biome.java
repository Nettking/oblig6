package model;

public class Biome implements Comparable<Biome>  {
    private String name;

    public Biome() {
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Name: " + name;
    }



    @Override
    public int compareTo(Biome other) {
        return name.compareTo(other.getName());
    }
}
