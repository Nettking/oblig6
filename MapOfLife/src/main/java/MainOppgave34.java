import model.*;
import repository.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MainOppgave34 {
    public static void main(String args[]) {
        Repository repository = new Repository("src\\main\\resources\\fileoutput\\repository.json");

        writeObservations(repository);
        List<Observation> observations = readObservations(repository);

        for (int i = 0; i < observations.size(); i++) {
            System.out.println(observations.get(i));
        }
    }

    public static void writeObservations(Repository repository){
        List<Observation> observations = createObservations();
        repository.writeObservations(observations);
    }

    public static List<Observation> readObservations(Repository repository){
        List<Observation> observations = repository.readObservations();
        return observations;
    }

    public static List<Observation> createObservations(){
        List<Observation> observations = new ArrayList<>();
        observations.add(createObservation1());
        observations.add(createObservation2());
        observations.add(createObservation3());
        observations.add(createObservation4());
        observations.add(createObservation5());
        observations.add(createObservation6());
        return observations;

    }

    public static Observation createObservation1(){
        Bird sparrow = new Bird("Sparrow", "Passeridae", false, true);
        Planet earth = new Planet("Earth");
        Location hundredAcreWood = new Location("Hundred-Acre Wood", earth, new Position(51.1113,43.2213));
        Observation observation = new Observation(1,
                "Sparrow in Hundred-Acre Wood",
                hundredAcreWood,
                LocalDateTime.of(2337, 12, 24,10, 0, 0),
                1,
                "https://animals.net/wp-content/uploads/2019/07/House-Sparrow-4-650x425.jpg",
                "Sitting on a branch",
                sparrow);
        return observation;
    }

    public static Observation createObservation2(){
        Bird eagle = new Bird("Eagle", "Haliaeetus leucocephalus", false, true);
        Planet mars = new Planet("Mars");
        Location marsSavanna = new Location("Savanna near forest", mars, new Position(45.1123, 54.1112));
        Observation observation = new Observation(2,
                "Eagle on Mars",
                marsSavanna,
                LocalDateTime.of(2337, 2, 21,11, 0, 0),
                4,
                "https://upload.wikimedia.org/wikipedia/commons/9/92/Bald_eagle_-a.jpg",
                "Flying in the air",
                eagle);
        return observation;
    }

    public static Observation createObservation3(){
        Invertebrate crab = new Invertebrate("Crab", "Brachyura", false);
        Planet earth = new Planet("Earth");
        Location earthOcean = new Location("Shore", earth, new Position(32.7777, 44.8765));
        Observation observation = new Observation(3,
                "Crab by the Shore",
                earthOcean,
                LocalDateTime.of(2337, 3, 22,11, 0, 0),
                1,
                "https://storage.googleapis.com/snl-no-media/media/15438/standard_799px-Cancer_pagurus.jpg",
                "In the sand",
                crab);
        return observation;
    }

    public static Observation createObservation4(){
        Amphibian frog = new Amphibian("Frog", "Anura", true, 4);
        Planet jupiter = new Planet("Jupiter");
        Location jupiterShore = new Location("Shore", jupiter, new Position(12.1123, 11.1112));
        Observation observation = new Observation(4,
                "Frog by the Shore",
                jupiterShore,
                LocalDateTime.of(2337, 3, 22,11, 0, 0),
                2,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Teichfrosch.jpg/1200px-Teichfrosch.jpg",
                "Its a baby!",
                frog);
        return observation;
    }

    public static Observation createObservation5(){
        Bird eagle = new Bird("Eagle", "Haliaeetus leucocephalus", true, false);
        Planet jupiter = new Planet("Jupiter");
        Location savanna = new Location("Savanna near forest", jupiter, new Position(25.1123, 34.1112));
        Observation observation = new Observation(5,
                "Eagle on Jupiter",
                savanna,
                LocalDateTime.of(2337, 2, 1,10, 0, 0),
                3,
                "https://upload.wikimedia.org/wikipedia/commons/9/92/Bald_eagle_-a.jpg",
                "Flying in the air",
                eagle);
        return observation;
    }

    public static Observation createObservation6(){
        Bird eagle = new Bird("Eagle", "Haliaeetus leucocephalus", true,true);
        Planet mars = new Planet("Earth");
        Location savanna = new Location("Savanna near forest", mars, new Position(35.1223, 14.1112));
        Observation observation = new Observation(6,
                "Eagle on Earth",
                savanna,
                LocalDateTime.of(2337, 2, 21,11, 0, 0),
                2,
                "https://upload.wikimedia.org/wikipedia/commons/9/92/Bald_eagle_-a.jpg",
                "Flying in the air",
                eagle);
        return observation;
    }


}
