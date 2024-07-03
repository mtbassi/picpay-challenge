package dev.bassi.picpay.picpaychallenge.mapper;

import dev.bassi.picpay.picpaychallenge.controller.dto.CreateWalletDto;
import dev.bassi.picpay.picpaychallenge.entity.WalletEntity;
import dev.bassi.picpay.picpaychallenge.entity.WalletTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletMapper {

    WalletMapper MAPPER = Mappers.getMapper(WalletMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "balance", expression = "java(java.math.BigDecimal.ZERO)")
    @Mapping(target = "walletTypeEntity", source = "walletTypeEnum", qualifiedByName = "enumToEntity")
    WalletEntity mapToWalletEntity(CreateWalletDto data);

    @Named("enumToEntity")
    default WalletTypeEntity enumToEntity(WalletTypeEntity.Enum walletTypeEnum) {
        return walletTypeEnum.get();
    }

}
