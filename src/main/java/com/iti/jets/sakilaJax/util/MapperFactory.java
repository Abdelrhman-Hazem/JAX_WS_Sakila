package com.iti.jets.sakilaJax.util;

import com.iti.jets.sakilaJax.mappers.impl.*;

public class MapperFactory {
//    public static final Map mappersMap;
//    static {
//        mappersMap = new HashMap<>();
//        mappersMap.put(ActorDto.class, ActorMapper.class);
//    }
    public static Object getMapper(String dtoClassName){
        switch (dtoClassName){
            case "ActorDto":
                return new ActorMapperImpl();
            case "AddressDto":
                return new AddressMapperImpl();
            case "CategoryDto":
                return new CategoryMapperImpl();
            case "CityDto":
                return new CityMapperImpl();
            case "CountryDto":
                return new CountryMapperImpl();
            case "CustomerDto":
                return new CustomerMapperImpl();
            case "FilmActorDto":
                return new FilmActorMapperImpl();
            case "FilmCategoryDto":
                return new FilmCategoryMapperImpl();
            case "FilmDto":
                return new FilmMapperImpl();
            case "FilmTextDto":
                return new FilmTextMapperImpl();
            case "InventoryDto":
                return new InventoryMapperImpl();
            case "LanguageDto":
                return new LanguageMapperImpl();
            case "PaymentDto":
                return new PaymentMapperImpl();
            case "RentalDto":
                return new RentalMapperImpl();
            case "StaffDto":
                return new StaffMapperImpl();
            case "StoreDto":
                return new StoreMapperImpl();
        }
        return null;
    }
}
