package com.example.practica13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.cambiar).setOnClickListener(this::cambiarPreferencias);
        textView = findViewById(R.id.textView);
    }
    @Override
    protected void onResume() {
        super.onResume();
        textView.setText("");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        textView.append("BÚSQUEDA AUTOMÁTICA\n" + (prefs.getBoolean(
                "pref_busqueda_automatica", false) ? "activada" : "desactivada"));
        textView.append("\n\nTEXTO DE BÚSQUEDA POR DEFECTO\n" +
                prefs.getString("pref_texto_por_defecto", "indefinido"));
        textView.append("\n\nBUSCADOR PREDETERMINADO\n" +
                prefs.getString("pref_buscador_predeterminado", "indefinido"));
    }
    private void cambiarPreferencias(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}