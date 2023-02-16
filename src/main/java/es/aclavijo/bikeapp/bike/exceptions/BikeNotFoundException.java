package es.aclavijo.bikeapp.bike.exceptions;

import java.io.Serial;

public class BikeNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = -2195721870479257491L;

    public BikeNotFoundException(Integer id) {
        super(String.format("The bike with ID %d couldn't be found", id));
    }

}
