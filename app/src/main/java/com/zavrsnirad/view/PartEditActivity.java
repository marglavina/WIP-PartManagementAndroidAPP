package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zavrsnirad.R;

public class PartEditActivity extends AppCompatActivity {
    String[] parts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_add_edit_delete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            parts = (String[]) bundle.get("parts");
        }

        AutoCompleteTextView actv = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_menu, parts);
        actv.setAdapter(arrayAdapter);
    }
}
