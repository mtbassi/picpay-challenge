package dev.bassi.picpay.picpaychallenge.service;

import dev.bassi.picpay.picpaychallenge.controller.dto.TransactionDto;
import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import dev.bassi.picpay.picpaychallenge.repository.TransactionRepository;
import dev.bassi.picpay.picpaychallenge.validation.validator.TransactionValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletService walletService;

    private final TransactionValidator transactionValidator;

    private final NotificationService notificationService;

    private final TransactionRepository repository;

    @Transactional
    public TransactionEntity tranfer(TransactionDto data) {

        var payer = this.walletService.findById(data.payer());
        var payee = this.walletService.findById(data.payer());

        this.transactionValidator.validate(data, payer);

        payee.debit(data.value());
        payer.credit(data.value());

        var transaction = TransactionEntity.builder()
                .sender(payer)
                .receiver(payee)
                .value(data.value())
                .build();

        this.walletService.save(payer);
        this.walletService.save(payee);
        var transactionEntity = this.repository.save(transaction);

        CompletableFuture.runAsync(() -> this.notificationService.sendNotification(transactionEntity));

        return transactionEntity;
    }
}
