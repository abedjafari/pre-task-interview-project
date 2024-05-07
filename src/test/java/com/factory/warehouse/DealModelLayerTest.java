package com.factory.warehouse;

import com.factory.warehouse.model.Deal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DealModelLayerTest {

    @Test
    public void testNotNullFields() {
        Deal deal = new Deal();
        deal.setUniqueId(1L);
        deal.setFromCurrencyISOCode("USD");
        deal.setToCurrencyISOCode("EUR");
        deal.setTimestamp(LocalDateTime.now());
        deal.setAmount(BigDecimal.TEN);

        assertNotNull(deal.getUniqueId());
        assertNotNull(deal.getFromCurrencyISOCode());
        assertNotNull(deal.getToCurrencyISOCode());
        assertNotNull(deal.getTimestamp());
        assertNotNull(deal.getAmount());
    }

    @Test
    public void testNotBlankFields() {
        Deal deal = new Deal();

       assertThrows(ConstraintViolationException.class, () -> {
            deal.setFromCurrencyISOCode("");
            deal.setToCurrencyISOCode("EUR");
            deal.setTimestamp(LocalDateTime.now());
            deal.setAmount(BigDecimal.TEN);
        });

        assertThrows(ConstraintViolationException.class, () -> {
            deal.setFromCurrencyISOCode("USD");
            deal.setToCurrencyISOCode("");
            deal.setTimestamp(LocalDateTime.now());
            deal.setAmount(BigDecimal.TEN);
        });

        assertThrows(ConstraintViolationException.class, () -> {
            deal.setFromCurrencyISOCode("USD");
            deal.setToCurrencyISOCode("EUR");
            deal.setTimestamp(null);
            deal.setAmount(BigDecimal.TEN);
        });

        assertThrows(ConstraintViolationException.class, () -> {
            deal.setFromCurrencyISOCode("USD");
            deal.setToCurrencyISOCode("EUR");
            deal.setTimestamp(LocalDateTime.now());
            deal.setAmount(null);
        });
    }

    @Test
    public void testEqualsAndHashCode() {
        Deal deal1 = new Deal();
        deal1.setFromCurrencyISOCode("USD");
        deal1.setToCurrencyISOCode("EUR");
        deal1.setTimestamp(LocalDateTime.now());
        deal1.setAmount(BigDecimal.TEN);

        Deal deal2 = new Deal();
        deal2.setFromCurrencyISOCode("USD");
        deal2.setToCurrencyISOCode("EUR");
        deal2.setTimestamp(LocalDateTime.now());
        deal2.setAmount(BigDecimal.TEN);

        assertEquals(deal1, deal2);
        assertEquals(deal1.hashCode(), deal2.hashCode());
    }


}
