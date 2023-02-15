package es.aclavijo.bikeapp.items.model;

import es.aclavijo.bikeapp.bike.model.Bike;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Table(name = "items")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(length = 250)
    private String description;

    @With
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bike")
    private Bike bike;
}
