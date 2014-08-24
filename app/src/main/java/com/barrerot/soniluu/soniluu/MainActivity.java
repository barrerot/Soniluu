package com.barrerot.soniluu.soniluu;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

    public Button bsoundPool, bsoundPool_verdad, bsoundPool_tariro, bsettings;
    public SoundPool sp, sp_verdad, sp_tariro;
    public int flujodemusica_mentira, flujomusica_verdad, flujomusica_tariro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        bsoundPool = (Button)findViewById(R.id.mentira);
        bsoundPool_verdad = (Button)findViewById(R.id.verdad);
        bsoundPool_tariro = (Button)findViewById(R.id.tariro);
        bsettings = (Button) findViewById(R.id.confi);

        bsoundPool.setOnClickListener(this);
        bsoundPool_verdad.setOnClickListener(this);
        bsoundPool_tariro.setOnClickListener(this);
        bsettings.setOnClickListener(this);


        sp = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        sp_verdad = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        sp_tariro = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        flujodemusica_mentira = sp.load(this,R.raw.mentira,1);
        flujomusica_verdad = sp_verdad.load(this,R.raw.verdad,1);
        flujomusica_tariro = sp_tariro.load(this,R.raw.tariro,1);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.mentira){
            play_mentira();
        }
        if(v.getId()==R.id.verdad){
            play_verdad();
        }
        if(v.getId()==R.id.tariro){
            play_tariro();
        }
        if(v.getId()==R.id.confi){
            view_settings(v);
        }
    }

    private void play_mentira() {
        sp.play(flujodemusica_mentira, 1, 1, 0, 0, 1);
    }

    private void play_verdad() {
        sp_verdad.play(flujomusica_verdad, 1, 1, 0, 0, 1);
    }

    private void play_tariro() {
        sp_tariro.play(flujomusica_tariro, 1, 1, 0, 0, 1);
    }

    private void view_settings(View view) {
        Log.i("Sonido", "Le das al settings");
        Intent i = new Intent(this,SettingsActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
