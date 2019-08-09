package com.example.c0754427_mad3125_midterm;

public class Flight {

    String flight_number;
    String mission_name;
    String launch_year;
    String launch_date_local;
    Rocket rocket;
    Site site;
    Link link;

    public Flight(String flight_number, String mission_name, String launch_year, String launch_date_local, Rocket rocket, Site site, Link link) {
        this.flight_number = flight_number;
        this.mission_name = mission_name;
        this.launch_year = launch_year;
        this.launch_date_local = launch_date_local;
        this.rocket = rocket;
        this.site = site;
        this.link = link;
    }

    public Flight() {

    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(String launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_number='" + flight_number + '\'' +
                ", mission_name='" + mission_name + '\'' +
                ", launch_year='" + launch_year + '\'' +
                ", launch_date_local='" + launch_date_local + '\'' +
                ", rocket=" + rocket +
                ", site=" + site +
                ", link=" + link +
                '}';
    }
}
