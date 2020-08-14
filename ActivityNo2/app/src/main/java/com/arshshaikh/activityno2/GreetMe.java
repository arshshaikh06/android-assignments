package com.arshshaikh.activityno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetMe extends AppCompatActivity {

    private TextView tvGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_me);

        init();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        tvGreeting.setText("Hello, " + name);

    }

    private void init(){
        tvGreeting = findViewById(R.id.tvGreeting);
    }
}