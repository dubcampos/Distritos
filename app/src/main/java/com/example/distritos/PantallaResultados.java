package com.example.distritos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PantallaResultados extends AppCompatActivity {

    TextView dni;
    TextView provincia;
    TextView distrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        dni=findViewById(R.id.dni);
        provincia=findViewById(R.id.provincia);
        distrito=findViewById(R.id.distrito);


        String dni1 = getIntent().getStringExtra("dni");
        String provincia1 = getIntent().getStringExtra("provincia");
        String distrito1 = getIntent().getStringExtra("distrito");
        dni.setText(dni1);
        provincia.setText(provincia1);
        distrito.setText(distrito1);

    }
}
