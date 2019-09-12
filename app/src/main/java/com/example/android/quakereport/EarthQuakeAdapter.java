package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {


    public EarthQuakeAdapter(@NonNull Context context, @NonNull List<EarthQuake> earthQuakes)
    {
        super(context, 0, earthQuakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }
        EarthQuake currentEarthQuake = getItem(position);

        //Setting the Magnitude TextView
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String mag = formatter.format(currentEarthQuake.getmMag());
        magnitudeView.setText(mag);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();


        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor =  MagnitudeColor(currentEarthQuake.getmMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String primeLoc = currentEarthQuake.getmLoc();
        String city;
        String offset;
        if (primeLoc.contains("of")){
            offset = primeLoc.substring(0, primeLoc.indexOf("of")+2);
            city = primeLoc.substring(primeLoc.indexOf("of")+3);
        }
        else{
            offset = "Near to";
            city = primeLoc;
        }


        //Setting the offset
        TextView offsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetView.setText(offset);

        //Setting the Location TextView
        TextView locationView = (TextView) listItemView.findViewById(R.id.primary_location);
        locationView.setText(city);

        //Setting the time and Date Views
        Date dateObject = new Date(currentEarthQuake.getmTimeInMS());

        //DatView Setting
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String formattedDate = dateFormat.format(dateObject);
        dateView.setText(formattedDate);

        //TimeView setting
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(dateObject);
        timeView.setText(formattedTime);




        return listItemView;
    }
    private int MagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }
}
