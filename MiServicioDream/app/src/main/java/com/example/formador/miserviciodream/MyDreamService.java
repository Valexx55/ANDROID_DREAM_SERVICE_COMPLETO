package com.example.formador.miserviciodream;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.service.dreams.DreamService;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyDreamService extends DreamService implements Animation.AnimationListener{

    private Animation animacion;

    public MyDreamService() {
    }


    public void toque (View v)
    {
        Log.d("MENSAJE", "HAN TOCADO ");

        ImageView iv1 = (ImageView)findViewById(R.id.imagen1);
        ImageView iv2 = (ImageView)findViewById(R.id.imagen2);

        iv1.setImageResource(R.mipmap.ic_launcher_round);
        iv2.setImageResource(R.mipmap.ic_launcher);

        LinearLayout ll = (LinearLayout) findViewById(R.id.layout_padre);
        ll.startAnimation(animacion);
    }


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        //setting del servicio
        setInteractive(true);
        setFullscreen(true);

        setContentView(R.layout.dream);

        SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);
        String tienda = sp.getString("tienda", "bsk");

        Log.d("MENSAJE", "Tienda almacenada " + tienda);

        ImageView iv = (ImageView) findViewById(R.id.imagen1);
        ImageView iv2 = (ImageView) findViewById(R.id.imagen2);

        switch (tienda)
        {
            case "bsk": //TODO setear las fotos de la categoria
                iv.setImageResource(R.drawable.bsk1);
                iv2.setImageResource(R.drawable.bsk2);
                break;

            case "zara":
                iv.setImageResource(R.drawable.zara1);
                iv2.setImageResource(R.drawable.zara2);
                break;

            case "mango":

                iv.setImageResource(R.drawable.violeta1);
                iv2.setImageResource(R.drawable.violeta2);
                break;

        }


    }

    @Override
    public void onDreamingStarted() {

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layout_padre);
        //TODO cargar e iniciar animación
        this.animacion = AnimationUtils.loadAnimation(this, R.anim.animacion_dream);
        animacion.reset();
        linearLayout.startAnimation(animacion);

        animacion.setAnimationListener(this);
        super.onDreamingStarted();
    }


    @Override
    public void onAnimationStart(Animation animation) {
        Log.d("MENSAJE", "ANIMATION STARTED");

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        Log.d("MENSAJE", "ANIMATION ENDED");
        ImageView iv1 = (ImageView)findViewById(R.id.imagen1);
        ImageView iv2 = (ImageView)findViewById(R.id.imagen2);

        iv1.setImageResource(R.mipmap.ic_launcher);
        iv2.setImageResource(R.mipmap.ic_launcher_round);

        LinearLayout ll = (LinearLayout) findViewById(R.id.layout_padre);
        ll.startAnimation(animacion);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

        Log.d("MENSAJE", "ANIMATION repeated");
    }
}
