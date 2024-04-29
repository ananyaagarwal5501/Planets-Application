package com.example.planetsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //1. Using custom layouts --> MyCustomAdapter
    //2. Using custom objects --> extends ArrayAdapter<Planets> {we use the obj.s of the planet class}


    //variables
    private ArrayList<Planet> planetArrayList; //created an arraylist
    Context context; //context object


    //constructor
    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetArrayList); //the arraylist will take care of the inflation of each item in the planets array list
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    //view holder class
    private static class MyViewHolder {
        //holds the references to the views in the item layout

        //we have 3 views in the item layout
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    //implementing and ovverriding the getView()


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // (a) Get the data item for the current position
        Planet planets = getItem(position);//refer notes

        //(b) Inflate layout:
        MyViewHolder myViewHolder;
        final View result; //instance from the view called result

        if (convertView == null) {// *creating a new view!!!(as the convertView doesn't exist)*
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext()); //method that allows to return the context object
            convertView = inflater.inflate(
                    R.layout.item_list_layout, //custom layout we want
                    parent, //the parent view to which the view will be attached
                    false     //indicates that whether the inflated view should be attached to the parent immediately,
                    //passing 'false' means- that the view will NOT be attached to the parent right away.
            );

            //finding the views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moonCount);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;  //Done for making sure that the returned view contains the updated data for the current item in the list
            //both the result & the convertView is used here, to provide the clarity in the code &
            //make it easier to understand the flow
            //We CAN directly return the convertView without assigning it to the result. But this is the best to make the code clear

            convertView.setTag(myViewHolder); //read from copy
        } else {    //*when the view is recycled!!(here exists)*
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
            //Getting the data from the modal class
            myViewHolder.planetName.setText(planets.getPlanetName());
            myViewHolder.moonCount.setText(planets.getMoonCount());
            myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

            return result;


    }



}
