package com.example.gestibank.remote;

import com.example.gestibank.models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface clientService {

    @GET("/clients/list/")
    Call<List<Client>> getClients();

    @POST("clients/add/")
    Call<Client> addClient(@Body Client client);
/*
    @PUT("update/{id}")
    Call<cClient> updateClient(@Path("id") int id, @Body cClient client);

    @DELETE("delete/{id}")
    Call<cClient> deleteClient(@Path("id") int id);*/
}