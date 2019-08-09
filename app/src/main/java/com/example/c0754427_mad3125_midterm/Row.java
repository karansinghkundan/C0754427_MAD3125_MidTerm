package com.example.c0754427_mad3125_midterm;


//https://www.javatpoint.com/android-recyclerview-list-example
//github recycler_view example code





public class Row {
    String flightimage;
    String flightName;
    String flightYear;

    public Row(String flightimage, String flightName, String flightYear) {
        this.flightimage = flightimage;
        this.flightName = flightName;
        this.flightYear = flightYear;
    }

    public String getFlightimage() {
        return flightimage;
    }

    public void setFlightimage(String flightimage) {
        this.flightimage = flightimage;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightYear() {
        return flightYear;
    }

    public void setFlightYear(String flightYear) {
        this.flightYear = flightYear;
    }

    @Override
    public String toString() {
        return "Row{" +
                "flightimage='" + flightimage + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightYear='" + flightYear + '\'' +
                '}';
    }
}

