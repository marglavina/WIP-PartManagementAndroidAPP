package com.zavrsnirad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.Network;
import com.zavrsnirad.R;
import com.zavrsnirad.adapters.ModelAdapter;
import com.zavrsnirad.adapters.PartAdapter;
import com.zavrsnirad.model.CarModel;
import com.zavrsnirad.model.Part;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.RED;

public class PartActivity extends AppCompatActivity {

    String modelName;
    StringBuilder sb = new StringBuilder();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skladiste);



        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            modelName = bundle.get("modelName").toString();
        }

        Call<List<Part>> call = Network.getInstance().partRepository().partList(modelName);

        call.enqueue(new Callback<List<Part>>() {
            @Override
            public void onResponse(Call<List<Part>> call, Response<List<Part>> response) {
                List<Part> partList = new ArrayList<Part>(response.body());
                int items = partList.size();
                partList.forEach(t-> sb.append(t.getPart_name()+"/No. "+t.getPartNumber()+","));
                switch (items){
                    case 0:{
                        setContentView(R.layout.activity_noitem);
                        startActivity(new Intent(PartActivity.this, NoItemsActivity.class).putExtra("modelName", modelName));
                        finish();
                        break;
                    }
                    default:{
                        setContentView(R.layout.activity_skladiste);
                        Button addBtn = findViewById(R.id.button);
                        addBtn.setText("Add part");

                        addBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent addPart;
                                addPart = new Intent(PartActivity.this, PartEditActivity.class);
                                addPart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                String[] parts = sb.toString().split(",");
                                addPart.putExtra("parts", parts);
                                v.getContext().getApplicationContext().startActivity(addPart);
                            }
                        });
                        RecyclerView recyclerView = findViewById(R.id.oneCardRV);
                        recyclerView.setLayoutManager(new LinearLayoutManager(PartActivity.this));
                        recyclerView.setAdapter(new PartAdapter(getApplicationContext(), partList, modelName));
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Part>> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });

    }

}
