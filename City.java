package clock;
import java.util.*;
public class City {
	// Here all streets in city will be saved
	static ArrayList<SubStreet> subStreets = new ArrayList<>();
	// here we save the locations of fire stations
	static ArrayList<SubStreet> fireStationsLocations = new ArrayList<>();
	// Here all incidents in city will be saved
	static ArrayList<Incident> incidents = new ArrayList<>();
	// Here all FireStations in city will be saved
	static ArrayList<FireStationTruck> fireStationsTrucks = new ArrayList<>();

	ArrayList<Route> routes = new ArrayList<>();

	public static void main(String[] args) {

		   // generate map for the city, save all subStreets in the arraylist above
			String roadName[] = {"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Madina road"
					,"Prince Sultan Street"
					,"King AbdulAziz"
					,"King AbdulAziz"
					,"Assalam"
					,"Assalam"
					,"Bin Baz"
					,"Palestine"
					,"Palestine"
					,"Palestine"
					,"Palestine"
					,"Prince Mohammed"
					,"Prince Mohammed"
					,"Prince Mohammed"
					,"Prince Mohammed"
					,"Prince Mohammed"
					,"Hira"
					,"Hira"
					,"Hira"
					,"Nouzha Street"
					,"Nouzha Street"
					,"Nouzha Street"
					,"Prince Majed"
					,"Prince Majed"
					,"Prince Majed"
					,"Prince Majed"
					,"Sixty Street"
					,"Sixty Street"
					,"Sixty Street"	};
			String SubRoadName[] = {"Assalam_MadinaA"
					,"MadinaA_Nouzha"
					,"Nouzha_Hira"
					,"Hira_BinBaz"
					,"BinBaz_PrinceMohammed"
					,"PrinceMohammed_Palestine"
					,"Assalam_Nouzha"
					,"Nouzha_Hira"
					,"Hira_PrinceMohammed"
					,"PrinceMohammed_Palestine"
					,"Assalam_PrinceMohammed2"
					,"Assalam_PrinceMohammed"
					,"PrinceMohammed_Palestine"
					,"PrinceSultan_Madina"
					,"PrinceSultan_KingAbdulAziz"
					,"Madina_PrinceMajed"
					,"PrinceMajed_Madina"
					,"PrinceMajed_Setten"
					,"Setten_Madina"
					,"Madina_KingAbdulAziz"
					,"PrinceMajed_Madina"
					,"PrinceMajed_Setten"
					,"Setten_Madina"
					,"Madina_PrinceSultan"
					,"PrinceSultan_KingAbdulAziz"
					,"PrinceMajed_Madina"
					,"PrinceMajed_Setten"
					,"Setten_Madina"
					,"PrinceMajed_Madina"
					,"PrinceMajed_Setten"
					,"Setten_Madina"
					,"Nouzha_Hira"
					,"Hira_BinBaz"
					,"BinBaz_PrinceMohammed"
					,"PrinceMohammed_Palestine"
					,"Nouzha_Hira"
					,"Hira_PrinceMohammed"
					,"PrinceMohammed_Palestine"
			};
			int roadLength[] = {15,11,2,2,5,3,5,2,7,3,
					13,14,5,2,2,4,4,2,2,2,4,2,2,3,1,3,
					2,2,3,2,1,2,2,4,3,2,7,3};
		for (int i = 0; i < roadName.length ; i++)
		{
			subStreets.add(new SubStreet(roadName[i],
					SubRoadName[i], roadLength[i]));
		}

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
