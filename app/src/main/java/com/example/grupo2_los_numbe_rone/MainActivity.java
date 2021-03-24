package com.example.grupo2_los_numbe_rone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView imageView;
    private TextView textView;

    // inicialisanco las variables
    ListView listView;
    ArrayList<Pais> arraylistPaises;
    private AdapterJ adapterJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.ListView_elementos);

        arraylistPaises = new ArrayList<Pais>();


        arraylistPaises.add(new Pais(R.drawable.flag1, "Chile"));
        arraylistPaises.add(new Pais(R.drawable.flag2, "Peru"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Bolivia"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Chile"));
        arraylistPaises.add(new Pais(R.drawable.flag2, "Peru"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Bolivia"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Chile"));
        arraylistPaises.add(new Pais(R.drawable.flag2, "Peru"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Bolivia"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Chile"));
        arraylistPaises.add(new Pais(R.drawable.flag2, "Peru"));
        arraylistPaises.add(new Pais(R.drawable.flag1, "Bolivia"));


        adapterJ = new AdapterJ(this, R.layout.layaout_pincipal, arraylistPaises);
        listView.setAdapter(adapterJ);


        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){

            case 0:
                Toast.makeText(this,"Boton apretado en " + position, Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this,MainActivity2.class);
                startActivity(intent1);
                break;
            case 1:

                Toast.makeText(this,"Boton apretado en " + position, Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this,MainActivity3.class);
                startActivity(intent2);
                break;
            case 2:
                Toast.makeText(this,"Boton apretado en " + position, Toast.LENGTH_SHORT).show();

                break;
            case 3:
                Toast.makeText(this,"Boton apretado en " + position, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this,"Hacia Base de Datos " + position, Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this,"Boton apretado en " + position, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this,"Boton apretado en" + position, Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(MainActivity.this, ActivityDB.class);
                startActivity(intent6);
                break;

        }

    }




}
