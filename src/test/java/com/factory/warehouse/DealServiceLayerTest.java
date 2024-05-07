package com.factory.warehouse;

import com.factory.warehouse.dto.DealRequest;
import com.factory.warehouse.dto.DealResponse;
import com.factory.warehouse.model.Deal;
import com.factory.warehouse.repository.DealRepository;
import com.factory.warehouse.service.DealService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class DealServiceLayerTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealService dealService;

    @Test
    public void testGetDealByUniqueId() {
        // Prepare test data
        Long uniqueId = 123L;
        Deal deal = new Deal(); // Create a mock Deal object
        when(dealRepository.findByUniqueId(uniqueId)).thenReturn(deal);

        // Invoke the method to be tested
        DealResponse result = dealService.getDealByUinqueId(uniqueId);

        // Verify that dealRepository.findByUniqueId is called with the expected argument
        verify(dealRepository).findByUniqueId(uniqueId);


    }

    @Test
    public void testGetAllDeals() {
        // Prepare test data
        List<Deal> deals = new ArrayList<>();
        // Add some mock deals to the list
        when(dealRepository.findAll()).thenReturn(deals);

        // Invoke the method to be tested
        List<DealResponse> result = dealService.getAllDeals();

        // Verify that dealRepository.findAll is called
        verify(dealRepository).findAll();


    }

    @Test
    public void testCreateDeal() throws Exception {
        // Prepare test data
        Deal deal = new Deal();
        DealRequest dealRequest = new DealRequest(); // Create a mock DealRequest object
        when(dealRequest.isValid()).thenReturn(true);

        // Invoke the method to be tested
        dealService.createDeal(dealRequest);

        // Verify that dealRepository.save is called
        verify(dealRepository).save(deal);


    }

    @Test
    public void testDeleteDeal() {
        // Prepare test data
        Long uniqueId = 123L;

        // Invoke the method to be tested
        dealService.deleteDeal(uniqueId);

        // Verify that dealRepository.deleteById is called with the expected argument
        verify(dealRepository).deleteById(uniqueId);


    }

    }




