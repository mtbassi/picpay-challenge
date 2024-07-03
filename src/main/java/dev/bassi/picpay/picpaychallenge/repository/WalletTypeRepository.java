package dev.bassi.picpay.picpaychallenge.repository;

import dev.bassi.picpay.picpaychallenge.entity.WalletTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletTypeEntity, Long> {
}
