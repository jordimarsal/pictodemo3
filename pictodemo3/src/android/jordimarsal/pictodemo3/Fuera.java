package android.jordimarsal.pictodemo3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Fuera extends Activity {
    int ayuda, cole, calle, atras;
    private boolean onSon = true;
    SoundManager snd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuera);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        snd = new SoundManager(getApplicationContext());

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        iniSonido();
        // numSonido = snd.load(R.raw.ayuda);
    }

    public void clickHandler(View v) {
        int id = v.getId(); // Use the button id to determine which sample
                            // should be played

        switch (id) {
            case R.id.imAuAyuda:
                snd.play(ayuda);
                Log.i("---", "imAuAyuda(Fuera)");
                break;

            case R.id.imAuAyuda2:
                snd.play(ayuda);
                Log.i("---", "imAuAyuda2(Fuera)");
                break;

            case R.id.imAuAtras:
                snd.play(atras);
                Log.i("---", "imAuCalle");
                break;

            case R.id.imAuColegio:
                snd.play(cole);
                Log.i("---", "imAuColegio");
                break;

            case R.id.imAuCalle:
                snd.play(calle);
                Log.i("---", "imAuCalle");
                break;

            case R.id.imAtras:
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Ir Atras", Toast.LENGTH_SHORT).show();
                finish();
                Log.i("---", "Go Atras-Fuera");
                break;

            case R.id.imCole:
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Ir al Cole", Toast.LENGTH_LONG).show();
                Log.i("---", "Go Cole-Fuera");
                break;
            case R.id.imCalle:
                // "android.jordimarsal.pictodemo2.Fuera"
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Ir a la Calle", Toast.LENGTH_LONG).show();
                Log.i("---", "Go Calle-Fuera");
                break;
            case R.id.ayuda_button:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_LONG).show();
                Log.i("---", "Go Ayuda-Fuera");
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

    private void iniSonido() {
        Log.i("---", "IniSonido-Fuera");
        snd = new SoundManager(getApplicationContext());
        ayuda = snd.load(R.raw.ayuda);
        cole = snd.load(R.raw.colegio);
        calle = snd.load(R.raw.patines);
        atras = snd.load(R.raw.atras);
        onSon = true;
    }
}
