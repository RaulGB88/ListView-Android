package com.practicas.pmdm.listviewandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.practicas.pmdm.listviewandroid.R;
import com.practicas.pmdm.listviewandroid.model.Plate;

import java.util.List;

public class PlateArrayAdapter extends ArrayAdapter<Plate> {

    public PlateArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public PlateArrayAdapter(@NonNull Context context, List<Plate> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            listItemView = inflater.inflate(R.layout.list_row, parent, false);
        }

        // Get TextView rows / atributtes
        //Obteniendo instancias de los text views y del ImageView
        TextView name = (TextView) listItemView.findViewById(R.id.tvName);
        TextView description = (TextView) listItemView.findViewById(R.id.tvDescription);
        TextView price = (TextView) listItemView.findViewById(R.id.tvPrice);
        ImageView image = (ImageView) listItemView.findViewById(R.id.ivImage);

        //Obteniendo instancia de la Tarea en la posición actual
        Plate plate = (Plate) getItem(position);

        // --- OBJECTS ----
        // SI: public class PlateArrayAdapter extends ArrayAdapter<Plate> {}
        // NO: PlateArrayAdapter<Plate> (Sin operador diamante)
        name.setText(plate.getName());
        description.setText(plate.getDescription());
        price.setText(plate.getPrice().toString());
        image.setImageResource(plate.getImage());

        // ---- STRINGS ----
        // (Para Dividir la cadena)
        /*
        String cadena;
        String subCadenas [];
        String delimitador = "/";

        cadena = plate.toString();
        subCadenas = cadena.split(delimitador,4);

        name.setText(subCadenas[0]);
        description.setText(subCadenas[1]);
        price.setText(subCadenas[2]);
        image.setImageResource(Integer.parseInt(subCadenas[3]));
        */
        return listItemView;
    }
}
