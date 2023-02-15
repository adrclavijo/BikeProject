package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.model.Bike;
import es.aclavijo.bikeapp.items.model.Items;
import static java.util.Optional.ofNullable;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class BikeDataFactory {

    @Builder(builderMethodName = "bikeBuilder")
    public static Bike bikeModelBuilder(Integer id,
                                        String name,
                                        String description,
                                        Float price,
                                        String manufacturer,
                                        List<Items> items) {
        return new Bike(
                ofNullable(id).orElse(25),
                ofNullable(name).orElse("name"),
                ofNullable(description).orElse("description"),
                ofNullable(price).orElse(899F),
                ofNullable(manufacturer).orElse("manufacturer"),
                ofNullable(items).orElse(new ArrayList<>())
        );

    }


}
