package com.scolari.calendarproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.scolari.calendarproject.Adapter.LeerActividadAdapter;
import com.scolari.calendarproject.AnadirActividad;
import com.scolari.calendarproject.Model.LeerActividad;
import com.scolari.calendarproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {



    private static final String LISTA_NODE = " ListaActividades";
    private static final String TAG = "CalendarFragment";
    private DatabaseReference databaseReference;
    private ArrayAdapter arrayAdapter;
    private Adapter adapter;
    private List<LeerActividad> activitisNames;

    private RecyclerView rv;

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
        rv = (RecyclerView)  view.findViewById(R.id.actividadRecycler);

      //  RecyclerView actividadRecycler = (RecyclerView) view.findViewById(R.id.actividadRecycler);
     //   activitisNames = new ArrayList<>();

       // arrayAdapter = new ArrayA
        // dapter(view.getContext(), R.layout.cardview_activity, activitisNames);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        activitisNames = new ArrayList<>();
   //     rv.setAdapter(LeerActividadAdapter);



       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
       // linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);



       // actividadRecycler.setLayoutManager(linearLayoutManager);
        //arrayAdapter = new ArrayAdapter(getContext(), R.layout.cardview_activity, activitisNames);
       // LeerActividadAdapter leerActividadAdapterr = new LeerActividadAdapter(buidPictures(), R.layout.cardview_activity, getActivity());
    //    .setAdapter(arrayAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();// Ejecuto la persistencia de firbase cuando esta sin internet
    //    databaseReference = FirebaseDatabase.getInstance().getReference(); // esta liniea es para obtener el nodo principal padre







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
