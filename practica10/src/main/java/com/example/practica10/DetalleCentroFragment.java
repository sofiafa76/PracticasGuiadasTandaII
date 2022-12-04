package com.example.practica10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetalleCentroFragment extends Fragment {
    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_TIPO = "tipo";
    private static final String ARG_LOCALIDAD = "localidad";
    private static final String ARG_LOGO = "logo";
    private static final String ARG_IMAGEN = "imagen";
    private String nombre;
    private String tipo;
    private String localidad;
    private int logo;
    private int imagen;
    public DetalleCentroFragment() {}
    public static DetalleCentroFragment newInstance(Centro centro) {
        DetalleCentroFragment fragment = new DetalleCentroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, centro.getNombre());
        args.putString(ARG_TIPO, centro.getTipo());
        args.putString(ARG_LOCALIDAD, centro.getLocalidad());
        args.putInt(ARG_LOGO, centro.getLogo());
        args.putInt(ARG_IMAGEN, centro.getImagen());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString(ARG_NOMBRE);
            tipo = getArguments().getString(ARG_TIPO);
            localidad = getArguments().getString(ARG_LOCALIDAD);
            logo = getArguments().getInt(ARG_LOGO);
            imagen = getArguments().getInt(ARG_IMAGEN);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle_centro, container, false);
        ((ImageView) v.findViewById(R.id.imageViewLogo)).setImageResource(logo);
        ((TextView) v.findViewById(R.id.textViewNombre)).setText(nombre);
        ((TextView) v.findViewById(R.id.textViewTipo)).setText(tipo);
        ((TextView) v.findViewById(R.id.textViewLocalidad)).setText(localidad);
        ((ImageView) v.findViewById(R.id.imageViewCentro)).setImageResource(imagen);
        return v;
    }


}