package com.zavrsnirad.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zavrsnirad.Network;
import com.zavrsnirad.R;
import com.zavrsnirad.model.CarBrand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdajaActivity extends AppCompatActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodaja);

        Call<List<CarBrand>> call = Network.getInstance().getMyApi().carBrandList();
        call.enqueue(new Callback<List<CarBrand>>() {
            @Override
            public void onResponse(Call<List<CarBrand>> call, Response<List<CarBrand>> response) {
                List<CarBrand> carBrandList1 =response.body();
                String [] carBrandListField = new String[carBrandList1.size()];
                for (int i = 0; i < carBrandList1.size(); i++) {
                    carBrandListField[i] = carBrandList1.get(i).getBrandName();
                }

                TextView textView = findViewById(R.id.textView2);
                textView.setText(""+carBrandListField[1]);
            }

            @Override
            public void onFailure(Call<List<CarBrand>> call, Throwable t) {
                System.out.println(t);
            }
        });




    }*/
}
