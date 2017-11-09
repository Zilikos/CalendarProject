package com.scolari.calendarproject.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.scolari.calendarproject.Model.LeerActividad;
import com.scolari.calendarproject.R;

import java.util.ArrayList;

/**
 * Created by zilikos on 9/11/17.
 */

public class LeerActividadAdapter extends RecyclerView.Adapter<LeerActividadAdapter.LeerViewholder> {


    private ArrayList<LeerActividad> leerActividades;
    private int resource;
    private Activity activity;

    public LeerActividadAdapter(ArrayList<LeerActividad> leerActividades, int resource, Activity activity) {
        this.leerActividades = leerActividades;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public LeerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new LeerViewholder(view);
    }

    @Override
    public void onBindViewHolder(LeerViewholder holder, int position) {

        LeerActividad leerActividad =  leerActividades.get(position);
        holder.titulo.setText(leerActividad.getTitulo());
        holder.descripcion.setText(leerActividad.getDescripcion());
        holder.hecho.setChecked(leerActividad.getHecho());



    }

    @Override
    public int getItemCount() {
        return leerActividades.size();
    }






    public class LeerViewholder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView descripcion;
        private CheckBox hecho;

        public LeerViewholder(View itemView) {
            super(itemView);

            titulo               = (TextView) itemView.findViewById(R.id.txtTitulo);
            descripcion          = (TextView) itemView.findViewById(R.id.txtDescription);
            hecho                = (CheckBox) itemView.findViewById(R.id.chkHecho);


        }
    }
}
