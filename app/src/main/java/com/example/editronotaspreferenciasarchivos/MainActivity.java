package com.example.editronotaspreferenciasarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bttconfiguracion;
    private EditText edtEscritura;
    private EstiloConfiguracion estiloConfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estiloConfiguracion= new EstiloConfiguracion();
        bttconfiguracion=(Button) findViewById(R.id.button_configuracion_id);
        edtEscritura=(EditText) findViewById(R.id.editText);

        actualizarInterface();

        bttconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento= new Intent(getApplicationContext(),Configuracion.class);
                intento.putExtra("intentoEstiloConfiguracion",estiloConfiguracion);
                startActivity(intento);
            }
        });
    }

    public void actualizarInterface(){
        SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
        String resulTamanioLetras =prefe.getString("tamanioLetra","10");
        String resulColorLetras =prefe.getString("colorLetra","#000000");
        String resulColorFondo =prefe.getString("colorFondo","#FFFFFF");

        float importe = Float.parseFloat(resulTamanioLetras);
        edtEscritura.setTextSize(importe);
        edtEscritura.setTextColor(Color.parseColor(resulColorLetras));
        edtEscritura.setBackgroundColor(Color.parseColor(resulColorFondo));
        // edtEscritura.setAllCaps(true);
        estiloConfiguracion.setTamLetra(resulTamanioLetras);
        estiloConfiguracion.setColorLetra(resulColorLetras);
        estiloConfiguracion.setColorFondo(resulColorFondo);
        //android:textStyle="bold"
        Toast.makeText(MainActivity.this,"Color FOndo"+resulColorFondo,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarInterface();
    }

}
