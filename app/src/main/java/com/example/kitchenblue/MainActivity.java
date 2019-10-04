package com.example.kitchenblue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    TextView smart;
    TextView kitchen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/free3.ttf");

        smart = findViewById(R.id.smartText);
        smart.setTypeface(tf);


        kitchen = findViewById(R.id.kitchenText);
        kitchen.setTypeface(tf);

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(MainActivity.this, start.class));
                finish();

            }
        }, 3000 );

    }


}
