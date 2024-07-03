package dev.bassi.picpay.picpaychallenge.controller;

import dev.bassi.picpay.picpaychallenge.controller.dto.CreateWalletDto;
import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.mapper.WalletMapper;
import dev.bassi.picpay.picpaychallenge.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
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

    @Operation(summary = "Wallet.",
            description = "Feature creates a new wallet.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameters.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class)))
            })
    @PostMapping("/wallet")
    public ResponseEntity<WalletEntity> create(@RequestBody @Valid CreateWalletDto data, UriComponentsBuilder uriBuilder) {
        var response = this.service.save(WalletMapper.MAPPER.mapToWalletEntity(data));
        var uri = uriBuilder.path("/wallet/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }


}
