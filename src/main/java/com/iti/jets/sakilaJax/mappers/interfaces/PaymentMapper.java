package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.PaymentDto;
import com.iti.jets.sakilaJax.persistence.entities.Payment;
import com.iti.jets.sakilaJax.dtos.PaymentDtoSimple;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PaymentMapper {
    Payment toEntity(PaymentDto paymentDto);

    PaymentDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentDto paymentDto, @MappingTarget Payment payment);

    Payment toEntity1(PaymentDtoSimple paymentDtoSimple);

    PaymentDtoSimple toDto1(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate1(PaymentDtoSimple paymentDtoSimple, @MappingTarget Payment payment);
}