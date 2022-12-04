package com.example.practica10;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends FragmentActivity implements
        AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Centro centro = (Centro) parent.getAdapter().getItem(position);
        DetalleCentroFragment fragmento = DetalleCentroFragment.newInstance(centro);
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragmentContainerView, fragmento).
                addToBackStack(null).
                commit();
    }
}