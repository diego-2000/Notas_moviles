package com.example.editronotaspreferenciasarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Configuracion extends AppCompatActivity {

    private Spinner spinner;
    private EstiloConfiguracion estiloConfiguracion;
    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        spinner =(Spinner) findViewById(R.id.spinner_tam_letra_id);
        ArrayList<String> tamLetra= new ArrayList<>();
        estiloConfiguracion=new EstiloConfiguracion();

        tamLetra.add("1");
        tamLetra.add("2");
        tamLetra.add("3");
        tamLetra.add("4");

        ArrayAdapter arrAdap= new ArrayAdapter(Configuracion.this,android.R.layout.simple_spinner_item,tamLetra);
        spinner.setAdapter(arrAdap);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elemento=(String) spinner.getAdapter().getItem(i);
                estiloConfiguracion.setTamLetra(elemento);
                Toast.makeText(Configuracion.this,"seleccion"+elemento,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        aceptar=(Button) findViewById(R.id.button_editar_id);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarPreferencia(estiloConfiguracion);
                //salir
            }
        });
    }

    public void editarPreferencia(EstiloConfiguracion estiloConfiguracion){

    }
}
