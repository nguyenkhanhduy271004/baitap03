package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // will hide the title
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide(); // hide the title bar
        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // enable full screen
        setContentView(R.layout.activity_main4);
        RadioGroup radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup1);
        final ImageView bgImageView = findViewById(R.id.bg); // Assuming bg is the ID of the ImageView in your layout
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,
                                                                                       int checkedId) {
//checkID trả về ID radio
                if (checkedId == R.id.radioButton) {
                    bgImageView.setImageResource(R.drawable.png2);
                } else if (checkedId == R.id.radioButton2) {
                    bgImageView.setImageResource(R.drawable.png3);
                }


            }

        });
    }
}
