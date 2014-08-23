package com.barrerot.soniluu.soniluu;

import android.content.Context;
import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by carlosbarrero on 23/08/14.
 */
public class Sonido {

    private MediaRecorder grabador;

    public Sonido (Context contexto){
        grabador = new MediaRecorder();
    }

    public void comenzarGrabacion(String ruta)
    {
        try
        {
            grabador.setAudioSource(MediaRecorder.AudioSource.MIC); // Indico que quiero grabar del micrófono
            grabador.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); // Formato de salida
            grabador.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);    // Codificación
            grabador.setOutputFile(ruta);
            grabador.prepare();                                             // Prepara el objeto para comenzar a grabar
            grabador.start();                                               // Comienza la grabación
        }
        catch (IllegalStateException e)
        {
            Log.i("Sonido", "Error grabando el sonido: " + e.toString());
        }
        catch (IOException e)
        {
            Log.i("Sonido", "Error grabando el sonido: " + e.toString());
        }
    }
}
