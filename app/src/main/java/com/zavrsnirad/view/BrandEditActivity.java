package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zavrsnirad.Network;
import com.zavrsnirad.R;
import com.zavrsnirad.model.CarBrand;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandEditActivity extends AppCompatActivity {

    String[] brands;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_add_edit_delete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        if(bundle != null){
            brands = (String[]) bundle.get("brands");
        }

        AutoCompleteTextView actv = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_menu, brands);
        actv.setAdapter(arrayAdapter);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditText editText = findViewById(R.id.brandName);
                editText.setText(actv.getText());
            }});

        Button addBtn = findViewById(R.id.buttonAddBrand);
        Button updateBtn = findViewById(R.id.buttonUpdateBrand);
        Button deleteBtn = findViewById(R.id.buttonDeleteBrand);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button addBtn = findViewById(R.id.buttonAddBrand);
                CarBrand cb = new CarBrand();
                EditText editText = findViewById(R.id.brandName);
                if(!editText.getText().toString().equals("")) {
                    cb.setBrandName(editText.getText().toString());
                    Call<CarBrand> call = Network.getInstance().carBrandRepository().carBrandAdd(cb);
                    call.enqueue(new Callback<CarBrand>() {
                        @Override
                        public void onResponse(Call<CarBrand> call, Response<CarBrand> response) {
                            startActivity(new Intent(BrandEditActivity.this, SkladisteActivity.class));
                        }

                        @Override
                        public void onFailure(Call<CarBrand> call, Throwable t) {
                            CharSequence charSequence = "Something went wrong!";
                            Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }else {
                    CharSequence charSequence = "Brand name can't be empty!";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button addBtn = findViewById(R.id.buttonUpdateBrand);
                CarBrand cb = new CarBrand();
                EditText editText = findViewById(R.id.brandName);
                if(!editText.getText().toString().equals("")&& !actv.getText().toString().equals("")) {
                    cb.setBrandName(editText.getText().toString());
                    Call<CarBrand> call = Network.getInstance().carBrandRepository().carBrandUpdate(actv.getText().toString().replace(" ", "%20"),cb);
                    call.enqueue(new Callback<CarBrand>() {
                        @Override
                        public void onResponse(Call<CarBrand> call, Response<CarBrand> response) {
                            startActivity(new Intent(BrandEditActivity.this, SkladisteActivity.class));
                        }

                        @Override
                        public void onFailure(Call<CarBrand> call, Throwable t) {
                            CharSequence charSequence = "Something went wrong!";
                            Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
                if(editText.getText().toString().equals("")){
                    CharSequence charSequence = "Brand name can't be empty!";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
                if(actv.getText().toString().equals("")){
                    CharSequence charSequence = "You must select brand witch you want to update!";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button addBtn = findViewById(R.id.buttonUpdateBrand);
                EditText editText = findViewById(R.id.brandName);
                if(!actv.getText().toString().equals("")) {

                    Call<Void> call = Network.getInstance().carBrandRepository().carBrandDelete(actv.getText().toString().replace(" ", "%20"));
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            startActivity(new Intent(BrandEditActivity.this, SkladisteActivity.class));
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            CharSequence charSequence = "Something went wrong!";
                            Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
                if(actv.getText().toString().equals("")){
                    CharSequence charSequence = "You must select brand witch you want to delete!";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
