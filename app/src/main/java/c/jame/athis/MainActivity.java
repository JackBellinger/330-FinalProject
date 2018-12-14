package c.jame.athis;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView a;
    ImageView c;
    ImageView w;
    ImageView s;
    ImageView m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer sound2 = MediaPlayer.create(this, R.raw.cave);
        sound2.setVolume(100,100);
        sound2.setLooping(true);
        setContentView(R.layout.activity_main);
        sound2.start();

        a = (ImageView)findViewById(R.id.bat);
        c = (ImageView)findViewById(R.id.cloud);
        w = (ImageView)findViewById(R.id.worm);
        s = (ImageView)findViewById(R.id.spider);
        m = (ImageView)findViewById(R.id.moon);
        final MediaPlayer sound1 = MediaPlayer.create(this, R.raw.laugh);


        TranslateAnimation animation = new TranslateAnimation(-500.0f, 1200.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        TranslateAnimation updown = new TranslateAnimation(0.0f, 0.0f,
                300.0f, 700.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(30000);  // animation duration
        animation.setRepeatCount(1000);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        updown.setDuration(20000);  // animation duration
        updown.setRepeatCount(10000);  // animation repeat count
        updown.setRepeatMode(2);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);



        //Make the pumpkin make noise and rotate on being pressed

        final Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        final Animation move1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.sample_anim);
        final Animation move2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mixed_anim);
        final Animation blink = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink_anim);
        Animation bounce = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);

        c.startAnimation(animation);  // start animation

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.startAnimation(move2);
            }
        });


        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.clearAnimation();
            }
        });



        final Button button;
        button = (Button)findViewById(R.id.pumpkin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate.setRepeatCount(0);
                button.startAnimation(rotate);
                sound1.start();
            }
        });


        bounce.setDuration(5000);
        move1.setDuration(5000);

        s.startAnimation(bounce);
        w.startAnimation(updown);
        a.startAnimation(move1);
    }
}
