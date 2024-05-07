package com.factory.warehouse.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DealRequest {

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


    public DealRequest() {

    }



    public boolean isValid() {
        return   fromCurrencyISOCode != null &&
                toCurrencyISOCode != null && timestamp != null && amount != null;
    }


}