package es.aclavijo.bikeapp.bike;

import static es.aclavijo.bikeapp.bike.BikeMapper.bikeDtoToModel;
import static es.aclavijo.bikeapp.bike.BikeMapper.bikeToDto;
import static es.aclavijo.bikeapp.bike.BikeMapper.itemsDtoToModel;
import es.aclavijo.bikeapp.bike.dto.BikeDto;
import es.aclavijo.bikeapp.bike.dto.BikeRequestDto;
import es.aclavijo.bikeapp.bike.exceptions.BikeNotFoundException;
import es.aclavijo.bikeapp.items.ItemsRepository;
import es.aclavijo.bikeapp.items.model.Items;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @SneakyThrows
    public BikeDto getBike(Integer id) {
        return bikeRepository.findById(id).map(BikeMapper::bikeToDto).orElseThrow(() -> new BikeNotFoundException(id));
    }

    public BikeDto createBike(BikeDto bike) {
        var persistedBike = bikeRepository.save(bikeDtoToModel(bike));
        List<Items> persistedItems = new ArrayList<>();
        bike.getItems().forEach(item -> persistedItems.add(itemsRepository.save(itemsDtoToModel(item).withBike(persistedBike))));
        return bikeToDto(persistedBike).withItems(persistedItems.stream().map(BikeMapper::itemsToDto).toList());
    }

    public List<BikeDto> findBike(BikeRequestDto filterData) {
        return bikeRepository.findByNameOrManufacturerOrItemType(filterData.getSearchString(), createPageableFromRequest(filterData))
                .getContent().stream().map(BikeMapper::bikeToDto).toList();
    }

    private Pageable createPageableFromRequest(BikeRequestDto filterData) {
        if (null == filterData.getOrder()) {
            return PageRequest.of(filterData.getPage(), filterData.getSize());
        }
        Sort s;
        if (filterData.getOrder().equals("asc")) {
            s = Sort.by("b.name");
        } else {
            s = Sort.by("b.name").descending();
        }
        return PageRequest.of(filterData.getPage(), filterData.getSize(), s);
    }
}
