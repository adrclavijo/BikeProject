package es.aclavijo.bikeapp.items;

import es.aclavijo.bikeapp.items.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
