package es.aclavijo.bikeapp.bike.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BikeRequestDto {

    String searchString;
    String order;
    int page;
    int size;
}
