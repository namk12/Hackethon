package com.certination.hackethon;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutHackathon extends AppCompatActivity {
    ImageView imgview;
    TextView txtview;
    Animation anim,anim1,anim2,anim4,anim5,anim6,anim7,anim8,anim9;
    ImageView ig1,ig2,ig3,ig4,ig5,ig6,ig7,ig8,ig9,ig10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_hackathon);


        ig1=(ImageView)findViewById(R.id.ig1);
        ig2=(ImageView)findViewById(R.id.ig2);
        ig3=(ImageView)findViewById(R.id.ig3);
        ig4=(ImageView)findViewById(R.id.ig4);
        ig5=(ImageView)findViewById(R.id.ig5);
        ig6=(ImageView)findViewById(R.id.ig6);
        ig7=(ImageView)findViewById(R.id.ig7);
        ig8=(ImageView)findViewById(R.id.ig8);
        ig9=(ImageView)findViewById(R.id.ig9);
        ig10=(ImageView)findViewById(R.id.ig10);

        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov);
        anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov1);
        anim2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov2);

        anim4= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov4);
        anim5= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov5);
        anim6= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov6);
        anim7= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov7);
        anim8= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov8);
        anim9= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mov9);

        ig2.startAnimation(anim);
        ig3.startAnimation(anim1);
        ig4.startAnimation(anim2);
        ig5.startAnimation(anim4);
        ig6.startAnimation(anim5);
        ig7.startAnimation(anim6);
        ig8.startAnimation(anim7);
        ig9.startAnimation(anim8);
        ig10.startAnimation(anim9);
        imgview = (ImageView) findViewById(R.id.imageView);
        ImageView imgview1 = (ImageView) findViewById(R.id.imageView2);
        ImageView imgview2 = (ImageView) findViewById(R.id.imageView3);

        imgview.setTranslationX(-1000f);
        imgview1.setTranslationY(-1000f);
        imgview2.setTranslationX(1000f);

        imgview.animate().translationXBy(1000f).setDuration(3000);
        imgview1.animate().translationYBy(1000f).setDuration(3000);
        imgview2.animate().translationXBy(-1000f).setDuration(3000);

        txtview = (TextView) findViewById(R.id.textView3);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview.setAlpha(0);
                txtview.setText("31 AUGUST");
//                txtview.anim = AnimationUtils.loadAnimation(getApplicationContext(),
//                        R.anim.fade_in);
                txtview.setTextColor(Color.BLACK);
                txtview.setTypeface(null, Typeface.BOLD);
                txtview.setTextSize(25);
                txtview.animate().alpha(1f).setDuration(2000);
            }
        });

        imgview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview.setAlpha(0);
                txtview.setText("9 AM - 7 PM");
//                anim = AnimationUtils.loadAnimation(getApplicationContext(),
//                        R.anim.fade_in);
                txtview.setTextColor(Color.BLACK);
                txtview.setTypeface(null, Typeface.BOLD);
                txtview.setTextSize(25);
                txtview.animate().alpha(1f).setDuration(2000);
            }
        });

        imgview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtview.setAlpha(0);
                txtview.setText("NEW DELHI");
//                anim = AnimationUtils.loadAnimation(getApplicationContext(),
//                        R.anim.fade_in);
                txtview.setTextColor(Color.BLACK);
                txtview.setTypeface(null, Typeface.BOLD);
                txtview.setTextSize(25);
                txtview.animate().alpha(1f).setDuration(2000);
            }
        });

    }
}

