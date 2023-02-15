package es.aclavijo.bikeapp.bike;

import static es.aclavijo.bikeapp.bike.BikeMapper.searchResultFromDataAndRequest;
import es.aclavijo.bikeapp.bike.dto.BikeDto;
import es.aclavijo.bikeapp.bike.dto.BikeRequestDto;
import es.aclavijo.bikeapp.bike.dto.BikeSearchResultDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/bike")
public class BikeResource {

    @Autowired
    BikeService bikeService;

    @Cacheable("bike")
    @GetMapping("/{id}")
    public BikeDto getBike(@PathVariable Integer id) {
        return bikeService.getBike(id);
    }

    @PostMapping
    public BikeDto createBike(@RequestBody @Valid BikeDto bike) {
        return bikeService.createBike(bike);
    }

    @PostMapping("/find")
    public BikeSearchResultDto findBike(@RequestBody @Valid BikeRequestDto filterData) {
        return searchResultFromDataAndRequest(bikeService.findBike(filterData), filterData);
    }


}
