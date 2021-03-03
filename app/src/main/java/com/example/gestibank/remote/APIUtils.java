package com.example.gestibank.remote;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.1.54:81/";
    public static final String API_CONVERSION_URL = "https://api.exchangeratesapi.io/latest/";

    public static clientService getClientService(){
        return RetrofitClient.getClient(API_URL).create(clientService.class);
    }

    public static ConversionService getConversionService(){
        return RetrofitClient.getConversion(API_CONVERSION_URL).create(ConversionService.class);
    }

}