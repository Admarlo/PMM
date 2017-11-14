package com.example.adrlop.dibujitos2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.widget.Toast;

/**
 * Created by adrlop on 3/11/17.
 */

public class VistaDibujo extends View {
    private ShapeDrawable miDrawable;

    public VistaDibujo(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas lienzo){
            Paint pincel =new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(5);
            pincel.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(500,500,300,pincel);

            for(int i=0;i<90;i++)
                lienzo.drawCircle(500,500,300+i*3,pincel);

            //texto
            pincel.setTextSize(60);
            lienzo.drawText("Mi círculo",500,900,pincel);
            String mensaje="Ancho: "+getWidth()+" Alto:"+getHeight();
            lienzo.drawText(mensaje,500,1000,pincel);
            //Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();

            //Formas de dibujos
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

