package com.practicas.pmdm.listviewandroid.db;

import android.content.Context;

import com.practicas.pmdm.listviewandroid.model.Plate;

import java.util.List;

public class MyPlateOperate {

    private static MyPlateOperate instance = null;

    private MyDB myDB;

    public MyPlateOperate(Context context) {
    }

    //***************************************
    // Interfaz publica de la API del banco
    //***************************************

    // Constructor del banco. Obtiene una instancia del mismo para operar
    public static MyPlateOperate getInstance(Context context) {
        if (instance == null) {
            instance = new MyPlateOperate(context);
        }
        return instance;
    }

    public List<Plate> getAllPlates() {
        return myDB.getPlateDao().getAll();
    }

}
