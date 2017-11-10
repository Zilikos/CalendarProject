package com.scolari.calendarproject.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.scolari.calendarproject.Adapter.LeerActividadAdapter;
import com.scolari.calendarproject.AnadirActividad;
import com.scolari.calendarproject.Model.LeerActividad;
import com.scolari.calendarproject.Model.ListaActividad;
import com.scolari.calendarproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {



    private static final String LIST_NODE = "ListaActividades";
    private static final String TAG = "CalendarFragment";
    private ArrayAdapter arrayAdapter;
    private List<String> nombresActividades;

    private ListView lstActividad;

    private static final String FIREBASE_SERVER_URL = "https://calendarproject-8d039.firebaseio.com/";

    Firebase firebase;
    private DatabaseReference databaseReference;
    //here



    private FloatingActionButton fabNewAct;


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);


        lstActividad = (ListView)  view.findViewById(R.id.lstActividad);
        nombresActividades = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, nombresActividades);
        lstActividad.setAdapter(arrayAdapter);

        Firebase.setAndroidContext(view.getContext());
        firebase = new Firebase(FIREBASE_SERVER_URL);
        databaseReference = FirebaseDatabase.getInstance().getReference(LIST_NODE);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nombresActividades.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        ListaActividad listaActividad = snapshot.getValue(ListaActividad.class);
                        Log.w(TAG, "Actividades: " + listaActividad.getMateria());
                        nombresActividades.add(listaActividad.getMateria());
                    }
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        fabNewAct = (FloatingActionButton) view.findViewById(R.id.fabNewAct);
        fabNewAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AnadirActividad.class);
                //here
                startActivity(intent);
            }
        });

        return view;
    }


}
