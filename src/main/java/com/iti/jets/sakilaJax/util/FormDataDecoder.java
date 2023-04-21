package com.iti.jets.sakilaJax.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


import jakarta.ws.rs.core.MultivaluedMap;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.utils.URLEncodedUtils;

public class FormDataDecoder {

//    public MultivaluedMap<String, String> decode(InputStream inputStream) throws IOException {
//        String formData = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
//        Iterable<NameValuePair> nameValuePairs = URLEncodedUtils.parse(formData, StandardCharsets.UTF_8);
//        MultivaluedMap<String, String> multivaluedMap = new MultivaluedHashMap<>();
//        for (NameValuePair nameValuePair : nameValuePairs) {
//            String name = nameValuePair.getName();
//            String value = nameValuePair.getValue();
//            multivaluedMap.add(name, value);
//        }
//        return multivaluedMap;
//    }
}
