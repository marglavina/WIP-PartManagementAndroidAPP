package com.zavrsnirad.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zavrsnirad.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    username.setText("");
                    password.setText("");
                    startActivity(new Intent(MainActivity.this, SkladisteActivity.class));
                }else if (username.getText().toString().equals("prodaja") && password.getText().toString().equals("prodaja")) {
                    username.setText("");
                    password.setText("");
                    startActivity(new Intent(MainActivity.this, ProdajaActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "Wrong password or username.", Toast.LENGTH_SHORT);
                    username.setText("");
                    password.setText("");
                }
            }
        });

    }
}