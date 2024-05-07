package com.factory.warehouse;


import com.factory.warehouse.controller.DealController;
import com.factory.warehouse.dto.DealRequest;
import com.factory.warehouse.dto.DealResponse;
import com.factory.warehouse.model.Deal;
import com.factory.warehouse.service.DealService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class DealControllerlayerTest {
    @InjectMocks
    private DealController dealController;
    @MockBean
    private DealService dealService;


    @Test
    public void testGetAllDeals() {
        Deal deal= new Deal();
        DealResponse dealResponse = DealResponse.builder()
                .uniqueId(deal.getUniqueId())
                .fromCurrencyISOCode(deal.getFromCurrencyISOCode())
                .toCurrencyISOCode(deal.getToCurrencyISOCode())
                .timestamp(deal.getTimestamp())
                .amount(deal.getAmount())
                .build();
        List<DealResponse> mockDealResponses = Collections.singletonList(dealResponse);
        when(dealService.getAllDeals()).thenReturn(mockDealResponses);

        List<DealResponse> response = dealController.getAllDeals();

        assertEquals(mockDealResponses.size(), response.size());
        verify(dealService).getAllDeals();
    }

    @Test
    public void testCreateDeal() throws Exception {
        DealRequest dealRequest = new DealRequest();
        doNothing().when(dealService).createDeal(dealRequest);

        dealController.createDeal(dealRequest);

        verify(dealService).createDeal(dealRequest);
    }
    @Test
    public void testUpdateDeal() throws Exception {
        // Prepare test data
        Long uniqueId = 123L;
        DealRequest dealRequest = new DealRequest(); // Create a mock DealRequest object
        DealResponse expectedResponse = new DealResponse(); // Create a mock DealResponse object

        // Mock behavior of dealService.updateDeal
        when(dealService.updateDeal(uniqueId, dealRequest)).thenReturn(expectedResponse);

        // Invoke the method to be tested
        DealResponse response = dealController.updateDeal(uniqueId, dealRequest);

        // Verify that dealService.updateDeal is called with the expected arguments
        verify(dealService).updateDeal(uniqueId, dealRequest);

        // Verify the returned response
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testDeleteDeal() {
        // Prepare test data
        Long uniqueId = 123L;

        // Invoke the method to be tested
        dealController.deleteDeal(uniqueId);

        // Verify that dealService.deleteDeal is called with the expected argument
        verify(dealService).deleteDeal(uniqueId);
    }
}




