package com.arshshaikh.activityno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnGreetMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnGreetMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), GreetMe.class);
                intent.putExtra("name", etName.getText() != null ? etName.getText(): " ");
                startActivity(intent);

            }
        });
    }

    private void init(){
        etName = findViewById(R.id.etName);
        btnGreetMe = findViewById(R.id.btnGreetMe);
    }

}