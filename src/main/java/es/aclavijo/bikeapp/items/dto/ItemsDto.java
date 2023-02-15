package es.aclavijo.bikeapp.items.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
public class ItemsDto {

    private Integer id;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
    private String description;
}
