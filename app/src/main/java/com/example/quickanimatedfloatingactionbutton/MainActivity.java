package com.example.quickanimatedfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAddItem, fabAddBarcode, fabAddFile, fabAnimate, fabAnimateButtonBottom, fabAnimateButtonTop;
    Boolean fabButtonClicked =  false;

    Boolean fabAnimateClicked = false;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // https://www.flaticon.com/authors/kiranshastry
       // https://www.flaticon.com/authors/freepik
        // https://www.flaticon.com/authors/iconixar

        // Custom images from flatIcon
        fabAddItem = findViewById(R.id.fabAddItem);
        fabAddBarcode = findViewById(R.id.fabAddItemBarcode);
        fabAddFile = findViewById(R.id.fabAddItemFile);

        // Animated Button, " X " when Open, " + " when Close
        fabAnimate = findViewById(R.id.fabAnimate);
        fabAnimateButtonBottom = findViewById(R.id.fabAnimateButtonTop);
        fabAnimateButtonTop = findViewById(R.id.fabAnimateButtonBottom);

        fabAddItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(fabButtonClicked){
                    fabButtonClicked = false;
                } else {
                    fabButtonClicked = true;
                }
                fabButtonClicked();
            }
        });

        fabAddBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Barcode FAB was clicked", Toast.LENGTH_LONG).show();
            }
        });

        fabAddFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "File FAB was clicked", Toast.LENGTH_LONG).show();
            }
        });

        // Animates
        fabAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabAnimateClicked = rotateFab(v, !fabAnimateClicked);
                fabAnimatedButtonClicked();
            }
        });
    }

    // Actually does the rotating for the FAB
    public static boolean rotateFab(final View v, boolean rotate) {
        v.animate().setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .rotation(rotate ? 135f : 0f);
        return rotate;
    }

    private void fabButtonClicked(){
        if(fabButtonClicked){
            fabAddFile.setVisibility(View.VISIBLE);
            fabAddBarcode.setVisibility(View.VISIBLE);
        } else {
            fabAddFile.setVisibility(View.INVISIBLE);
            fabAddBarcode.setVisibility(View.INVISIBLE);
        }
    }

    private void fabAnimatedButtonClicked(){
        if(fabAnimateClicked){
            fabAnimateButtonBottom.setVisibility(View.VISIBLE);
            fabAnimateButtonTop.setVisibility(View.VISIBLE);
        } else {
            fabAnimateButtonBottom.setVisibility(View.INVISIBLE);
            fabAnimateButtonTop.setVisibility(View.INVISIBLE);
        }
    }
}