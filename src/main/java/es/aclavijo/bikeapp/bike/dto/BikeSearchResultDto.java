package es.aclavijo.bikeapp.bike.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BikeSearchResultDto {

    List<BikeDto> results;
    int page;
    int size;
    String searchString;
    String order;
}
