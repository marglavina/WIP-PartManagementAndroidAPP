package com.zavrsnirad.Repository;

import com.zavrsnirad.model.CarBrand;
import com.zavrsnirad.model.CarModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarModelRepository {
    String BASE_URL = "";
    @GET("brand/carModel/{id}")
    Call<List<CarModel>> carModelList(@Path(value = "id", encoded = true) String brandName);


    @POST("brand/carModel/{brandName}")
    Call<CarModel>carModelAdd(@Body CarModel cm, @Path(value = "brandName") String brandName);

    @PUT("brand/carModel/{modelName}")
    Call<CarModel>carModelUpdate(@Path ("modelName") String modelName,@Body CarModel cm);

    @DELETE("brand/carModel/{modelName}")
    Call<Void>carModelDelete(@Path ("modelName") String modelName);
}
