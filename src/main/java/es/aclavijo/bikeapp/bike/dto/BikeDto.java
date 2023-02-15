package es.aclavijo.bikeapp.bike.dto;

import es.aclavijo.bikeapp.items.dto.ItemsDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@AllArgsConstructor
@Data
public class BikeDto {

    private Integer id;
    @NotBlank
    private String name;
    private String description;
    private Float price;
    private String manufacturer;
    @With
    private List<ItemsDto> items;
}
