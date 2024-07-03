package dev.bassi.picpay.picpaychallenge.service;

import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.exception.WalletNotFoundException;
import dev.bassi.picpay.picpaychallenge.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repository;

    public WalletEntity save(WalletEntity entity){
        return this.repository.save(entity);
    }

    public WalletEntity findById(Long id){
        return this.repository.findById(id).orElseThrow(() -> new WalletNotFoundException(id));
    }
}
