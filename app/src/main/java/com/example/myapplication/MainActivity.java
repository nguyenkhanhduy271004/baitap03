package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import java.util.Random;
import android.widget.ProgressBar;
import android.os.CountDownTimer;
import android.widget.Toast;
import android.widget.SeekBar;
import android.util.Log;



public class MainActivity extends AppCompatActivity {
    private final int[] backgrounds = {R.drawable.png1, R.drawable.png2, R.drawable.png3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ImageView img1 = findViewById(R.id.imageView1);
        ImageButton imageButton = findViewById(R.id.imageButton1);
        ConstraintLayout constraintLayout = findViewById(R.id.editText1);
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        Random random = new Random();
        int randomIndex = random.nextInt(backgrounds.length);
        constraintLayout.setBackgroundResource(backgrounds[randomIndex]);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomIndex = random.nextInt(backgrounds.length);
                constraintLayout.setBackgroundResource(backgrounds[randomIndex]);
                int current = progressBar.getProgress();
                if (current >= progressBar.getMax()) {
                    current = 0;
                }
                progressBar.setProgress(current + 10);
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10);
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(), "Hết giờ", Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();

            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("AAA","Giá trị:" + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Start");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Stop");
            }});
    }
}
