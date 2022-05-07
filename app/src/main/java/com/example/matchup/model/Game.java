package com.example.matchup.model;

import java.io.Serializable;

public class Game implements Serializable {

    public int stringResourceId;
    public String type; // soccer, basketball, etc.
    public String title; // Soccer Game @ North
    public String host; // Valerie Yip
    public String skillLevel; // beginner
    public double distance; // 0.2 -- miles
    public String location; // RSF Berkeley
    public String date; // 4/15/22
    public int people; // 11
    public String time; // 7pm
    public int totalPeople; // 22
    public String description; // this game is whatever...
    public boolean joined; // game is joined by user

    public Game() {
        this.stringResourceId = stringResourceId;
        this.type = "soccer";
        this.title = "Soccer Game @ North Field";
        this.host = "Valerie Yip";
        this.skillLevel = "beginner";
        this.distance = 0.2;
        this.location = "North Field";
        this.date = "4/15/22";
        this.people = 0;
        this.totalPeople = 22;
        this.description = "We are members of the Cal Rec Soccer Team looking for extra people to scrim with on Tuesdays 5-7pm. We will do drills and warm up from 5-5:45pm and then we will start a game at 6pm!";
        this.time = "6pm";
        this.joined = false;
    }

    public Game(String type, String title, String host, String skillLevel, double distance, String location, String date,
                int people, String time, int totalPeople, String description, boolean joined) {
        this.type = type;
        this.title = title;
        this.host = host;
        this.skillLevel = skillLevel;
        this.distance = distance;
        this.location = location;
        this.date = date;
        this.people = people;
        this.totalPeople = totalPeople;
        this.description = description;
        this.time = time;
        this.joined = joined;
    }

    public Game(String type) {
        this(type, "Soccer Game @ North Field", "Valerie Yip", "beginner", 0.2, "North Field", "4/15/22", 0, "6pm", 22, "none", false);
    }
}