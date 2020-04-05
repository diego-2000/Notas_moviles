package com.example.editronotaspreferenciasarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bttconfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttconfiguracion=(Button) findViewById(R.id.button_configuracion_id);

        bttconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento= new Intent(getApplicationContext(),Configuracion.class);
                intento.putExtra("VALOR","");
                startActivity(intento);
            }
        });
    }


}
