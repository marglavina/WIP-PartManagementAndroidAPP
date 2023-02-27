package com.zavrsnirad.Repository;

import com.zavrsnirad.model.CarModel;
import com.zavrsnirad.model.Part;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PartRepository {

    String BASE_URL = "";
    @GET("brand/parts/{id}")
    Call<List<Part>> partList(@Path(value = "id", encoded = true) String modelName);
}
