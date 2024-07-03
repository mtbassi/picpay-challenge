package dev.bassi.picpay.picpaychallenge.repository;

import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
}
