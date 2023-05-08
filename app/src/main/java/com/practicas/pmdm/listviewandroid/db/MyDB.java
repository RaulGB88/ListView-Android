package com.practicas.pmdm.listviewandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.practicas.pmdm.listviewandroid.dao.PlateDao;

public class MyDB extends SQLiteOpenHelper {

    private static SQLiteDatabase db;
    //nombre de la base de datos
    private static final String database = "MyPlates";
    //versión de la base de datos
    private static final int version = 11;

    private String sqlPlate = "CREATE TABLE plate ( id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, description STRING, price DOUBLE);";

    public static MyDB instance = null;

    private static PlateDao plateDao;

    public PlateDao getPlateDao() {
        return plateDao;
    }

    public MyDB(Context context) {
        super(context, database, null, version);
    }

    public static MyDB getInstance(Context context) {
        if (instance == null) {
            instance = new MyDB(context);
            db = instance.getWritableDatabase();
            plateDao = new PlateDao();
        }
        return instance;
    }

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public MyDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDB() {
        return db;
    }

    public static void closeDB() {
        db.close();
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create DB Tables
        db.execSQL(sqlPlate);

        // Insert Data to Tables
        insercionDatos(db);

        Log.i("SQLite", "Se crea la base de datos " + database + " version " + version);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Delete DB Tables
        db.execSQL("DROP TABLE IF EXISTS plate");

        // Create DB Tables
        db.execSQL(sqlPlate);

        // Insert Data to Tables
        insercionDatos(db);

        Log.i("SQLite", "Se crea la base de datos " + database + " version " + version);
    }

    private void insercionDatos(SQLiteDatabase db) {
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (0, 'Pizza Margarita', 'Tomate, mozzarella y orégano', 8.0);");
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (1, 'Pizza Carbonara', 'Nata, mozzarella, bacon', 10.0);");
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (2, 'Pizza 4 Quesos', 'Mozzarella, roquefort, emmental y cabra', 12.0);");
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (3, 'Pizza Pesto', 'Tomate, mozzarella, queso de cabra, pesto y orégano', 12.5);");
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (4, 'Pizza Ternera', 'Pan, ternera, cebolla, lechuga, tomate y queso', 12.0);");
        db.execSQL("INSERT INTO plate(id, name, description, price) VALUES (5, 'Pizza Pollo', 'Pan, ternera, cebolla, lechuga, tomate y queso', 10.5);");
    }

}
