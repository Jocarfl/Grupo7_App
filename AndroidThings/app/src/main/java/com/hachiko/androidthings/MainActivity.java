package com.hachiko.androidthings;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "Lista de UART disponibles: " + ArduinoUart.disponibles());
        ArduinoUart UART0 = new ArduinoUart("UART0", 115200);
        Log.d(TAG, "Mandado a Arduino: H");
        UART0.escribir("D");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.w(TAG, "Error en sleep()", e);
        }
        String s = UART0.leer();
        Log.d(TAG, "Recibido de Arduino: "+s);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
