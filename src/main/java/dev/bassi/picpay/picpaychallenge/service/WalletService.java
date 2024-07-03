package dev.bassi.picpay.picpaychallenge.service;

import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repository;

    public WalletEntity create(WalletEntity entity){
        return this.repository.save(entity);
    }
}
