package dev.bassi.picpay.picpaychallenge.controller;

import dev.bassi.picpay.picpaychallenge.controller.dto.CreateWalletDto;
import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.mapper.WalletMapper;
import dev.bassi.picpay.picpaychallenge.service.WalletService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@Tag(name = "Wallet", description = "Contains operations for managing the wallet.")
public class WalletController {

    private final WalletService service;

    @PostMapping("/wallet")
    public ResponseEntity<WalletEntity> create(@RequestBody @Valid CreateWalletDto data, UriComponentsBuilder uriBuilder) {
        var response = this.service.save(WalletMapper.MAPPER.mapToWalletEntity(data));
        var uri = uriBuilder.path("/wallet/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }


}
