package com.example.tsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Side;

import static su.levenetc.android.textsurface.animations.Just.show;

public class MainActivity extends AppCompatActivity {

    TextSurface textSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSurface = findViewById(R.id.text);
//        TextSurHelper.play(textSurface, getAssets());


        textSurface.postDelayed(new Runnable() {
            @Override public void run() {
                showTS();
            }
        }, 1000);


    }

    private void showTS() {
        textSurface.reset();
            TextSurH.play(textSurface, getAssets());

    }
}