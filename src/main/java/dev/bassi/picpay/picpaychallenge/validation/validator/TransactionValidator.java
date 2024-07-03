package dev.bassi.picpay.picpaychallenge.validation.validator;

import dev.bassi.picpay.picpaychallenge.controller.dto.TransactionDto;
import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.entity.WalletTypeEntity;
import dev.bassi.picpay.picpaychallenge.exception.InsufficientBalanceException;
import dev.bassi.picpay.picpaychallenge.exception.TransferNotAllowedForWalletTypeException;
import dev.bassi.picpay.picpaychallenge.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionValidator {

    private final AuthorizationService authorizationService;

    public void validate(TransactionDto data, WalletEntity sender) {

        if (!this.transferAllowedForWalletType(sender.getWalletTypeEntity())) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!this.isBalancerEqualOrGreatherThan(sender.getBalance(), data.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized()) {
            throw new InsufficientBalanceException();
        }

    }

    private boolean transferAllowedForWalletType(WalletTypeEntity walletType) {
        return WalletTypeEntity.Enum.USER.get().equals(walletType);
    }

    private boolean isBalancerEqualOrGreatherThan(BigDecimal balance, BigDecimal value) {
        return balance.compareTo(value) >= 0;
    }
}
