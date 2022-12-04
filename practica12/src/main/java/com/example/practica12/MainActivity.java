package com.example.practica12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends ListActivity implements ServiceConnection {

    ServicioNoticias servicio;
    ArrayAdapter<String> adapter;


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

        servicio=((ServicioNoticias.NoticiasBinder) service).getService();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,servicio.getNoticias());
        setListAdapter(adapter);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        servicio=null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService(new Intent(this,ServicioNoticias.class),this, Context.BIND_AUTO_CREATE);
    }
    public void obtenerNoticiasNuevas(View v){
        adapter.notifyDataSetChanged();
    }
}