package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.FilmDto;
import com.iti.jets.sakilaJax.dtos.LanguageDto;
import com.iti.jets.sakilaJax.persistence.entities.FilmRating;
import com.iti.jets.sakilaJax.services.FilmServices;
import com.iti.jets.sakilaJax.services.LanguageServices;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC,
            use = SOAPBinding.Use.ENCODED ,
            parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class FilmController {

    public FilmDto[] getAllFilms (int page){
        return FilmServices.findAllPaged(page*100-100,page*100).toArray(FilmDto[]::new);
    }

    public FilmDto getFilmById (Short id){
        FilmDto dto = FilmServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public FilmDto addNewFilm(Short languageId, Short originalLanguageId,
                               String title, String description,
                               String releaseYear, Byte rentalDuration,
                               BigDecimal rentalRate, Short length,
                               BigDecimal replacementCost, FilmRating rating,
                               String specialFeatures){
        if(languageId==null || title ==null) throw new WrongParametersException("please enter firstName and lastName");

        LanguageDto languageDto = LanguageServices.findByid(languageId);
        if(languageDto == null) throw new NoSuchEntryException("No Such Language");
        LanguageDto originalLanguageDto = null;
        if(originalLanguageId!=null) {
            originalLanguageDto = LanguageServices.findByid(originalLanguageId);
            if (originalLanguageDto == null) throw new NoSuchEntryException("No Such Original Language");
        }
        Year releaseYearConverted = null;
        try {
            releaseYearConverted = Year.parse(releaseYear);
        }catch (DateTimeParseException e){
            throw new WrongParametersException("Incorrect year entered");
        }

        FilmDto dto = FilmServices.insert(new FilmDto(null,languageDto,originalLanguageDto,title,description,
                releaseYearConverted,rentalDuration, rentalRate,length,replacementCost,rating.getName(),specialFeatures,
                                                    Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public FilmDto updateFilm(Short id, Short languageId, Short originalLanguageId,
                               String title, String description,
                               String releaseYear, Byte rentalDuration,
                               BigDecimal rentalRate, Short length,
                               BigDecimal replacementCost, FilmRating rating,
                               String specialFeatures){
        if(id==null) throw new WrongParametersException("please enter id");

        LanguageDto languageDto = LanguageServices.findByid(languageId);
        if(languageDto == null) throw new NoSuchEntryException("No Such Language");
        LanguageDto originalLanguageDto = null;
        if(originalLanguageId!=null) {
            originalLanguageDto = LanguageServices.findByid(originalLanguageId);
            if (originalLanguageDto == null) throw new NoSuchEntryException("No Such Original Language");
        }
        Year releaseYearConverted = null;
        try {
            releaseYearConverted = Year.parse(releaseYear);
        }catch (DateTimeParseException e){
            throw new WrongParametersException("Incorrect year entered");
        }

        FilmDto dto = FilmServices.update(new FilmDto(id,languageDto,originalLanguageDto,title,description,
                releaseYearConverted,rentalDuration, rentalRate,length,replacementCost,rating.getName(),specialFeatures,
                Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public Boolean deleteFilmById (Short id){
        Boolean isDeleted = FilmServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
