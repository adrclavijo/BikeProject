package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.dto.BikeRequestDto;
import es.aclavijo.bikeapp.bike.exceptions.BikeNotFoundException;
import es.aclavijo.bikeapp.bike.model.Bike;
import es.aclavijo.bikeapp.items.ItemsRepository;
import es.aclavijo.bikeapp.items.model.Items;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BikeServiceTest {

    @Mock
    BikeRepository mockBikeRepository;

    @Mock
    ItemsRepository mockItemsRepository;

    @InjectMocks
    BikeService bikeService;


    @Test
    void getBike_onValidId_bikeIsReturned() {
        //Given
        var bike = BikeDataFactory.bikeBuilder().build();
        given(mockBikeRepository.findById(anyInt())).willReturn(Optional.of(bike));

        //When
        var result = bikeService.getBike(bike.getId());

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BikeMapper.bikeToDto(bike));
    }

    @Test
    void getBike_onInvalidId_errorIsReturned() {
        //Given
        given(mockBikeRepository.findById(anyInt())).willReturn(Optional.empty());

        //When
        var exception = assertThrows(BikeNotFoundException.class, () -> bikeService.getBike(1));

        //Then
        assertThat(exception).isNotNull();
        assertThat(exception.getMessage()).isEqualTo("The bike with ID 1 couldn't be found");
    }

    @Test
    void createBike_onValidData() {
        //Given
        var items = BikeDataFactory.itemsBuilder().build();
        var bike = BikeDataFactory.bikeBuilder().items(List.of(items)).build();
        given(mockBikeRepository.save(any(Bike.class))).willReturn(bike);
        given(mockItemsRepository.save(any(Items.class))).willReturn(items);

        //When
        var result = bikeService.createBike(BikeMapper.bikeToDto(bike));

        //Then
        assertThat(result).isNotNull();
        assertThat(result.getItems()).isNotEmpty();
        assertAll("Input and output are equals",
                () -> assertNotNull(result.getId()),
                () -> assertNotNull(result.getItems().get(0).getId()),
                () -> assertEquals(bike.getName(), result.getName()),
                () -> assertEquals(bike.getDescription(), result.getDescription()),
                () -> assertEquals(bike.getPrice(), result.getPrice()),
                () -> assertEquals(bike.getManufacturer(), result.getManufacturer()),
                () -> assertEquals(bike.getItems().get(0).getModel(), result.getItems().get(0).getModel()),
                () -> assertEquals(bike.getItems().get(0).getType(), result.getItems().get(0).getType()),
                () -> assertEquals(bike.getItems().get(0).getDescription(), result.getItems().get(0).getDescription())
        );
    }

    @Test
    void findBike_onCoincidentData_bikeAreReturned() {
        //Given
        var bike = BikeDataFactory.bikeBuilder().build();
        given(mockBikeRepository.findByNameOrManufacturerOrItemType(anyString(), any())).willReturn(new PageImpl<>(List.of(bike)));

        //When
        var result = bikeService.findBike(new BikeRequestDto("bike", "asc", 0, 1));

        //Then
        assertThat(result).isNotEmpty();
        assertThat(result).contains(BikeMapper.bikeToDto(bike));
    }

    @Test
    void findBike_onNonCoincidentData_emptyResultIsReturned() {
        //Given
        given(mockBikeRepository.findByNameOrManufacturerOrItemType(anyString(), any())).willReturn(Page.empty());

        //When
        var result = bikeService.findBike(new BikeRequestDto("invalid", "asc", 0, 1));

        //Then
        assertThat(result).isEmpty();
    }

}
