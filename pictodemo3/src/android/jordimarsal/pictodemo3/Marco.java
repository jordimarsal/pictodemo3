package android.jordimarsal.pictodemo3;

public class Marco {

    private String mTexto;
    private int mFoto;

    public Marco(String texto, int foto) {
        mTexto = texto;
        mFoto = foto;
    }

    public int getFoto() {
        return mFoto;
    }

    public String getTexto() {
        return mTexto;
    }

}
