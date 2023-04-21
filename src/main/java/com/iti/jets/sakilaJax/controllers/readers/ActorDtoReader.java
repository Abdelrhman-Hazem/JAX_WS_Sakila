package com.iti.jets.sakilaJax.controllers.readers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import com.iti.jets.sakilaJax.dtos.ActorDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class ActorDtoReader implements MessageBodyReader<ActorDto> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return ActorDto.class.isAssignableFrom(type);
    }

    @Override
    public ActorDto readFrom(Class<ActorDto> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                              MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {

//        MultivaluedMap<String, String> formData = new FormDataDecoder().decode(entityStream);
//        String name = formData.getFirst("name");
//        int age = Integer.parseInt(formData.getFirst("age"));
//        String gender = formData.getFirst("gender");
//        ActorDto actorDto = new ActorDto(name, age, gender);

        String[] userparts = new  String(entityStream.readAllBytes()).split("-");
        System.out.println(userparts[0]);
        return new ActorDto((short)1,"jkjk","jkhkjh",null);
    }


}
