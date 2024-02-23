package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
    private final int[] backgrounds = {R.drawable.png1, R.drawable.png2, R.drawable.png3};
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        constraintLayout = findViewById(R.id.editText1);

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Random random = new Random();
                    int randomIndex = random.nextInt(backgrounds.length);
                    constraintLayout.setBackgroundResource(backgrounds[randomIndex]);
                    Toast.makeText(MainActivity2.this, "Wifi đang bật", Toast.LENGTH_LONG).show();
                } else {
                    Random random = new Random();
                    int randomIndex = random.nextInt(backgrounds.length);
                    constraintLayout.setBackgroundResource(backgrounds[randomIndex]);
                    Toast.makeText(MainActivity2.this, "Wifi đang tắt", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

