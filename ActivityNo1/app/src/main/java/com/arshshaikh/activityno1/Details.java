package com.arshshaikh.activityno1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Details extends AppCompatActivity {

    private TextView tvName, tvEmail, tvSap;
    private DataUtil dataUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        tvName.setText(dataUtil.detailsMap.get(name).get("name"));
        tvEmail.setText(dataUtil.detailsMap.get(name).get("email"));
        tvSap.setText(dataUtil.detailsMap.get(name).get("sap"));
    }

    private void init(){
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvSap = findViewById(R.id.tvSapId);
        dataUtil = new DataUtil();
    }
}