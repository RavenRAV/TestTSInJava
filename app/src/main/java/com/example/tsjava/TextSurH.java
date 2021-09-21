package com.example.tsjava;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;

import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.AnimationsSet;
import su.levenetc.android.textsurface.animations.ChangeColor;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Parallel;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;
import su.levenetc.android.textsurface.contants.TYPE;

public class TextSurH {
    public static void play(TextSurface textSurface, AssetManager assetManager) {
        Text textHello = TextBuilder
                .create("Hello")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.SURFACE_CENTER).build();

        Text textHey = TextBuilder
                .create("Hey! ")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textHello).build();

        Text text1 = TextBuilder
                .create("This is test project.")
                .setSize(40)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.RIGHT_OF, textHey).build();

        Text textHi = TextBuilder
                .create("Hi!")
                .setSize(74)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, text1).build();

        Text textHelloWorld = TextBuilder
                .create("Hello World! ")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textHi).build();

        Text textRandomText = TextBuilder
                .create("Random text")
                .setSize(50)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.BOTTOM_OF, textHelloWorld).build();

        Text textNewRandomText = TextBuilder
                .create("New Random text")
                .setSize(30)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.BOTTOM_OF, textRandomText).build();

//        textSurface.play(
//                new Sequential(
//                        Slide.showFrom(Side.TOP, textHello, 500),
//                        Delay.duration(500),
//                        Alpha.hide(textHello, 1500)
//                )
//        );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            textSurface.play(
                    new Sequential(
                            ShapeReveal.create(textHello, 750, SideCut.show(Side.LEFT), false),
                            new Parallel(ShapeReveal.create(textHello, 600, SideCut.hide(Side.LEFT), false),
                                    new Sequential(Delay.duration(300), ShapeReveal.create(textHello, 600, SideCut.show(Side.LEFT),
                                            false))),
                            new Parallel(new TransSurface(500, textHey, Pivot.CENTER),
                                    ShapeReveal.create(textHey, 1300, SideCut.show(Side.LEFT), false)),
                            Delay.duration(500),
//                            new AnimationsSet(TYPE.PARALLEL,
//                                    Slide.showFrom(Side.TOP, text1, 500),
//                                    new TransSurface(1000, text1, Pivot.CENTER)),
//                            Delay.duration(500),
                            new Parallel(new TransSurface(500, text1, Pivot.CENTER),
//                                Slide.showFrom(Side.LEFT, text1, 750)),
                                    ShapeReveal.create(text1, 1300, SideCut.show(Side.LEFT), false)),
                            Delay.duration(500),
                            new Parallel(TransSurface.toCenter(textHi, 500), Rotate3D.showFromSide(textHi, 750, Pivot.TOP)),
                            Delay.duration(500),
                            new Parallel(new TransSurface(500, textHelloWorld, Pivot.CENTER),
                                    ShapeReveal.create(textHelloWorld, 1300, SideCut.show(Side.LEFT), false)),
                            Delay.duration(500),
                            new Parallel(new TransSurface(500, text1,Pivot.CENTER),
                                    ShapeReveal.create(textRandomText, 1300, SideCut.show(Side.LEFT), false)),
                            Delay.duration(500),
                            new Parallel(TransSurface.toCenter(textNewRandomText, 500),
                                    Rotate3D.showFromSide(textNewRandomText, 750, Pivot.RIGHT)),
                            Alpha.hide(textHello, 1500),
                            Alpha.hide(textHey, 1500),
                            Alpha.hide(text1, 1500),
                            Alpha.hide(textHi, 1500),
                            Alpha.hide(textHelloWorld, 1500),
                            Alpha.hide(textRandomText, 1500)
                    )
            );
        }

    }
}
