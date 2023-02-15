package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.model.Bike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
    @Query("SELECT b FROM Bike b JOIN Items i ON b.id = i.bike.id WHERE b.name LIKE concat(concat('%', :searchString), '%') " +
            "OR b.manufacturer LIKE concat(concat('%', :searchString), '%') " +
            "OR i.type LIKE concat(concat('%', :searchString), '%')")
    Page<Bike> findByNameOrManufacturerOrItemType(String searchString, Pageable pageableFromRequest);
}
