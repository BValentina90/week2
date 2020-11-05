package com.example.viejoformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        TextView tvNombre = (TextView) findViewById(R.id.nombreConf);
        TextView tvFecha = (TextView) findViewById(R.id.fechaConf);
        TextView tvTelefono = (TextView) findViewById(R.id.telefonoConf);
        TextView tvEmail = (TextView) findViewById(R.id.emailConf);
        TextView tvDescripcion = (TextView) findViewById(R.id.descripcionConf);

        Bundle parametros = getIntent().getExtras();
        assert parametros != null;

        String nombre      = "Nombre: " + parametros.getString("nombre");
        String fecha       = "Fecha de nacimiento: " + parametros.getString("fecha");
        String telefono    = "Teléfono: " + parametros.getString("telefono");
        String email       = "Email: " + parametros.getString("email");
        String descripcion = "Descripción: " + parametros.getString("descripcion");

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}