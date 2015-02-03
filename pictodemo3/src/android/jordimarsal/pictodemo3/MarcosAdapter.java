package android.jordimarsal.pictodemo3;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MarcosAdapter extends BaseAdapter {

    private Context mContext;
    private List<Marco> mMarcos;

    MarcosAdapter(Context context, List<Marco> marcos) {
        mContext = context;
        mMarcos = marcos;
    }

    @Override
    public int getCount() {
        return mMarcos.size();
    }

    @Override
    public Object getItem(int position) {
        return mMarcos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View celda;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            celda = inflater.inflate(R.layout.celda, null);
        } else {
            celda = convertView;
        }

        Marco persona = mMarcos.get(position);

        TextView texto = (TextView) celda.findViewById(R.id.texto);
        texto.setText(persona.getTexto());

        ImageView foto = (ImageView) celda.findViewById(R.id.foto);
        foto.setImageResource(persona.getFoto());

        return celda;
    }
}
