package dev.bassi.picpay.picpaychallenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private WalletEntity sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private WalletEntity receiver;

    private BigDecimal value;

}
