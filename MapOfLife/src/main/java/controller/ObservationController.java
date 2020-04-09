package controller;

import model.*;
import repository.IRepository;
import io.javalin.http.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ObservationController {
    private IRepository repository;

    public ObservationController(IRepository repository) {
        this.repository = repository;
    }

    public void getAllObservations(Context context){
        context.json(repository.readObservations());
    }

    public void addObservation(Context context) throws Exception {
        List<Observation> observations = repository.readObservations();
        int nextId = 0;
        for (Observation o : observations) {
            if (o.getId() >= nextId) {
                nextId = o.getId() + 1;
            }
        }

        String name = context.queryParam("name");
        Double latitude = Double.parseDouble(context.queryParam("latitude"));
        Double longitude = Double.parseDouble(context.queryParam("longitude"));
        Position position = new Position(latitude, longitude);
        Planet planet = new Planet(context.queryParam("planetName"));
        Location location = new Location(context.queryParam("locationName"), planet, position);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        //LocalDateTime timeOfObservation = new LocalDateTime.parse(context.queryParam("timeOfObservation"), formatter);
        int numberObserved = Integer.parseInt(context.queryParam("numberObserved"));
        Animal animal = null;
        String animalCommonName = context.queryParam("animalCommonName");
        String animalScientificName = context.queryParam("animalScientificName");
        switch (context.queryParam("animalType").toLowerCase()) {
            case "bird":
                boolean canFly = Boolean.parseBoolean(context.queryParam("canFly"));
                boolean isDiurnal = Boolean.parseBoolean(context.queryParam("isDiurnal"));
                animal = new Bird(animalCommonName, animalScientificName, canFly, isDiurnal);
                break;
            case "amphibian":
                boolean haveTail = Boolean.parseBoolean(context.queryParam("haveTail"));
                int numberOfLegs = Integer.parseInt(context.queryParam("numberOfLegs"));
                animal = new Amphibian(animalCommonName, animalScientificName, haveTail, numberOfLegs);
                break;
            case "invertebrate":
                boolean haveCoelom = Boolean.parseBoolean(context.queryParam("haveCoelom"));
                animal = new Invertebrate(animalCommonName, animalScientificName, haveCoelom);
                break;
            default:
                throw new Exception("Unknown animalType: " + context.queryParam("animalType"));
        }
        //Observation newObservation = new Observation(nextId, name, location,timeOfObservation, numberObserved, context.queryParam("pictureUrl"), context.queryParam("comment"), animal);
    }
}
