package com.factory.warehouse.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Deal-warehous")
@Data
@Builder
@NoArgsConstructor
public class Deal  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

@NonNull
@NotBlank(message = "Name is mandatory")
    private String fromCurrencyISOCode;
@NonNull
@NotBlank(message = "Name is mandatory")
    private String toCurrencyISOCode;
@NonNull
@NotBlank(message = "Name is mandatory")
    private LocalDateTime timestamp;
@NonNull
@NotBlank(message = "Name is mandatory")
    private BigDecimal amount;

//constructor


    public Deal(Long uniqueId, @NonNull String fromCurrencyISOCode,
                @NonNull String toCurrencyISOCode, @NonNull LocalDateTime timestamp,
                @NonNull BigDecimal amount) {
        this.uniqueId = uniqueId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public boolean isValid() {
        return uniqueId != null && fromCurrencyISOCode != null && toCurrencyISOCode != null && timestamp != null && amount != null;
    }


}