package com.example.practica10;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.List;

public class ListaCentrosFragmentos extends ListFragment {
    ListView.OnItemClickListener listener;
    public ListaCentrosFragmentos() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Centro> centros = List.of(
                new Centro("Doctor Fleming", "IES", "Oviedo",
                        R.drawable.fleming2, R.drawable.fleming),
                new Centro("Monte Naranco", "IES", "Oviedo",
                        R.drawable.montenaranco2, R.drawable.naranco),
                new Centro("Avilés", "CIFP", "Avilés",
                        R.drawable.aviles2, R.drawable.aviles)
        );
        Activity activity = getActivity();
        setListAdapter(new CentrosAdapter(centros, activity));
        if (activity instanceof ListView.OnItemClickListener)
            listener = (AdapterView.OnItemClickListener) activity;
    }
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (listener != null)
            listener.onItemClick(l, v, position, id);
    }
}