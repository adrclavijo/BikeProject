package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
}
