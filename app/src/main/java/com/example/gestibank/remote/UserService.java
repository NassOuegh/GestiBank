package com.example.gestibank.remote;

import com.example.gestibank.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/list/")
    Call<List<User>> getUsers();

    @GET("users/list/{mail}/")
    Call<User> getUsersMail(@Path("mail") String mail);

    /*
    @POST("agents/add/")
    Call<User> addUsers(@Body User user);

    @PUT("update/{id}")
    Call<cClient> updateClient(@Path("id") int id, @Body cClient client);

    @DELETE("delete/{id}")
    Call<cClient> deleteClient(@Path("id") int id);*/
}
