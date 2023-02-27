package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zavrsnirad.R;

public class ModelEditActivity extends AppCompatActivity {
    String[] models;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_add_edit_delete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            models = (String[]) bundle.get("models");
        }

        AutoCompleteTextView actv = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_menu, models);
        actv.setAdapter(arrayAdapter);
        actv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}
