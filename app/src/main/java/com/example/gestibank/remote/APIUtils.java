package com.example.gestibank.remote;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.1.54:81/users/";

    public static clientService getClientService(){
        return RetrofitClient.getClient(API_URL).create(clientService.class);
    }

}