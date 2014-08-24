package com.barrerot.soniluu.soniluu.util;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.IOException;

/**
 * Created by carlosbarrero on 24/08/14.
 */
public class Sonido {

    private String logTag = null;
    private MediaRecorder mediaRecorder = null;
    private MediaPlayer mediaPlayer = null;
    private static String fichero = Environment.getExternalStorageDirectory().getAbsolutePath()+"/audio.3gp";

    public Sonido(String logTag){
        this.logTag = logTag;
    }

    public void grabar(View view) {
        this.mediaRecorder = new MediaRecorder();
        this.mediaRecorder.setOutputFile(fichero);
        this.mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        this.mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        this.mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            this.mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e(this.logTag, "Fallo en grabación");
        }
        this.mediaRecorder.start();
    }

    public void detenerGrabacion(View view) {
        if (this.mediaRecorder != null) {
            this.mediaRecorder.stop();
            this.mediaRecorder.release();
        }
    }

    public void reproducir(View view) {
        if (this.mediaRecorder != null) {
            this.mediaPlayer = new MediaPlayer();
            try {
                this.mediaPlayer.setDataSource(fichero);
                this.mediaPlayer.prepare();
                this.mediaPlayer.start();
            } catch (IOException e) {
                Log.e(this.logTag, "Fallo en reproducción");
            }
        }
    }
}
