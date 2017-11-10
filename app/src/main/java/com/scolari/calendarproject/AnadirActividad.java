package com.scolari.calendarproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.scolari.calendarproject.Model.ListaActividad;

public class AnadirActividad extends AppCompatActivity implements View.OnClickListener {


    public static final String Firebase_Server_URL = "https://calendarproject-8d039.firebaseio.com/";
    Firebase firebase;
    private static final String STUDENT_NODE = "ListaActividades";
    private DatabaseReference databaseReference;

    //variables para almacenar
     private EditText materiaNewAct, tareaNewAct, descripcionNewAct;
     private String materiaS, tareaNameS, descriptionS, fechaS, horaS;


    //variables para actividad
    Button b_fecha, b_hora, CrearAct;
    EditText e_fecha, e_hora;
    private int dia, mes, anio, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_actividad);


        materiaNewAct = (EditText) findViewById(R.id.materiaNewAct);
        tareaNewAct = (EditText) findViewById(R.id.tareaNewAct);
        descripcionNewAct = (EditText) findViewById(R.id.descripcionNewAct);
        CrearAct = (Button) findViewById(R.id.CrearAct);
        CrearAct.setOnClickListener(this);



        //variables para la actividad
        b_fecha = (Button) findViewById(R.id.b_fecha);
        b_hora = (Button) findViewById(R.id.b_hora);
        e_fecha = (EditText) findViewById(R.id.e_fecha);
        e_hora = (EditText) findViewById(R.id.e_hora);
        b_fecha.setOnClickListener(this);
        b_hora.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == b_fecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    e_fecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , dia, mes, anio);
            datePickerDialog.show();
        }
        if (v == b_hora) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    e_hora.setText(hourOfDay + ":" + minute);
                }
            }, hora, minutos, false);
            timePickerDialog.show();
        }

        //fjad

        //Aqui es el clicl para almacenar los datos caputrados
       if (v==CrearAct) {
            materiaS = String.valueOf(materiaNewAct.getText());
            tareaNameS = String.valueOf(tareaNewAct.getText());
            descriptionS = String.valueOf(descripcionNewAct.getText());
            fechaS = String.valueOf(e_fecha.getText());
            horaS = String.valueOf(e_hora.getText());


            Firebase.setAndroidContext(AnadirActividad.this);
            firebase = new Firebase(Firebase_Server_URL); // Ejecuto la persistencia de firbase cuando esta sin internet
            databaseReference = FirebaseDatabase.getInstance().getReference(STUDENT_NODE); // esta liniea es para obtener el nodo principal padre


            ListaActividad listaActividad = new ListaActividad();
            listaActividad.setMateria(materiaS);
            listaActividad.setTareaName(tareaNameS);
            listaActividad.setDescription(descriptionS);
            listaActividad.setFecha(fechaS);
            listaActividad.setHorario(horaS);

            databaseReference.child(materiaS).setValue(listaActividad);// Esta es la referencia como se va llamar el campo

        }

    }

}
