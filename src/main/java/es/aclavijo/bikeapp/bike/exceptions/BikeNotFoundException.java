package es.aclavijo.bikeapp.bike.exceptions;

public class BikeNotFoundException extends Exception {

    public BikeNotFoundException(Integer id) {
        super(String.format("The bike with ID %d couldn't be found", id));
    }

}
