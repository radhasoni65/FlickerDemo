package com.example.flickrdemo.api;

import com.example.flickrdemo.model.ImagesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @GET("services/feeds/photos_public.gne")
    @Headers("Content-Type: application/json")
    Call<ImagesModel> fetchImages(@Query("tags") String tag, @Query("format") String format, @Query("nojsoncallback") String cb);
}
