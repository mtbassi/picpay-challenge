package dev.bassi.picpay.picpaychallenge.controller;

import dev.bassi.picpay.picpaychallenge.controller.dto.TransactionDto;
import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import dev.bassi.picpay.picpaychallenge.service.TransactionService;
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
@Tag(name = "Transaction", description = "Contains operations for managing the transaction.")
public class TransactionController {

    private final TransactionService service;

    @Operation(summary = "Transaction.",
            description = "Feature creates a new transfer.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameters.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class)))
            })
    @PostMapping("/transaction")
    public ResponseEntity<TransactionEntity> tranfer(@RequestBody @Valid TransactionDto data, UriComponentsBuilder uriBuilder) {
        var response = this.service.tranfer(data);
        var uri = uriBuilder.path("/transaction").build().toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
