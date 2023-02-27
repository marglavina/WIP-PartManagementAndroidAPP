package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

public class NoItemsActivity extends AppCompatActivity {


    String modelName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noitem);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            modelName = bundle.get("modelName").toString().replace("%20", " ");
        }
        CharSequence text = "No parts for model "+modelName;

        TextView textView = findViewById(R.id.noItem);
        textView.setText(text);

    }

}
