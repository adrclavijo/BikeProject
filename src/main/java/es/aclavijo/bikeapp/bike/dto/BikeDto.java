package es.aclavijo.bikeapp.bike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BikeDto {

    private Integer id;
    private String name;
    private String description;
    private Float price;
    private String manufacturer;
    private List<ItemsDto> items;
}
