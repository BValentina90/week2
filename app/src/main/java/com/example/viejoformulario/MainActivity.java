package com.example.viejoformulario;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private int year, month, day;
    private String date;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.tvFecha);

        final EditText nombre = (EditText) findViewById(R.id.etNombre);
        final EditText telefono = (EditText) findViewById(R.id.etTelefono);
        final EditText email = (EditText) findViewById(R.id.etMail);
        final EditText descripcion = (EditText) findViewById(R.id.etDescripcion);
        final Button siguiente = (Button) findViewById(R.id.btnSiguiente);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        siguiente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra("nombre", Objects.requireNonNull(nombre.getText()).toString());
                i.putExtra("telefono", Objects.requireNonNull(telefono.getText()).toString());
                i.putExtra("email", Objects.requireNonNull(email.getText()).toString());
                i.putExtra("descripcion", Objects.requireNonNull(descripcion.getText()).toString());
                i.putExtra("fecha", date);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}