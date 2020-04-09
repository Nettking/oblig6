package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bird.class, name = "bird"),
        @JsonSubTypes.Type(value = Amphibian.class, name = "amphibian"),
        @JsonSubTypes.Type(value = Invertebrate.class, name = "invertebrate")

})
public abstract class Animal implements Comparable<Animal> {
    protected String commonName;
    protected String scientificName;

    protected Animal(String commonName, String scientificName) {
        this.commonName = commonName;
        this.scientificName = scientificName;
    }

    protected Animal() {
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    @Override
    public String toString() {
        return "Common name: " + commonName + " Scientific name: " + scientificName;
    }


    @Override
    public int compareTo(Animal other) {
        return commonName.compareTo(other.getCommonName());
    }
}
