package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.dto.BikeDto;
import es.aclavijo.bikeapp.bike.model.Bike;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;

@UtilityClass
public class BikeMapper {

    public static BikeDto bikeToDto(Bike bike) {
        return new BikeDto(
                bike.getId(),
                bike.getName(),
                bike.getDescription(),
                bike.getPrice(),
                bike.getManufacturer(),
                new LinkedList<>()
        );
    }
}
