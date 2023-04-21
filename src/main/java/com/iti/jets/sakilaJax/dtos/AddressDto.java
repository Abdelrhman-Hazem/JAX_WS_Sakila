package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Address;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link Address} entity
 */
@XmlRootElement
public class AddressDto implements Serializable {
    private final Short addressId;
    private final CityDtoSimple city;
    private final String address;
    private final String address2;
    private final String district;
    private final String postalCode;
    private final String phone;
    private final byte[] location;
    private final Timestamp lastUpdate;

    public AddressDto(Short addressId, CityDtoSimple city, String address, String address2, String district, String postalCode, String phone, byte[] location, Timestamp lastUpdate) {
        this.addressId = addressId;
        this.city = city;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = location;
        this.lastUpdate = lastUpdate;
    }

    public Short getAddressId() {
        return addressId;
    }

    public CityDtoSimple getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getDistrict() {
        return district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public byte[] getLocation() {
        return location;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.addressId, entity.addressId) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.address2, entity.address2) &&
                Objects.equals(this.district, entity.district) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.location, entity.location) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, city, address, address2, district, postalCode, phone, location, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "addressId = " + addressId + ", " +
                "city = " + city + ", " +
                "address = " + address + ", " +
                "address2 = " + address2 + ", " +
                "district = " + district + ", " +
                "postalCode = " + postalCode + ", " +
                "phone = " + phone + ", " +
                "location = " + location + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}