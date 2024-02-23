package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // will hide the title
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide(); // hide the title bar
        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // enable full screen
        setContentView(R.layout.activity_main3);

        final ImageView bgImageView = findViewById(R.id.bg); // Assuming bg is the ID of the ImageView in your layout

        CheckBox ck1 = findViewById(R.id.checkBox2);

        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set background when CheckBox is checked
                if(isChecked) {
                    bgImageView.setImageResource(R.drawable.png3);
                } else {
                    // Set background when CheckBox is unchecked
                    bgImageView.setImageResource(R.drawable.png2);
                }
            }
        });
    }
}
