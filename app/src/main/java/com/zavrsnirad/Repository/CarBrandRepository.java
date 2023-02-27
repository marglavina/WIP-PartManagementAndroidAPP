package com.zavrsnirad.Repository;

import com.zavrsnirad.model.CarBrand;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CarBrandRepository {

    String BASE_URL = "";

    @GET("brand/carBrand")
    Call<List<CarBrand>> carBrandList();

    @POST("brand/carBrand")
    Call<CarBrand>carBrandAdd(@Body CarBrand cb);

    @PUT("brand/carBrand/{brandName}")
    Call<CarBrand>carBrandUpdate(@Path ("brandName") String brandName,@Body CarBrand cb);

    @DELETE("brand/carBrand/{brandName}")
    Call<Void>carBrandDelete(@Path ("brandName") String brandName);
}
