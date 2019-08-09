package com.example.c0754427_mad3125_midterm;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataSource
{
    Context context;
    public ArrayList<Flight> mFlightList ;

    public ArrayList<Flight> getmFlightList() {
        return mFlightList;
    }

    public DataSource(Context context)
    {
        this.context = context;
    }

    @SuppressLint("NewApi")
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open("Data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null)
        {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                mFlightList = new ArrayList<Flight>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    Flight mFlight = getFlightObjectFromJSON(mJSONArray.getJSONObject(i));
                    mFlightList.add(mFlight);


                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Flight getFlightObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        String flight_number = userJsonObject.getString("flight_number");
        String mission_name = userJsonObject.getString("mission_name");
        String upcoming = userJsonObject.getString("upcoming");
        String launch_year = userJsonObject.getString("launch_year");
        String launch_date_local = userJsonObject.getString("launch_date_local");

        //Read Rocket
        JSONObject rocket = new JSONObject(userJsonObject.getJSONObject("rocket").toString());
        String rocket_id = rocket.getString("rocket_id");
        String rocket_name = rocket.getString("rocket_name");
        String rocket_type = rocket.getString("rocket_type");

        //Read Launch Site
        JSONObject Site = new JSONObject(userJsonObject.getJSONObject("site").toString());
        String site_id = Site.getString("site_id");
        String site_name = Site.getString("site_name");
        String site_name_long = Site.getString("site_name_long");

        //Read Links
        JSONObject links = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String mission_patch = links.getString("mission_patch");
        String mission_patch_small = links.getString("mission_patch_small");
        String article_link = links.getString("article_link");
        String wikipedia = links.getString("wikipedia");
        String video_link = links.getString("video_link");

        //start creating User object
        Flight mFlight = new Flight();
        mFlight.setFlight_number(flight_number);
        mFlight.setMission_name(mission_name);
        mFlight.setLaunch_year(launch_year);
        mFlight.setLaunch_date_local(launch_date_local);

        Rocket mRocket = new Rocket();
        mRocket.setRocket_id(rocket_id);
        mRocket.setRocket_name(rocket_name);
        mRocket.setRocket_type(rocket_type);
        mFlight.setRocket(mRocket);

        Site mLaunchSite = new Site();
        mLaunchSite.setSite_id(site_id);
        mLaunchSite.setSite_name(site_name);
        mLaunchSite.setSite_name_long(site_name_long);


        Link mLink = new Link();
        mLink.setMission_patch(mission_patch);
        mLink.setMission_patch_small(mission_patch_small);
        mLink.setArticle_link(article_link);
        mLink.setWikipedia(wikipedia);
        mFlight.setLink(mLink);

        return mFlight;
    }

}
