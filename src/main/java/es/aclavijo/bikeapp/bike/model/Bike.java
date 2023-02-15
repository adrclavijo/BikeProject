package es.aclavijo.bikeapp.bike.model;

import es.aclavijo.bikeapp.items.model.Items;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bike")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 250)
    private String description;

    @Column
    private Float price;

    @Column(length = 50)
    private String manufacturer;

    @OneToMany(mappedBy = "bike")
    private List<Items> items;

}
