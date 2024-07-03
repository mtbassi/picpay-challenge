package dev.bassi.picpay.picpaychallenge.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDto(@DecimalMin("0.01") @NotNull BigDecimal value,
                             @NotNull Long payer,
                             @NotNull Long payee) {
}
