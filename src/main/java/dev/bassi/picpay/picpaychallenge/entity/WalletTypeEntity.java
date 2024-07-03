package dev.bassi.picpay.picpaychallenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallet_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @AllArgsConstructor
    public enum Enum {

        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private final Long id;

        private final String description;

        public WalletTypeEntity get() {
            return new WalletTypeEntity(id, description);
        }
    }

}
