package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.Network;
import com.zavrsnirad.R;
import com.zavrsnirad.adapters.ModelAdapter;

import com.zavrsnirad.model.CarModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelActivity extends AppCompatActivity {

    String brandName;
    String[] models;
    StringBuilder sb = new StringBuilder();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skladiste);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            brandName = bundle.get("brandName").toString();
        }

        Button addBtn = this.findViewById(R.id.button);
        addBtn.setText("Add model");
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                models = sb.toString().split(",");
                Intent addModel;
                addModel = new Intent(ModelActivity.this, ModelEditActivity.class);
                addModel.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                addModel.putExtra("models", models);
                v.getContext().getApplicationContext().startActivity(addModel);
            }
        });

        Call<List<CarModel>> call = Network.getInstance().carModelRepository().carModelList(brandName);

        call.enqueue(new Callback<List<CarModel>>() {
            @Override
            public void onResponse(Call<List<CarModel>> call, Response<List<CarModel>> response) {
                List<CarModel> carModels = new ArrayList<CarModel>(response.body());

                carModels.forEach(t-> sb.append(t.getModelName()+",") );
                RecyclerView recyclerView = findViewById(R.id.oneCardRV);
                recyclerView.setLayoutManager(new LinearLayoutManager(ModelActivity.this));
                recyclerView.setAdapter(new ModelAdapter(getApplicationContext(), carModels));
            }

            @Override
            public void onFailure(Call<List<CarModel>> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });



    }
}
