package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity1 extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        img=(ImageView)findViewById(R.id.imgfront);
        Animation an= AnimationUtils.loadAnimation(MainActivity1.this,R.anim.front_page);
        img.startAnimation(an);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent in=new Intent(MainActivity1.this,Login.class);
                startActivity(in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
