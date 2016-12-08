package com.certination.hackethon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView myView = (ImageView) findViewById(R.id.img);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(myView, "alpha", 1f, .3f);
        fadeOut.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(myView, "alpha", .3f, 1f);
        fadeIn.setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            doshare();
        }

        if (id == R.id.like) {

//            try {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/certination"));
//                startActivity(intent);
//            } catch(Exception e) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/certination")));
//            }

            Intent facebookIntent = getOpenFacebookIntent(this);
            startActivity(facebookIntent);


        }
        return super.onOptionsItemSelected(item);
    }


    public void doshare() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Awesome Application...");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, I found this Appplication on google Play Store. Click here to visit:  hackathon.certination.com");
        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

        startActivity(Intent.createChooser(emailIntent, "Tell a friend..."));
    }


    public void individualRegistration(View view) {

        Intent intent = new Intent(MainActivity.this, IndividualRegistration.class);
        startActivity(intent);
        //  finish();

    }

    public void groupRegistration(View view) {

        Intent intent = new Intent(MainActivity.this, GroupRegistration.class);
        startActivity(intent);
        // finish();

    }

    public void aboutHackathon(View view) {
        Intent intent = new Intent(MainActivity.this, AboutHackathon.class);
        startActivity(intent);
    }

    public void aboutCertination(View view) {
        Intent intent = new Intent(MainActivity.this, AboutCertination.class);
        startActivity(intent);
    }


    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/certination")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/certination")); //catches and opens a url to the desired page
        }
    }
}
