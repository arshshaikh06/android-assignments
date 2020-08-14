package com.arshshaikh.activityno3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImage;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == 0) {
                    ivImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background, getApplicationContext().getTheme()));
                }else{
                    ivImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground, getApplicationContext().getTheme()));
                }
            }
        });
    }

    private void init() {
        ivImage = findViewById(R.id.ivimage);
        radioGroup = findViewById(R.id.radioGroup);
    }
}