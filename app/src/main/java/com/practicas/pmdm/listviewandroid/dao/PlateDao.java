package com.practicas.pmdm.listviewandroid.dao;

import android.database.Cursor;

import com.practicas.pmdm.listviewandroid.R;
import com.practicas.pmdm.listviewandroid.db.MyDB;
import com.practicas.pmdm.listviewandroid.model.Plate;

import java.util.ArrayList;
import java.util.List;

public class PlateDao implements PojoDao {

    /*
    public List<Plate> getPlateList() {

        List plateList = new ArrayList();
        plateList.add(new Plate(0, "Pizza Margarita", "Tomate, mozzarella y orégano", R.drawable.pizza_margarita, 8.0));
        plateList.add(new Plate(0, "Pizza Carbonara", "Nata, mozzarella, bacon", R.drawable.pizza_carbonara, 10.0));
        plateList.add(new Plate(0, "Pizza 4 Quesos", "Mozzarella, roquefort, emmental y cabra", R.drawable.pizza_quesos, 12.0));
        plateList.add(new Plate(0, "Pizza Pesto", "Tomate, mozzarella, queso de cabra, pesto y orégano", R.drawable.pizza_pesto, 12.5));
        plateList.add(new Plate(0, "Burguer Ternera", "Pan, ternera, cebolla, lechuga, tomate y queso", R.drawable.hamburguesa_ternera, 12.0));
        plateList.add(new Plate(0, "Burger Pollo", "Pan, ternera, cebolla, lechuga, tomate y queso", R.drawable.hamburguesa_pollo, 10.5));

        return plateList;
    }
    */

    /**
     * @param obj
     * @return
     */
    @Override
    public long add(Object obj) {
        return 0;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public int update(Object obj) {
        return 0;
    }

    /**
     * @param obj
     */
    @Override
    public void delete(Object obj) {

    }

    /**
     * @param obj
     * @return
     */
    @Override
    public Object search(Object obj) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List getAll() {
        
        ArrayList<Plate> plateList = new ArrayList<Plate>();
        String[] columnas = {
                "id", "name", "description", "price"
        };
        Cursor cursor = MyDB.getDB().query("plate", columnas, null, null, null, null, null);
        PlateDao productoDAO = new PlateDao();
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                Plate plate = new Plate();
                plate.setId(cursor.getInt(0));
                plate.setName(cursor.getString(1));
                plate.setDescription(cursor.getString(2));;
                plate.setPrice(cursor.getDouble(3));

                if(plate.getName().toLowerCase().contains("margarita"))
                    plate.setImage(R.drawable.pizza_margarita);
                else if(plate.getName().toLowerCase().contains("carbonara")) {
                    plate.setImage(R.drawable.pizza_carbonara);
                } else if(plate.getName().toLowerCase().contains("quesos")) {
                    plate.setImage(R.drawable.pizza_quesos);
                } else if(plate.getName().toLowerCase().contains("pesto")) {
                    plate.setImage(R.drawable.pizza_pesto);
                } else if(plate.getName().toLowerCase().contains("ternera")) {
                    plate.setImage(R.drawable.hamburguesa_ternera);
                } else if(plate.getName().toLowerCase().contains("pollo")) {
                    plate.setImage(R.drawable.hamburguesa_pollo);
                } else {
                    System.out.println("PlateDao.java >> Error al cargar la imagen del plato");
                }

                //c.setListaProductos(MyDB.getInstance(null).getProductoDAO().getProductos(c));
                plateList.add(plate);

            } while (cursor.moveToNext());
        }
        return plateList;
    }

}
