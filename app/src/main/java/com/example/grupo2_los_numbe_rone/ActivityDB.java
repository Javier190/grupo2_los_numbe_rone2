package com.example.grupo2_los_numbe_rone;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityDB extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private ListView listviewDB;
    AdminSQLite adminSQLite;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        et1 = (EditText) findViewById(R.id.et_codigo);
        et2 = (EditText) findViewById(R.id.et_nombre);
        listviewDB = (ListView) findViewById(R.id.listviewDB);
        adminSQLite = new AdminSQLite(this);
    }

    public void limpiar(View view) {
        et1.setText(null);
        et2.setText(null);
         }


    public void insertar(View view){
        adminSQLite.insertarDatos(et1.getText().toString(),et2.getText().toString());
        adminSQLite.abrirBaseDeDatos();
        limpiar(view);
        Toast.makeText(this, "Datos Ingresados", Toast.LENGTH_SHORT).show(); }


    public void modificar(View view){
        Producto producto = new Producto();
        producto.setCodigo(et1.getText().toString());
        producto.setNombre(et2.getText().toString());
        adminSQLite.modificarDatos(producto);
        limpiar(view);
        Toast.makeText(this, "Datos Modificados", Toast.LENGTH_SHORT).show(); }


    public void eliminar(View view){   //aca solamente se nesecita el nombre porque es la PK
        Producto producto = new Producto();
        producto.setCodigo(et1.getText().toString());
        adminSQLite.eliminarDatos(producto);
        limpiar(view);
        Toast.makeText(this, "Datos Borrados !", Toast.LENGTH_SHORT).show(); }

    public void seleccionar(View view){

        ArrayList<Producto> productos = adminSQLite.seleccionDatos();
        ArrayList<String> productosString = new ArrayList<String>();

        for (int i=0; i < productos.size(); i++) {
            productosString.add(productos.get(i).getNombre()); }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productosString);
        listviewDB.setAdapter(adapter);

        Toast.makeText(this, "Mostrando Datos", Toast.LENGTH_SHORT).show();
    }
}