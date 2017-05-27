package com.example.formador.miserviciodream;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AjustesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
    }

    public void botonSel (View v)
    {
        Log.d("MENSAJE", "BOTON SELECCIONADO");

        int id_boton = v.getId();

        SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        switch (id_boton)
        {
            case R.id.radio_bsk:
                Log.d("MENSAJE", "BOTON bsk SELECCIONADO");
                editor.putString("tienda", "bsk");
                break;
            case R.id.radio_zara:
                Log.d("MENSAJE", "BOTON zara SELECCIONADO");
                editor.putString("tienda", "zara");
                break;
            case R.id.radio_mango:
                Log.d("MENSAJE", "BOTON mango SELECCIONADO");
                editor.putString("tienda", "mango");
                break;
        }
        editor.commit();
    }
}
