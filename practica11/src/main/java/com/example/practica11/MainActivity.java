package com.example.practica11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//se comprueba si la aplicación tiene el permiso
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Usamos este metodo para comprobar los permisos checkSelfPermission de la clase ContextCompat
        int permiso= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if(permiso!= PackageManager.PERMISSION_GRANTED)
            //Si el permiso no está asignado se solicita con el método requestPermissions de la clase
            // ActivityCompat,para que el usuario de los permisos
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_PHONE_STATE},0);


    TelephonyManager gestor=(TelephonyManager) getSystemService(Activity.TELEPHONY_SERVICE);
    String operador=gestor.getNetworkOperatorName();
    Toast.makeText(this,"Operador de telefonía: "+operador,Toast.LENGTH_LONG).show();

    if(permiso!=PackageManager.PERMISSION_GRANTED){
        Toast.makeText(this,"Esta aplicación no tiene el permiso solicitado",Toast.LENGTH_LONG).show();
    }
    }
}