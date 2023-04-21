package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.LanguageDto;
import com.iti.jets.sakilaJax.mappers.impl.LanguageMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Language;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class LanguageServices {
    private static final BasicCRUDS<Language> repo = new BasicCRUDS<>(Language.class);
    private static final LanguageMapperImpl mapper = new LanguageMapperImpl();
    public static LanguageDto findByid(Short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<LanguageDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static LanguageDto update(LanguageDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getLanguageId()))));
    }
    public static LanguageDto insert(LanguageDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Short id){
        return repo.deleteEntityById(id);
    }
}
