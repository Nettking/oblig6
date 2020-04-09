package repository;

import model.Observation;

import java.util.List;

public interface IRepository {
    void addObservation(Observation observation);
    List<Observation> readObservations();
    void updateObservation(int id, Observation observation);
    void deleteObservation(int id);
    void writeObservations(List<Observation> observations);

}
