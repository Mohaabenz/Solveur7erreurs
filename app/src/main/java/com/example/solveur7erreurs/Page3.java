package com.example.solveur7erreurs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;

import static android.graphics.Bitmap.createBitmap;


public class Page3 extends AppCompatActivity{


    Bitmap image1 = createBitmap(Page2.transBitmap(1));
    Bitmap image2 = createBitmap(Page2.transBitmap(2));
    TextView textView3;
    ImageView result1;
    ImageView result2;
    ImageView result3;

    Bitmap tuc;
    Thread t1;
    Thread t2;
    Button button;
    double pourcentage;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        textView3 = findViewById(R.id.textView3);
        result1 = findViewById(R.id.imageView3);
        result2 = findViewById(R.id.imageView4);
        result3 = findViewById(R.id.imageView5);

        button = findViewById(R.id.angry_btn3);
        pourcentage = ConvolutionMatrix.pourcentErreur(image1,image2);
        /*if(pourcentage==0)
            textView3.setText(image1.toString() + "\n" + image2.toString());

        t1 = new Thread(new Runnable() {
            public void run(){
                image1 = Bitmap.createScaledBitmap(image1, (int) (image1.getWidth()*0.5), (int) (image1.getHeight()*0.5) , true);
                //image1 = RotateBitmap(image1,90);
                image1 = Compress(image1, 25);
                image1 = ConvolutionMatrix.gaussianBlur5x5(image1);
            }
        });

        t2 = new Thread(new Runnable() {
            public void run(){
                image2 = Bitmap.createScaledBitmap(image2, (int) (image2.getWidth()*0.5), (int) (image2.getHeight()*0.5) , true);
                //image2 = RotateBitmap(image2,90);
                image2 = Compress(image2, 25);
                image2 = ConvolutionMatrix.gaussianBlur5x5(image2);
            }
        });

        t1.start();
        t2.start();

        for (Thread t : new Thread[] { t1, t2}) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //image2 = rotateBitmap(image2,180);
        image1 = Calibrage.zone(image1);
        tuc = ConvolutionMatrix.findDifference(image1,image2);

        result1.setImageBitmap(image1);
        result2.setImageBitmap(image2);
        result3.setImageBitmap(tuc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page2 = new Intent(getApplicationContext(), Page2.class);
                startActivity(page2);
                finish();
            }
        });
    }


    //Bitmap source = BitmapFactory.decodeResource(this.getResources(), R.drawable.image2);



}
