package com.logistrica_api.logistica.global.utils;

public class Operations {
    public static String trimBrackets(String message){
        return message.replaceAll("[\\[\\]]", "");
    }
}
