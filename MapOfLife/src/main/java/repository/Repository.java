package repository;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Observation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository implements IRepository {
    private final String fileName;
    private final ObjectMapper objectMapper;

    public Repository(String fileName) {
        this.fileName = fileName;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void addObservation(Observation observation) {
        List<Observation> observations = readObservations();
        observations.add(observation);
        writeObservations(observations);
    }

    @Override
    public List<Observation> readObservations() {
        try {
            Observation[] array = objectMapper.readValue(new File(fileName), Observation[].class);
            return new ArrayList<Observation>(Arrays.asList(array));
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateObservation(int id, Observation observation) {

    }

    @Override
    public void deleteObservation(int id) {

    }

    @Override
    public void writeObservations(List<Observation> observations) {
        try {
            objectMapper.writeValue(new File(fileName), observations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
