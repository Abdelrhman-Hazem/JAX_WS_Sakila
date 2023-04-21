package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.StaffDto;
import com.iti.jets.sakilaJax.dtos.StaffDtoSimple;
import com.iti.jets.sakilaJax.persistence.entities.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {AddressMapper.class, PaymentMapper.class, RentalMapper.class})
public interface StaffMapper {
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffDto staffDto, @MappingTarget Staff staff);

    @AfterMapping
    default void linkPayments(@MappingTarget Staff staff) {
        staff.getPayments().forEach(payment -> payment.setStaff(staff));
    }

    @AfterMapping
    default void linkStores(@MappingTarget Staff staff) {
        staff.getStores().forEach(store -> store.setStaff(staff));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Staff staff) {
        staff.getRentals().forEach(rental -> rental.setStaff(staff));
    }

    Staff toEntity1(StaffDtoSimple staffDtoSimple);

    StaffDtoSimple toDto1(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate1(StaffDtoSimple staffDtoSimple, @MappingTarget Staff staff);
}