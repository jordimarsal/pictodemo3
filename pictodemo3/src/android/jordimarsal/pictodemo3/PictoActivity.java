package android.jordimarsal.pictodemo3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class PictoActivity extends Activity {

    SoundManager snd;
    int ayuda, casa, fuera;
    boolean onSon = true;

    private ArrayList<Marco> mMarcos;
    private MarcosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picto_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        snd = new SoundManager(getApplicationContext());

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        iniSonido();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.picto, menu);
        return true;
    }

    public void setView(View v) {

        int id = v.getId();
        String texto;
        int foto;

        switch (id) {
            case R.id.imCasa:
                foto = R.drawable.casa2;
                texto = getResources().getString(R.string.casa);
                Log.i("---", "casa2");
                break;

            case R.id.imFuera:
                foto = R.drawable.fuera2;
                texto = getResources().getString(R.string.fuera);
                Log.i("---", "fuera2");
                break;
            default:
                foto = R.drawable.nodisponible;
                texto = getResources().getString(R.string.nodisponible);
                Log.i("---", "nodisponible");
                break;
        }

        mMarcos.add(new Marco(texto, foto));
        mAdapter.notifyDataSetChanged();

    }

    public void clickHandler(View v) {
        int id = v.getId(); // Use the button id to determine which sample
                            // should be played
        if (!onSon)
            iniSonido();

        switch (id) {
            case R.id.imAuAyuda:
                snd.play(ayuda);
                Log.i("---", "imAuAyuda");
                break;

            case R.id.imAuAyuda2:
                snd.play(ayuda);
                Log.i("---", "imAuAyuda2");
                break;

            case R.id.imAuCasa:
                snd.play(casa);
                Log.i("---", "imAuCasa");
                break;

            case R.id.imAuFuera:
                snd.play(fuera);
                Log.i("---", "imAuFuera");
                break;

            case R.id.imFuera:
                snd.unloadAll();
                onSon = false;
                startActivity(new Intent(this, Fuera.class));
                Log.i("---", "Go Fuera");
                break;
            case R.id.imCasa:
                snd.unloadAll();
                onSon = false;
                // "android.jordimarsal.pictodemo2.Fuera"
                startActivity(new Intent(this, Casa.class));
                Log.i("---", "Go Casa");
                break;
            case R.id.imInfo:
                Toast.makeText(this, "Info", Toast.LENGTH_LONG).show();
                Log.i("---", "Go Info");
                // startActivity(new Intent(this, Fuera.class));
                break;
            case R.id.ayuda_button:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_LONG).show();
                Log.i("---", "Go Ayuda-Picto");
                // startActivity(new Intent(this, Fuera.class));
                break;
        }
    }

    @Override
    protected void onRestart() {
        Log.i("---", "onRestart-Picto");
        super.onRestart();
        if (!onSon)
            iniSonido();
    }

    @Override
    protected void onResume() {
        Log.i("---", "onResume-Picto");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i("---", "onStart-Picto");
        super.onStart();
    }

    @Override
    public void recreate() {
        Log.i("---", "recreate-Picto");
        super.recreate();
    }

    private void iniSonido() {
        Log.i("---", "IniSonido-Picto");
        snd = new SoundManager(getApplicationContext());
        ayuda = snd.load(R.raw.ayuda);
        casa = snd.load(R.raw.casa);
        fuera = snd.load(R.raw.fuera_de_casa);
        onSon = true;
    }
}
