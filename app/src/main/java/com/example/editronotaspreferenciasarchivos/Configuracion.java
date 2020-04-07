package com.example.editronotaspreferenciasarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Configuracion extends AppCompatActivity {

    private Spinner spinnerTamLetra;
    private Spinner spinnerColorLetra;
    private Spinner spinnerColorFondo;

    private EstiloConfiguracion estiloConfiguracion;
    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        estiloConfiguracion=new EstiloConfiguracion();

        spinnerTamLetra =(Spinner) findViewById(R.id.spinner_tam_letra_id);
        spinnerColorLetra=(Spinner) findViewById(R.id.spinner_color_letra_id);
        spinnerColorFondo=(Spinner) findViewById(R.id.spinner_color_fondo_id);

        ArrayList<String> tamLetra= new ArrayList<>();
        tamLetra.add("10");
        tamLetra.add("20");
        tamLetra.add("30");
        tamLetra.add("40");
        tamLetra.add("50");
        tamLetra.add("60");


        final ArrayList<Color> arrColor= new ArrayList<>();
        arrColor.add(new Color("BLACK","#000000"));
        arrColor.add(new Color("WHITE","#FFFFFF"));
        arrColor.add(new Color("SILVER","#C0C0C0"));
        arrColor.add(new Color("GRAY","#808080"));
        arrColor.add(new Color("RED","#FF0000"));
        arrColor.add(new Color("MAROON","#800000"));
        arrColor.add(new Color("YELLOW","#FFFF00"));
        arrColor.add(new Color("OLIVE","#808000"));
        arrColor.add(new Color("LIME","#00FF00"));
        arrColor.add(new Color("GREEN","#008000"));
        arrColor.add(new Color("AQUA","#00FFFF"));
        arrColor.add(new Color("TEAL","#008080"));
        arrColor.add(new Color("BLUE","#0000FF"));
        arrColor.add(new Color("NAVY","#000080"));
        arrColor.add(new Color("FUCHSIA","#FF00FF"));
        arrColor.add(new Color("PURPLE","#800080"));

        ArrayList<String> arrNomColorSpinner= new ArrayList<>();
        for(Color c:arrColor){
            arrNomColorSpinner.add(c.getNombre());
        }


        ArrayAdapter arrAdapTamLetra= new ArrayAdapter(Configuracion.this,android.R.layout.simple_spinner_item,tamLetra);
        ArrayAdapter arrAdapColorLetra= new ArrayAdapter(Configuracion.this,android.R.layout.simple_spinner_item,arrNomColorSpinner);
        ArrayAdapter arrAdapColorFondo= new ArrayAdapter(Configuracion.this,android.R.layout.simple_spinner_item,arrNomColorSpinner);
        spinnerTamLetra.setAdapter(arrAdapTamLetra);
        spinnerColorLetra.setAdapter(arrAdapColorLetra);
        spinnerColorFondo.setAdapter(arrAdapColorFondo);

        Bundle extras=getIntent().getExtras();
        EstiloConfiguracion intEstiConf=extras.getParcelable("intentoEstiloConfiguracion");
        spinnerTamLetra.setSelection(arrAdapTamLetra.getPosition(intEstiConf.getTamLetra()));

/*

        String colorInte=intEstiConf.getColorLetra();
        String a="";
        for(int i=0;i<arrColor.size();i++){
            a= arrColor.get(i).getHex();
            if(colorInte.equals(a)){
                spinnerColorLetra.setSelection(arrAdapColorLetra.getPosition(i));
            }

        }


        */
        //Toast.makeText(Configuracion.this,"seleccion"+a,Toast.LENGTH_SHORT).show();

        spinnerTamLetra.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elementamLetra=(String) spinnerTamLetra.getAdapter().getItem(i);
                estiloConfiguracion.setTamLetra(elementamLetra);
              //  Toast.makeText(Configuracion.this,"seleccion"+elementamLetra,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerColorLetra.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elemenColLetra=arrColor.get(i).getHex();
                estiloConfiguracion.setColorLetra(elemenColLetra);
             //   Toast.makeText(Configuracion.this,"seleccion"+arrColor.get(i).getHex(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerColorFondo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String e=arrColor.get(i).getHex();
                estiloConfiguracion.setColorFondo(e);
                //   Toast.makeText(Configuracion.this,"seleccion"+arrColor.get(i).getHex(),Toast.LENGTH_SHORT).show();
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
                finish();
            }
        });
    }

    public void editarPreferencia(EstiloConfiguracion estiloConfi){
        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("tamanioLetra", ""+estiloConfi.getTamLetra());
        editor.putString("colorLetra", ""+estiloConfi.getColorLetra());
        editor.putString("colorFondo", ""+estiloConfi.getColorFondo());

        editor.commit();
        finish();
    }

}
