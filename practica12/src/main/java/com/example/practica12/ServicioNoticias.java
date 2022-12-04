package com.example.practica12;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ServicioNoticias extends Service {
    private final LinkedList<String> noticias=new LinkedList<>();
    private final Timer timer=new Timer();
    private final TimerTask tarea=new TimerTask() {
        @Override
        public void run() {
            if(noticias.size()==4)
                noticias.removeFirst();
            noticias.add(Fuente.getUltimaNoticia());
        }
    };
    private final IBinder binder=new NoticiasBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        timer.scheduleAtFixedRate(tarea,0,3000);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }
    public List<String> getNoticias(){
        return noticias;
    }

    public class NoticiasBinder extends Binder {
        public ServicioNoticias getService(){
            return ServicioNoticias.this;
        }
    }
}