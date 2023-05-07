package com.practicas.pmdm.listviewandroid.dao;

import com.practicas.pmdm.listviewandroid.R;
import com.practicas.pmdm.listviewandroid.model.Plate;

import java.util.ArrayList;
import java.util.List;

public class PlateDao {

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
}
