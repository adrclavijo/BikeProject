package es.aclavijo.bikeapp.bike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemsDto {

    private Integer id;
    private String model;
    private String type;
    private String description;
}
