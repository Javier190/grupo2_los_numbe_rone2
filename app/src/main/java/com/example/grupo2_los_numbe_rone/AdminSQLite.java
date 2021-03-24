package com.example.grupo2_los_numbe_rone;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AdminSQLite extends SQLiteOpenHelper {

    //Constructor
    public AdminSQLite(Context context){super(context, "DB_grupoDos", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productos ("+
                "codigo varchar(100)" +
                ",nombre varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Abrir base de datos.
    public SQLiteDatabase abrirBaseDeDatos()  {
        return getReadableDatabase();
    }

    //*****************CRUD**********// Para los 3 primeros metodos hay que poner writable pq vamos a modificar la data. escribir en ella.

    public void modificarDatos(Producto producto){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "UPDATE productos SET codigo='%s', nombre='%s' " +
                        "WHERE codigo='%s';", producto.getCodigo(), producto.getNombre(), producto.getCodigo());
        db.execSQL(sql);
        db.close();
    }

    public void insertarDatos(String codigo, String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "insert into productos (codigo, nombre) " +
                        "values ('%s','%s');",codigo, nombre);
        db.execSQL(sql);
        db.close();
    }

    public void eliminarDatos(Producto producto){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "DELETE FROM productos " +
                        "WHERE codigo='%s';", producto.getCodigo());
        db.execSQL(sql);
        db.close();
    }


    public ArrayList<Producto> seleccionDatos(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c;
        ArrayList<Producto> productos = new ArrayList<Producto>();

        c = db.rawQuery("select * from productos", null);

        if (c.moveToFirst()) {
            do {
                productos.add(new Producto(c.getString(0), c.getString(1)));
            } while(c.moveToNext());
        }
        db.close();
        return productos;
    }

}