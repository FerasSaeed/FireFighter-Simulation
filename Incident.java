package com.orient;

import java.util.ArrayList;

public class Incident implements FireReport{

    private SubStreet location;
    private Clock timeOfFire;
    private String fireType;
    private boolean hasTrapped;

    //added variables
    private int trappedVictims;

    //generate a random incident with random variable values
    private Incident(ArrayList<SubStreet> s)
    {
    	 //**generate a random time by making a new Clock object like time of fire = new Clock(random hour(0-23), random minute(0-60))
       //<-----
        int hours = (int)(Math.random() * 24);
        int minutes = (int)(Math.random() * 60);
        timeOfFire =  new Clock(hours , minutes);


        // pick random index between 0 and ArrayList length
        location = s.get((int)(Math.random() * s.size()));

        
        
        //** pick random number either 1 or 0 to decide if hasTrapped is true or false,
        if (Math.random() < 0.75)
        {
            hasTrapped = false;

        }else hasTrapped = true;
        //**if there were trapped people, generate their number from 1 to 10 people
        if (hasTrapped == true)
        {
            trappedVictims = (int)(Math.random());
        }
        if (Math.random() < 0.75)
        {
            trappedVictims *= 4;
        }else trappedVictims = 4 + (trappedVictims * 10);
    }


    //get incidents whereabouts,
    // which street at which location in this street
    public SubStreet getLocation()
    {
        return location;
    }

    //get what caused the fire ie. burning vehicle
    // or electrical petition,flammable chemicals/gasses,
    public String getFireType()
    {
        String[] types = {"Flammable Gases", "Flammable liquids",
                "Electric equipment", "Ordinary Combustibles"};
        fireType = types[(int)(Math.random() * (types.length))];
        return fireType;
    }

    //get how many victims got trapped at fire incident
    public int getTrappedNum()
    {
        return trappedVictims;
    }

    public Clock getTimeOfFire(){return timeOfFire;}

    //get whether the victim/victims of incident is trapped
    public boolean getHasTrapped()
    {
        if(hasTrapped)
            return true;
        else
            return false;

    }

    @Override
    public String getAFullReport()
    {
        return "\nFiretruck Arrival: " + /**/0 +
                "\nTime Solved: " + timeOfFire.getCurrentTime() +
                "\nTime happened: " + timeOfFire +
                "\nincident location: " + location ;
    }
}
