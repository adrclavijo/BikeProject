package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.dto.BikeDto;
import es.aclavijo.bikeapp.bike.exceptions.BikeNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;

    @SneakyThrows
    public BikeDto getBike(Integer id) {
        return bikeRepository.findById(id).map(BikeMapper::bikeToDto).orElseThrow(() -> new BikeNotFoundException(id));
    }
}
