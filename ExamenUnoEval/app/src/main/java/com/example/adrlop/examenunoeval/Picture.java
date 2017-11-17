package com.example.adrlop.examenunoeval;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
    }

    public class Dibujo extends View {

        public Dibujo(Context contexto) {
            super(contexto);
        }

        @Override
        protected void onDraw(Canvas lienzo) {

            Paint pincel =new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(5);
            pincel.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(500,500,300,pincel);
            lienzo.drawCircle(200,200,50,pincel);

            ShapeDrawable miDrawable;
            int x=250;
            int y=300;
            int alto=300;
            int ancho=500;
            miDrawable=new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,x+ancho,y+alto);

            miDrawable.draw(lienzo);

        }
    }
}
