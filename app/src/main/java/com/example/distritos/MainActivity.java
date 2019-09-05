package com.example.distritos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt_dni;
    private Spinner spn_provincias;
    private Spinner spn_distritos;
    private Button btn_enviar;
    private String resultadoProvincia;
    private String resultaDistrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_dni = findViewById(R.id.txt_dni);
        spn_provincias = findViewById(R.id.spn_provincia);
        spn_distritos = findViewById(R.id.spn_distrito);
        btn_enviar = findViewById(R.id.btn_enviar);

        final String[] provincias = getResources().getStringArray(R.array.provincias);
        ArrayAdapter<String> adapterProvincias = new ArrayAdapter<String>(this,R.layout.datos, provincias);

        spn_provincias.setAdapter(adapterProvincias);

        spn_provincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){

                    String[] distritosArequipa = getResources().getStringArray(R.array.distritosArequipa);
                    ArrayAdapter<String> adapterDistrito1 = new ArrayAdapter<String>(MainActivity.this,R.layout.datos, distritosArequipa);

                    spn_distritos.setAdapter(adapterDistrito1);
                    resultadoProvincia = provincias[i];

                }else if (i == 1){

                    String[] distritosCamana = getResources().getStringArray(R.array.distritosCamana);
                    ArrayAdapter<String> adapterDistrito2 = new ArrayAdapter<String>(MainActivity.this,R.layout.datos, distritosCamana);

                    spn_distritos.setAdapter(adapterDistrito2);
                    resultadoProvincia = provincias[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PantallaResultados.class);
                intent.putExtra("dni",txt_dni.getText().toString());
                intent.putExtra("provincia",resultadoProvincia);
                startActivity(intent);


            }
        });
    }
}
