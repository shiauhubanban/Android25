package com.org.iii.shine25;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView apple;
    private ObjectAnimator anim1, anim2, anim3, anim4, anim5;
    private View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.activity_main);
        apple = (ImageView)findViewById(R.id.apple);
    }

    public void test1(View v){
        anim1 = ObjectAnimator.ofFloat(apple,"x", 0,800);
        anim1.setDuration(2000);
        anim1.setRepeatCount(0);
        anim1.start();
    }
    public void test2(View v){
        anim1 = ObjectAnimator.ofFloat(apple,"y", 0,800);
        anim1.setDuration(2000);
        anim1.setRepeatCount(0);
        anim1.start();
    }

    public void test3(View v){
        anim1 = ObjectAnimator.ofFloat(apple,"x", 0,800);
        anim2 = ObjectAnimator.ofFloat(apple,"y", 0,800);
        anim3 = ObjectAnimator.ofFloat(apple,"alpha", 0f,1f);
        anim4 = ObjectAnimator.ofFloat(apple,"rotationX", 0f,360f,0f,360f);
        anim5 = ObjectAnimator.ofFloat(apple,"rotationY", 0f,360f,0f,360f);

        AnimatorSet set = new AnimatorSet();
        set.playSequentially(anim1,anim2,anim3,anim4,anim5);
        //set.playTogether(anim1,anim2,anim3,anim4,anim5);
        set.setDuration(3*1000);
        set.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("brad", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("brad", "onResume()");
        Log.v("brad", "＞" +container.getWidth() + " x " + container.getHeight());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.v("brad", "onWindowFocusChanged()");
        if (hasFocus) {
            Log.v("brad", container.getWidth() + " x " + container.getHeight());
        }else{
            Log.v("brad", "onWindowFocusChanged():false");
        }
    }
}