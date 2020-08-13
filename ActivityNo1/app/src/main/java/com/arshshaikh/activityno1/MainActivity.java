package com.arshshaikh.activityno1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAdnan, btnArsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnAdnan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Details.class);
                intent.putExtra("name", "adnan");
                startActivity(intent);
            }
        });

        btnArsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Details.class);
                intent.putExtra("name", "arsh");
                startActivity(intent);
            }
        });
    }

    private void init(){
        btnAdnan = findViewById(R.id.btnAdnan);
        btnArsh = findViewById(R.id.btnArsh);
    }
}