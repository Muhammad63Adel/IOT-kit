package com.example.kitchenblue;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class kitchen extends AppCompatActivity {
    Button lamp1 ;
    Button lamp2 ;
    Button oneHinge ;
    Button twoHinge;
    Button threeHinge ;
    Button fourHinge ;
    Button tenRoller ;
    Button twelveRoller ;
    Button microphone;

    TextView smart;
    TextView kitchen;
    public int lamp1Status =0;
    public int lamp2Status =0;
    public int oneHingeStatus =0;
    public int twoHingeStatus =0;
    public int threeHingeStatus =0;
    public int fourHingeStatus =0;
    public int tenRollerStatus =0;
    public int twelveRollerStatus =0;

    ArrayList<String> result_voice ;
    String result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        microphone = findViewById(R.id.mic);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/free3.ttf");

        smart = findViewById(R.id.smartText);
        smart.setTypeface(tf);

        kitchen = findViewById(R.id.kitchenText);
        kitchen.setTypeface(tf);

        lamp1 = (Button)findViewById(R.id.leftLed);
        lamp2 = (Button)findViewById(R.id.RightLed);

        oneHinge = (Button)findViewById(R.id.one);
        twoHinge = (Button)findViewById(R.id.two);
        threeHinge = (Button)findViewById(R.id.three);
        fourHinge = (Button)findViewById(R.id.four);

        tenRoller = (Button)findViewById(R.id.rightdorg);
        twelveRoller = (Button)findViewById(R.id.leftdorg);

    }




    public void mic(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.ENGLISH);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,10);
        }else{
            Toast.makeText(this,"your device doesn't support speech input",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if(requestCode == 10) {
                    if (resultCode == RESULT_OK && data != null) {
                        result_voice = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        assert result_voice != null;
                        result_text = result_voice.get(0);
                        Toast.makeText(this, "you said " + result_text, Toast.LENGTH_SHORT).show();

                        if(result_text.equals("واحد"))
                            Lampone();
                        else if(result_text.equals("اثنين"))
                            Lamptwo();
                        else if(result_text.equals("ثلاثه"))
                            One();
                        else if(result_text.equals("اربعه"))
                            Two();
                        else if(result_text.equals("خمسه"))
                            Three();
                        else if(result_text.equals("سته"))
                            Four();
                        else if(result_text.equals("سبعه"))
                            Ten();
                        else if(result_text.equals("ثمانيه"))
                            Twelve();
                        else
                            Toast.makeText(this, "the order is wrong ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "we can't understand your order", Toast.LENGTH_SHORT).show();

                    }
                }
           }


    public void One(){
        if(oneHingeStatus == 0) {
            oneHinge.setBackgroundResource(R.drawable.oneropened);
            oneHingeStatus = 1;
        }
        else if(oneHingeStatus == 1) {
            oneHinge.setBackgroundResource(R.drawable.onerclosed);
            oneHingeStatus = 0;
        }
    }
    public void one(View view) {
       One();
    }




    public void Two(){
        if(twoHingeStatus == 0) {
            twoHinge.setBackgroundResource(R.drawable.oneropened);
            twoHingeStatus = 1;
        }
        else if(twoHingeStatus == 1) {
            twoHinge.setBackgroundResource(R.drawable.onerclosed);
            twoHingeStatus = 0;
        }
    }
    public void two(View view) {
        Two();

    }




    public void Three(){
        if(threeHingeStatus == 0) {
            threeHinge.setBackgroundResource(R.drawable.onelopened);
            threeHingeStatus = 1;
        }
        else if(threeHingeStatus == 1) {
            threeHinge.setBackgroundResource(R.drawable.onelclosed);
            threeHingeStatus = 0;
        }
    }
    public void three(View view) {
        Three();

    }






    public void Four(){
        if(fourHingeStatus == 0) {
            fourHinge.setBackgroundResource(R.drawable.onelopened);
            fourHingeStatus = 1;
        }
        else if(fourHingeStatus == 1) {
            fourHinge.setBackgroundResource(R.drawable.onelclosed);
            fourHingeStatus = 0;
        }
    }
    public void four(View view) {
        Four();

    }

    public void Ten(){
        if(tenRollerStatus == 0) {
            tenRoller.setBackgroundResource(R.drawable.rolleropened);
            tenRollerStatus = 1;
        }
        else if(tenRollerStatus == 1) {
            tenRoller.setBackgroundResource(R.drawable.rollerclosed);
            tenRollerStatus = 0;
        }
    }
    public void ten(View view) {
        Ten();


    }



    public void Twelve(){
        if(twelveRollerStatus == 0) {
            twelveRoller.setBackgroundResource(R.drawable.rolleropened);
            twelveRollerStatus = 1;
        }
        else if(twelveRollerStatus == 1) {
            twelveRoller.setBackgroundResource(R.drawable.rollerclosed);
            twelveRollerStatus = 0;
        }

    }
    public void twelve(View view) {
        Twelve();
    }




    public void Lampone(){
        if(lamp1Status == 0) {
            lamp1.setBackgroundResource(R.drawable.lampon);
            lamp1Status = 1;
        }
        else if(lamp1Status == 1) {
            lamp1.setBackgroundResource(R.drawable.lampoff);
            lamp1Status = 0;
        }
    }
    public void lampone(View view) {
        Lampone();

    }



    public void Lamptwo(){
        if(lamp2Status == 0) {
            lamp2.setBackgroundResource(R.drawable.lampon);
            lamp2Status = 1;
        }
        else if(lamp2Status == 1) {
            lamp2.setBackgroundResource(R.drawable.lampoff);
            lamp2Status = 0;
        }

    }
    public void lamptwo(View view) {
       Lamptwo();
    }
}
