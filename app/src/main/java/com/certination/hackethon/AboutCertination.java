package com.certination.hackethon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AboutCertination extends AppCompatActivity {

    Animation anim,anim1,anim2,anim3,anim4,anim5,anim6,anim7,anim8,anim9,anim10,anim11;

    ImageView ig2,ig3,ig4,ig5,ig6,ig7,ig8,ig9,ig10,ig11,ig12;

    ImageView img,im2,im3,im4,im5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_certination);

        img = (ImageView)findViewById(R.id.img1);
        im2 = (ImageView)findViewById(R.id.img2);
        im3 = (ImageView)findViewById(R.id.img3);
        im4 = (ImageView)findViewById(R.id.img4);
        im5 = (ImageView)findViewById(R.id.img5);
        ig2=(ImageView)findViewById(R.id.ig2);
        ig3=(ImageView)findViewById(R.id.ig3);
        ig4=(ImageView)findViewById(R.id.ig4);
        ig5=(ImageView)findViewById(R.id.ig5);
        ig6=(ImageView)findViewById(R.id.ig6);
        ig7=(ImageView)findViewById(R.id.ig7);
        ig8=(ImageView)findViewById(R.id.ig8);
        ig9=(ImageView)findViewById(R.id.ig9);
        ig10=(ImageView)findViewById(R.id.ig10);
        ig11=(ImageView)findViewById(R.id.ig11);
        ig12=(ImageView)findViewById(R.id.ig12);


        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move1);
        anim2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move2);
        anim3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move3);
        anim4= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move4);
        anim5= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move5);
        anim6= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move6);
        anim7= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move7);
        anim8= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move8);
        anim9= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move9);
        anim10= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move10);
        anim11= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move11);






        ig2.startAnimation(anim);
        ig3.startAnimation(anim1);

        ig4.startAnimation(anim2);
        ig5.startAnimation(anim3);
        ig6.startAnimation(anim4);
        ig7.startAnimation(anim5);
        ig8.startAnimation(anim6);
        ig9.startAnimation(anim7);
        ig10.startAnimation(anim8);
        ig11.startAnimation(anim9);
        ig12.startAnimation(anim10);

        RotateAnimation rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(4000);

        rotate.setRepeatCount(Animation.INFINITE);


        img.setAnimation(rotate);
        im2.setAnimation(rotate);
        im3.setAnimation(rotate);
        im4.setAnimation(rotate);
        im5.setAnimation(rotate);



    }

}

