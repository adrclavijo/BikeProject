package es.aclavijo.bikeapp.bike.dto;

import lombok.Data;

@Data
public class BikeRequestDto {

    String searchString;
    String order;
    int page;
    int size;
}
