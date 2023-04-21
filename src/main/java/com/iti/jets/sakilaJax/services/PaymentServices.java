package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.PaymentDto;
import com.iti.jets.sakilaJax.mappers.impl.PaymentMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Payment;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentServices {
    private static final BasicCRUDS<Payment> repo = new BasicCRUDS<>(Payment.class);
    private static final PaymentMapperImpl mapper = new PaymentMapperImpl();
    public static PaymentDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<PaymentDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static PaymentDto update(PaymentDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getPaymentId()))));
    }
    public static PaymentDto insert(PaymentDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
