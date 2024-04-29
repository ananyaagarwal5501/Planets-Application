package com.example.planetsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
   private static MyCustomAdapter adapter; //obj for our adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STEPS TO CREATE THE LISTVIEW
        //1. AdapterView: a listView
        listView = findViewById(R.id.listView);

        //2. Data Source: ArrayList<Planet>   {arraylist of planet class}
        planetArrayList = new ArrayList<>();

       //creation of planet object
        Planet planet1 = new Planet("Mercury", "0",R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0",R.drawable.venus);
        Planet planet3 = new Planet("Earth", "1",R.drawable.earth);
        Planet planet4 = new Planet("Mars", "2",R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "95",R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "146",R.drawable.saturn);
        Planet planet7 = new Planet("Uranus", "28",R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "16",R.drawable.neptune);
        Planet planet9 = new Planet("Pluto", "5",R.drawable.pluto);


        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);
        planetArrayList.add(planet9);//adding the planet object to the array list

        //Adapter
        adapter =  new MyCustomAdapter(planetArrayList, getApplicationContext());

        //linking with the adapter
        listView.setAdapter(adapter);

        //Handeling the click events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "Planet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}