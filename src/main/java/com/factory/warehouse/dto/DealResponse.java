package com.factory.warehouse.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder

public class DealResponse {
    @NotNull
    @NotBlank
    private Long uniqueId;

    @NotNull
    @NotBlank
    private String fromCurrencyISOCode;
    @NotNull
    @NotBlank
    private String toCurrencyISOCode;
    @NotNull
    @NotBlank
    private LocalDateTime timestamp;
    @NotNull
    @NotBlank
    private BigDecimal amount;

    //constructor


    public DealResponse(Long uniqueId, String fromCurrencyISOCode, String toCurrencyISOCode, LocalDateTime timestamp, BigDecimal amount) {
        this.uniqueId = uniqueId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public DealResponse() {

    }

    public boolean isValid() {
        return  uniqueId != null && fromCurrencyISOCode != null &&
                toCurrencyISOCode != null && timestamp != null && amount != null;
    }

}
