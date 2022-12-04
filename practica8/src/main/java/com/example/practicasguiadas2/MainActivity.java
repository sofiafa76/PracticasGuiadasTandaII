package com.example.practicasguiadas2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    AlertDialog dialog;
    EditText texto;
    Button guarda;
    int almacenamiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.texto);
        guarda=findViewById(R.id.guardar);
        guarda.setOnClickListener(this::onClick);
        dialog=new AlertDialog.Builder(this)
                .setTitle("Selecciona almacenamiento: ")
                .setSingleChoiceItems(R.array.opcionesalmacenamiento,0,this::onOpcionClick)
                .setPositiveButton("Aceptar",this::onRespuesta)
                .setNegativeButton("Cancelar",this::onRespuesta)
                .create();
    }
    public void onClick(View v){
       dialog.show();

    }
    public void onOpcionClick(DialogInterface dialogo,int opcion){
        almacenamiento=opcion;
    }
    public void onRespuesta(DialogInterface dialogo,int cual){
        if (cual==DialogInterface.BUTTON_POSITIVE){
            try{
                switch(almacenamiento){
                    case 0:
                        guardar(openFileOutput("datos.txt", Context.MODE_PRIVATE | Context.MODE_APPEND));
                break;
                    case 1:
                       File external= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                       File path=new File(external+"/"+"datos.txt");
                       guardar(new FileOutputStream(path,true));
                        break;

                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        dialogo.dismiss();

    }

    private void guardar(FileOutputStream stream){
        try(PrintWriter out= new PrintWriter(new OutputStreamWriter(stream, StandardCharsets.UTF_8))){
            out.println(texto.getText().toString());
        }
    }
}