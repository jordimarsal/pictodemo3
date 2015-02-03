package android.jordimarsal.pictodemo3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Casa extends Activity {
    int atras, ayuda, alimentacion, aseo, juego, ropa;
    private boolean onSon = true;
    SoundManager snd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casa);

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

            case R.id.imAuAlimentacion:
                snd.play(alimentacion);
                Log.i("---", "imAuColegio");
                break;

            case R.id.imAuAseo:
                snd.play(aseo);
                Log.i("---", "imAuCalle");
                break;
            case R.id.imAuActividad:
                snd.play(juego);
                Log.i("---", "imAuCalle");
                break;
            case R.id.imAuRopa:
                snd.play(ropa);
                Log.i("---", "imAuCalle");
                break;

            case R.id.imAtras:
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Ir Atras", Toast.LENGTH_SHORT).show();
                finish();
                Log.i("---", "Go Atras-Fuera");
                break;
            case R.id.imAlimentacion:
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Alimentacion", Toast.LENGTH_SHORT).show();
                Log.i("---", "Go Alimentacion-Casa");
                break;
            case R.id.imAseo:
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Aseo personal", Toast.LENGTH_SHORT)
                        .show();
                Log.i("---", "Go Aseo-Casa");
                break;
            case R.id.imActividad:
                // "android.jordimarsal.pictodemo2.Fuera"
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Actividad", Toast.LENGTH_SHORT).show();
                Log.i("---", "Go Actividad-Casa");
                break;
            case R.id.imRopa:
                // "android.jordimarsal.pictodemo2.Fuera"
                // startActivity(new Intent(this, Fuera.class));
                Toast.makeText(this, "Ropa", Toast.LENGTH_SHORT).show();
                Log.i("---", "Go Ropa-Casa");
                break;
            case R.id.ayuda_button:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show();
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
        atras = snd.load(R.raw.atras);
        ayuda = snd.load(R.raw.ayuda);
        alimentacion = snd.load(R.raw.alimentacion);
        aseo = snd.load(R.raw.aseo_personal);
        juego = snd.load(R.raw.actividad);
        ropa = snd.load(R.raw.ropa);
        onSon = true;
    }
}