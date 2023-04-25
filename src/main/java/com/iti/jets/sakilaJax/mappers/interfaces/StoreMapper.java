package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.StoreDto;
import com.iti.jets.sakilaJax.persistence.entities.Store;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {StaffMapper.class, AddressMapper.class, StaffMapper.class, InventoryMapper.class, CustomerMapper.class})
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);

    @AfterMapping
    default void linkStaffs(@MappingTarget Store store) {
        if(store.getStaffs()!=null) store.getStaffs().forEach(staff -> staff.setStore(store));
    }

    @AfterMapping
    default void linkInventories(@MappingTarget Store store) {
        if(store.getInventories()!=null) store.getInventories().forEach(inventory -> inventory.setStore(store));
    }

    @AfterMapping
    default void linkCustomers(@MappingTarget Store store) {
        if(store.getCustomers()!=null)  store.getCustomers().forEach(customer -> customer.setStore(store));
    }
}