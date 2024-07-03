package dev.bassi.picpay.picpaychallenge.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionDto(@DecimalMin("0.01") @NotNull BigDecimal value,
                             @NotNull Long payer,
                             @NotNull Long payee) {
}
