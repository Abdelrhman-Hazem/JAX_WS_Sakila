package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.CustomerDto;
import com.iti.jets.sakilaJax.persistence.entities.Customer;
import com.iti.jets.sakilaJax.dtos.CustomerDtoSimple;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {AddressMapper.class})
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);

    @AfterMapping
    default void linkPayments(@MappingTarget Customer customer) {
        customer.getPayments().forEach(payment -> payment.setCustomer(customer));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Customer customer) {
        customer.getRentals().forEach(rental -> rental.setCustomer(customer));
    }

    Customer toEntity1(CustomerDtoSimple customerDtoSimple);

    CustomerDtoSimple toDto1(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate1(CustomerDtoSimple customerDtoSimple, @MappingTarget Customer customer);
}