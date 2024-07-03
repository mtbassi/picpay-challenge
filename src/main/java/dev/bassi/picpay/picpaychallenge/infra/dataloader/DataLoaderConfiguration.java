package dev.bassi.picpay.picpaychallenge.infra.dataloader;

import dev.bassi.picpay.picpaychallenge.entity.WalletType;
import dev.bassi.picpay.picpaychallenge.repository.WalletTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataLoaderConfiguration implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }

}
