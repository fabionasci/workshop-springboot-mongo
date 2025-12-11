package com.curso.java.completo.workshop_mongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
@Deprecated
public class URL {

    public static final String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


}
