package dev.bassi.picpay.picpaychallenge.repository;

import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}
