package model;


import java.time.LocalDateTime;

public class Observation implements Comparable<Observation> {
    private int id;
    private String name;
    private Location location;
    private LocalDateTime time;
    private int numberObserved;
    private String pictureUrl;
    private String comment;
    private Animal animal;

    public Observation(int id, String name, Location location, LocalDateTime time, int numberObserved, String pictureUrl, String comment, Animal animal) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
        this.numberObserved = numberObserved;
        this.pictureUrl = pictureUrl;
        this.comment = comment;
        this.animal = animal;
    }

    public Observation(){};

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getNumberObserved() {
        return numberObserved;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getComment() {
        return comment;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return "Observation #: " + id + " Name: " + name + ". Location: " + location + ". Time: " + time + ". Number Observed: " + numberObserved + ". Species: " + animal;
    }

    @Override
    public int compareTo(Observation other) {
        return name.compareTo(other.getName());
    }
}
