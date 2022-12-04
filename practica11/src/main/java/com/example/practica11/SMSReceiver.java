package com.example.practica11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {
    @Override

    public void onReceive(Context context, Intent intent) {
    //El intent que recibe el receptor contiene los mensajes SMS en forma de pdu’s (paquetes de datos)
        Bundle extras=intent.getExtras();

        if(extras !=null){
            byte[][] pdus=(byte[][]) extras.get("pdus");
            for (byte[] pdu:pdus){
                //Convertimos  los pdu en SmsMessage utilizando SmsMessage.createFromPdu
                SmsMessage msg=SmsMessage.createFromPdu(pdu);

                //Extraemos el numero de telefono del remitente
                String phone=msg.getDisplayOriginatingAddress();

                //Extraemos el texto del mensaje
                String cuerpo=msg.getDisplayMessageBody();
            }
        }
    }
}
