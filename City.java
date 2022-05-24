package clock;
import java.util.*;
public class City {
	// Here all streets in city will be saved
	ArrayList<SubStreet> subStreets = new ArrayList<>();
	// here we save the locations of fire stations
	ArrayList<SubStreet> fireStationsLocations = new ArrayList<>();
	// Here all incidents in city will be saved
	ArrayList<Incident> incidents = new ArrayList<>();
	// Here all FireStations in city will be saved
	static ArrayList<FireStationTruck> fireStationsTrucks = new ArrayList<>();

	ArrayList<Route> routes = new ArrayList<>();

	public static void main(String[] args) {

		   // generate map for the city, save all subStreets in the arraylist above

        // Loop1: for i from 1 to a random number (max is 20) generate incidents objects
        // that are saved in ArrayList<Incident> incidents
		int random = (int)(Math.random() * 20);
        	for (int i = 0; i < random; i++) {
           		incidents.add(new Incident(subStreets));
        	}
        /*
         * Generate 3 fire stations subStreets randomly, choose 3 "unique" SubStreets
         * from the subStreets arraylist above which means a random number for an index,
         * that DOES NOT get repeated!
         */
        	ArrayList<SubStreet> V = subStreets;
        	int i = 0;
        	while (i < 3)
       	 	{
           		int M = (int)(Math.random() * subStreets.size());
            		if (V.get(M) != null)
            		{
               		fireStationsLocations.add(V.get(M));
                	V.remove(M);
                	i++;
            		}
        	}
		/*
		 
		 *  in Loop 2: create needed fire trucks and trapped trucks for each
		 * incident, save them in arraylist
		 */
		// Loop3: make tables for displaying information, based on steps of 5 minutes
	}
}
