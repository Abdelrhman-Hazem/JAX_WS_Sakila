package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.mappers.interfaces.*;
import com.iti.jets.sakilaJax.persistence.entities.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:48+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class StoreMapperImpl implements StoreMapper {

    @Inject
    private StaffMapper staffMapper;
    @Inject
    private AddressMapper addressMapper;
    @Inject
    private InventoryMapper inventoryMapper;
    @Inject
    private CustomerMapper customerMapper;

    @Override
    public Store toEntity(StoreDto storeDto) {
        if ( storeDto == null ) {
            return null;
        }

        Store store = new Store();

        store.setStoreId( storeDto.getStoreId() );
        store.setStaff( staffMapper.toEntity1( storeDto.getStaff() ) );
        store.setAddress( addressMapper.toEntity( storeDto.getAddress() ) );
        store.setLastUpdate( storeDto.getLastUpdate() );
        store.setStaffs( staffDtoSimpleSetToStaffSet( storeDto.getStaffs() ) );
        store.setInventories( inventoryDtoSetToInventorySet( storeDto.getInventories() ) );
        store.setCustomers( customerDtoSimpleSetToCustomerSet( storeDto.getCustomers() ) );

        linkStaffs( store );
        linkInventories( store );
        linkCustomers( store );

        return store;
    }

    @Override
    public StoreDto toDto(Store store) {
        if ( store == null ) {
            return null;
        }

        Set<StaffDtoSimple> staffs = null;
        Set<InventoryDto> inventories = null;
        Set<CustomerDtoSimple> customers = null;
        Short storeId = null;
        StaffDtoSimple staff = null;
        AddressDto address = null;
        Timestamp lastUpdate = null;

        staffs = staffSetToStaffDtoSimpleSet( store.getStaffs() );
        inventories = inventorySetToInventoryDtoSet( store.getInventories() );
        customers = customerSetToCustomerDtoSimpleSet( store.getCustomers() );
        storeId = store.getStoreId();
        staff = staffMapper.toDto1( store.getStaff() );
        address = addressMapper.toDto( store.getAddress() );
        lastUpdate = store.getLastUpdate();

        StoreDto storeDto = new StoreDto( storeId, staff, address, lastUpdate, staffs, inventories, customers );

        return storeDto;
    }

    @Override
    public Store partialUpdate(StoreDto storeDto, Store store) {
        if ( storeDto == null ) {
            return store;
        }

        if ( storeDto.getStoreId() != null ) {
            store.setStoreId( storeDto.getStoreId() );
        }
        if ( storeDto.getStaff() != null ) {
            if ( store.getStaff() == null ) {
                store.setStaff( new Staff() );
            }
            staffMapper.partialUpdate1( storeDto.getStaff(), store.getStaff() );
        }
        if ( storeDto.getAddress() != null ) {
            if ( store.getAddress() == null ) {
                store.setAddress( new Address() );
            }
            addressMapper.partialUpdate( storeDto.getAddress(), store.getAddress() );
        }
        if ( storeDto.getLastUpdate() != null ) {
            store.setLastUpdate( storeDto.getLastUpdate() );
        }
        if ( store.getStaffs() != null ) {
            Set<Staff> set = staffDtoSimpleSetToStaffSet( storeDto.getStaffs() );
            if ( set != null ) {
                store.getStaffs().clear();
                store.getStaffs().addAll( set );
            }
        }
        else {
            Set<Staff> set = staffDtoSimpleSetToStaffSet( storeDto.getStaffs() );
            if ( set != null ) {
                store.setStaffs( set );
            }
        }
        if ( store.getInventories() != null ) {
            Set<Inventory> set1 = inventoryDtoSetToInventorySet( storeDto.getInventories() );
            if ( set1 != null ) {
                store.getInventories().clear();
                store.getInventories().addAll( set1 );
            }
        }
        else {
            Set<Inventory> set1 = inventoryDtoSetToInventorySet( storeDto.getInventories() );
            if ( set1 != null ) {
                store.setInventories( set1 );
            }
        }
        if ( store.getCustomers() != null ) {
            Set<Customer> set2 = customerDtoSimpleSetToCustomerSet( storeDto.getCustomers() );
            if ( set2 != null ) {
                store.getCustomers().clear();
                store.getCustomers().addAll( set2 );
            }
        }
        else {
            Set<Customer> set2 = customerDtoSimpleSetToCustomerSet( storeDto.getCustomers() );
            if ( set2 != null ) {
                store.setCustomers( set2 );
            }
        }

        linkStaffs( store );
        linkInventories( store );
        linkCustomers( store );

        return store;
    }

    protected Set<Staff> staffDtoSimpleSetToStaffSet(Set<StaffDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Staff> set1 = new LinkedHashSet<Staff>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StaffDtoSimple staffDtoSimple : set ) {
            set1.add( staffMapper.toEntity1( staffDtoSimple ) );
        }

        return set1;
    }

    protected Set<Inventory> inventoryDtoSetToInventorySet(Set<InventoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Inventory> set1 = new LinkedHashSet<Inventory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( InventoryDto inventoryDto : set ) {
            set1.add( inventoryMapper.toEntity( inventoryDto ) );
        }

        return set1;
    }

    protected Set<Customer> customerDtoSimpleSetToCustomerSet(Set<CustomerDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Customer> set1 = new LinkedHashSet<Customer>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CustomerDtoSimple customerDtoSimple : set ) {
            set1.add( customerMapper.toEntity1( customerDtoSimple ) );
        }

        return set1;
    }

    protected Set<StaffDtoSimple> staffSetToStaffDtoSimpleSet(Set<Staff> set) {
        if ( set == null ) {
            return null;
        }

        Set<StaffDtoSimple> set1 = new LinkedHashSet<StaffDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Staff staff : set ) {
            set1.add( staffMapper.toDto1( staff ) );
        }

        return set1;
    }

    protected Set<InventoryDto> inventorySetToInventoryDtoSet(Set<Inventory> set) {
        if ( set == null ) {
            return null;
        }

        Set<InventoryDto> set1 = new LinkedHashSet<InventoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Inventory inventory : set ) {
            set1.add( inventoryMapper.toDto( inventory ) );
        }

        return set1;
    }

    protected Set<CustomerDtoSimple> customerSetToCustomerDtoSimpleSet(Set<Customer> set) {
        if ( set == null ) {
            return null;
        }

        Set<CustomerDtoSimple> set1 = new LinkedHashSet<CustomerDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Customer customer : set ) {
            set1.add( customerMapper.toDto1( customer ) );
        }

        return set1;
    }
}
