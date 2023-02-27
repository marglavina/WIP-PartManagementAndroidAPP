package com.zavrsnirad;

import com.zavrsnirad.Repository.CarBrandRepository;
import com.zavrsnirad.Repository.CarModelRepository;
import com.zavrsnirad.Repository.PartRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static Network instance = null;
    private CarBrandRepository carBrandRepository;
    private CarModelRepository carModelRepository;
    private PartRepository partRepository;
    Retrofit retrofit;

    private Network() {
        retrofit = new Retrofit.Builder().baseUrl(CarBrandRepository.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public CarBrandRepository carBrandRepository() {
        return carBrandRepository = retrofit.create(CarBrandRepository.class);
    }
    public CarModelRepository carModelRepository() {
        return carModelRepository = retrofit.create(CarModelRepository.class);
    }

    public PartRepository partRepository() {
        return partRepository = retrofit.create(PartRepository.class);
    }
}
