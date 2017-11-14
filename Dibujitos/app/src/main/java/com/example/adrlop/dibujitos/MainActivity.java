package com.example.adrlop.dibujitos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    public class MiDibujo extends View{

     public MiDibujo(Context contexto){
        super(contexto);
    }

    protected void onDraw(Canvas lienzo){
        Paint pincel =new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(5);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(500,500,300,pincel);

        //texto
        pincel.setTextSize(60);
        lienzo.drawText("Mi círculo",500,900,pincel);
        String mensaje="Ancho: "+getWidth()+" Alto:"+getHeight();
        lienzo.drawText(mensaje,500,1000,pincel);
        Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();

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


        //Tomar un recurso(poner una imagen
        BitmapDrawable imagen;

        Resources res=this.getResources();
        imagen=(BitmapDrawable)res.getDrawable(R.drawable.marcianito);
        imagen.setBounds(new Rect(100,800,500,1200));
        imagen.draw(lienzo);



    }
}
}
