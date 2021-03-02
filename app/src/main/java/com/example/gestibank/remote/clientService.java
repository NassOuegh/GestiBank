package com.example.gestibank.remote;

import com.example.gestibank.models.client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface clientService {

    @GET("list/")
    Call<List<client>> getClients();

    @POST("add/")
    Call<client> addClient(@Body client client);

    @PUT("update/{id}")
    Call<client> updateClient(@Path("id") int id, @Body client client);

    @DELETE("delete/{id}")
    Call<client> deleteClient(@Path("id") int id);
}