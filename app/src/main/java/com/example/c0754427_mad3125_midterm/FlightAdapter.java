package com.example.c0754427_mad3125_midterm;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

//https://www.javatpoint.com/android-recyclerview-list-example
//github recycler_view example code







public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.MyViewHolder>
{
    public List<Row> RowsList;
    ImageView flightImage;

    TextView flightName,flightYear;

    private static final String TAG = "FlightAdapter";

    AppCompatActivity activity;

    public FlightAdapter(AppCompatActivity activity_main, List<Row> flightRowsList)
    {
        this.RowsList = flightRowsList;
        this.activity = activity_main;
        Log.e(TAG, "FlightAdapter: "+flightRowsList.size() );

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemlist, viewGroup, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Row mFlightRow = RowsList.get(i);
        String photoUrl = MainActivity.staticSpaceXFlightList.get(i).getLinks().getMission_patch();
        Glide.with(myViewHolder.flightImage)
                .load(photoUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(myViewHolder.flightImage);

        myViewHolder.flightName.setText(mFlightRow.getFlightName());
        myViewHolder.flightYear.setText(mFlightRow.getFlightYear());
    }

    @Override
    public int getItemCount() {
        return RowsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView flightImage;
        TextView flightName,flightYear;

        public MyViewHolder(View view)
        {
            super(view);
            flightImage =  view.findViewById(R.id.imageView);
            flightName =  view.findViewById(R.id.txtFlightName);
            flightYear =  view.findViewById(R.id.txtFlightYear);
        }
    }
}