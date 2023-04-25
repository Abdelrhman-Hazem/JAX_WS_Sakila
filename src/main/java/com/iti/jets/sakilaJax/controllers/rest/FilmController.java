package com.iti.jets.sakilaJax.controllers.rest;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.FilmDto;
import com.iti.jets.sakilaJax.dtos.LanguageDto;
import com.iti.jets.sakilaJax.dtos.StoreDtoSimple;
import com.iti.jets.sakilaJax.persistence.entities.FilmRating;
import com.iti.jets.sakilaJax.services.AddressServices;
import com.iti.jets.sakilaJax.services.FilmServices;
import com.iti.jets.sakilaJax.services.LanguageServices;
import com.iti.jets.sakilaJax.services.StoreServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Base64;
import java.util.List;

@Path("film")
public class FilmController {
    @GET
    @Produces({"application/xml", "application/json"})
    public Response getAllFilms (@DefaultValue("1") @QueryParam("page")int page){
        GenericEntity allList = new GenericEntity<List<FilmDto>>(FilmServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getFilmById (@PathParam("id")Short id){
        FilmDto dto = FilmServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    public Response addNewFilm(@FormParam("languageId")Short languageId, @FormParam("originalLanguageId") Short originalLanguageId,
                               @FormParam("title") String title, @FormParam("description") String description,
                               @FormParam("releaseYear") String releaseYear, @FormParam("rentalDuration") Byte rentalDuration,
                               @FormParam("rentalRate") BigDecimal rentalRate, @FormParam("length") Short length,
                               @FormParam("replacementCost") BigDecimal replacementCost, @FormParam("rating") FilmRating rating,
                               @FormParam("specialFeatures") String specialFeatures){
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
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Produces({"application/xml", "application/json"})
    public Response updateFilm(@FormParam("id")Short id, @FormParam("languageId")Short languageId, @FormParam("originalLanguageId") Short originalLanguageId,
                               @FormParam("title") String title, @FormParam("description") String description,
                               @FormParam("releaseYear") String releaseYear, @FormParam("rentalDuration") Byte rentalDuration,
                               @FormParam("rentalRate") BigDecimal rentalRate, @FormParam("length") Short length,
                               @FormParam("replacementCost") BigDecimal replacementCost, @FormParam("rating") FilmRating rating,
                               @FormParam("specialFeatures") String specialFeatures){
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
        return Response.ok().entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response deleteFilmById (@PathParam("id") Short id){
        Boolean isDeleted = FilmServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
