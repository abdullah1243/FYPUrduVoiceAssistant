package com.code.fypurduvoiceassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DELAY=2500;
    private ImageView imageView;
    ImageView people;
    ImageView limage;
    TextView lname;
    ImageView compname;
    FirebaseAuth mAuth;
    Animation top,bottom,mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setBackgroundDrawable(null);
        initializeview();

        //animatelogo();
        gotoMainActivity();


    }






    private void animatelogo(){

        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(30000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        ImageView image= (ImageView) findViewById(R.id.logo);
        image.startAnimation(rotate);


    }

    private void gotoMainActivity(){
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent newi=new Intent(SplashScreen.this,LoginPage.class);
                    startActivity(newi);
                    finish();
                }
            },SPLASH_DELAY);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(SplashScreen.this,MainScreenMessage.class);
                    startActivity(intent);
                    finish();
                }
            },SPLASH_DELAY);

        }


    }

    private void initializeview(){
        imageView=findViewById(R.id.logo);

    }



}