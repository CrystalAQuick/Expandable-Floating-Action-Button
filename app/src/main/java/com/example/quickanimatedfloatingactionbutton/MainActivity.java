package com.example.quickanimatedfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAddItem, fabAddBarcode, fabAddFile;
    Boolean fabButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // https://www.flaticon.com/authors/kiranshastry
       // https://www.flaticon.com/authors/freepik
        // https://www.flaticon.com/authors/iconixar

        fabAddItem = findViewById(R.id.fabAddItem);
        fabAddBarcode = findViewById(R.id.fabAddItemBarcode);
        fabAddFile = findViewById(R.id.fabAddItemFile);

        fabAddItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fabButtonClicked();
                if(fabButtonClicked){
                    fabButtonClicked = false;
                } else {
                    fabButtonClicked = true;
                }
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
    }

    private void fabButtonClicked(){

        if(fabButtonClicked == true){
            fabAddFile.setVisibility(View.VISIBLE);
            fabAddBarcode.setVisibility(View.VISIBLE);
        } else {
            fabAddFile.setVisibility(View.INVISIBLE);
            fabAddBarcode.setVisibility(View.INVISIBLE);
        }
    }

}