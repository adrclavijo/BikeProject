package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.dto.BikeDto;
import es.aclavijo.bikeapp.bike.dto.BikeRequestDto;
import es.aclavijo.bikeapp.bike.dto.BikeSearchResultDto;
import es.aclavijo.bikeapp.items.dto.ItemsDto;
import es.aclavijo.bikeapp.bike.model.Bike;
import es.aclavijo.bikeapp.items.model.Items;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.List;

@UtilityClass
public class BikeMapper {

    public static BikeDto bikeToDto(Bike bike) {
        return new BikeDto(
                bike.getId(),
                bike.getName(),
                bike.getDescription(),
                bike.getPrice(),
                bike.getManufacturer(),
                bike.getItems().stream().map(BikeMapper::itemsToDto).toList()
        );
    }

    public static Bike bikeDtoToModel(BikeDto bike) {
        return new Bike(
                bike.getId(),
                bike.getName(),
                bike.getDescription(),
                bike.getPrice(),
                bike.getManufacturer(),
                new LinkedList<>()
        );
    }

    public static ItemsDto itemsToDto(Items item) {
        return new ItemsDto(
                item.getId(),
                item.getModel(),
                item.getType(),
                item.getDescription()
        );
    }

    public static Items itemsDtoToModel(ItemsDto item) {
        return new Items(
                item.getId(),
                item.getModel(),
                item.getType(),
                item.getDescription(),
                null
        );
    }

    public static BikeSearchResultDto searchResultFromDataAndRequest(List<BikeDto> bikeList, BikeRequestDto request) {
        return new BikeSearchResultDto(bikeList,
                request.getPage(),
                request.getSize(),
                request.getSearchString(),
                request.getOrder());
    }
}
