package dev.bassi.picpay.picpaychallenge.controller;

import dev.bassi.picpay.picpaychallenge.controller.dto.TransactionDto;
import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import dev.bassi.picpay.picpaychallenge.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionEntity> tranfer(@RequestBody @Valid TransactionDto data) {
        var response = this.service.tranfer(data);
        return null;
    }
}
