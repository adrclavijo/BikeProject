package es.aclavijo.bikeapp.bike;

import es.aclavijo.bikeapp.bike.exceptions.BikeNotFoundException;
import es.aclavijo.bikeapp.items.ItemsRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

}
