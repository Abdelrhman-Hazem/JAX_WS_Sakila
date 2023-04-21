package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.persistence.entities.Rental;
import com.iti.jets.sakilaJax.dtos.RentalDto;
import com.iti.jets.sakilaJax.dtos.RentalDtoSimple;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface RentalMapper {
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);

    Rental toEntity1(RentalDtoSimple rentalDtoSimple);

    RentalDtoSimple toDto1(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate1(RentalDtoSimple rentalDtoSimple, @MappingTarget Rental rental);
}