package dev.bassi.picpay.picpaychallenge.controller.dto;

import dev.bassi.picpay.picpaychallenge.entity.WalletTypeEntity;
import dev.bassi.picpay.picpaychallenge.validation.pattern.DocumentRegexPattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateWalletDto(@NotBlank String fullName,
                              @NotBlank
                              @Pattern(regexp = DocumentRegexPattern.DOCUMENT_REGEX_PATTERN)
                              String document,
                              @NotBlank
                              @Email
                              String email,
                              @NotBlank String password,
                              @NotNull WalletTypeEntity.Enum walletTypeEnum) {
}
