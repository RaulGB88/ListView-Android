package com.practicas.pmdm.listviewandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.practicas.pmdm.listviewandroid.adapter.PlateArrayAdapter;
import com.practicas.pmdm.listviewandroid.dao.PlateDao;
import com.practicas.pmdm.listviewandroid.db.MyPlateOperate;
import com.practicas.pmdm.listviewandroid.model.Plate;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PlateDao plateDao = new PlateDao();
    ListView lvMenu;
    PlateArrayAdapter adapter = null;
    List<Plate> listPlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        // Init Data from DB.
        MyPlateOperate myPlateOperate = MyPlateOperate.getInstance(this);

        // Get List from Plate.
        listPlate = plateDao.getAll();

        // Init Adapter and set a list from Object.
        adapter = new PlateArrayAdapter(this, listPlate);

        // Get list for layout.
        lvMenu = findViewById(R.id.lvList);
        // Set Adapter to List.
        lvMenu.setAdapter(adapter);
    }

}