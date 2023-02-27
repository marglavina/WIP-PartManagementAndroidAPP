package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.Network;
import com.zavrsnirad.R;

import com.zavrsnirad.adapters.SkladisteAdapter;
import com.zavrsnirad.model.CarBrand;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkladisteActivity extends AppCompatActivity {

    ListView superListView;
    StringBuilder sb = new StringBuilder();

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skladiste);

        Button addBtn = this.findViewById(R.id.button);
        addBtn.setText("Add, update or delete brand");
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent addBrand;
                addBrand = new Intent(SkladisteActivity.this, BrandEditActivity.class);
                addBrand.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String[] brands = sb.toString().split(",");
                addBrand.putExtra("brands", brands);
                v.getContext().getApplicationContext().startActivity(addBrand);
            }
        });

        Call<List<CarBrand>> call = Network.getInstance().carBrandRepository().carBrandList();

        call.enqueue(new Callback<List<CarBrand>>() {
            @Override
            public void onResponse(Call<List<CarBrand>> call, Response<List<CarBrand>> response) {
                List<CarBrand> carBrands = new ArrayList<CarBrand>(response.body());
                carBrands.forEach(t-> sb.append(t.getBrandName()+","));

                RecyclerView recyclerView = findViewById(R.id.oneCardRV);
                recyclerView.setLayoutManager(new LinearLayoutManager(SkladisteActivity.this));
                recyclerView.setAdapter(new SkladisteAdapter(getApplicationContext(), carBrands));
            }

            @Override
            public void onFailure(Call<List<CarBrand>> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();
            }
        });



    }
}
