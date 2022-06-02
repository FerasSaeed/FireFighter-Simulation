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
//
		//
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
		
		subStreets.get(0).getAdjSub().addAll(Arrays.asList(subStreets.get(1),subStreets.get(13),subStreets.get(6) ));
                subStreets.get(1).getAdjSub().addAll(Arrays.asList(subStreets.get(0),subStreets.get(2),subStreets.get(28) ));
                subStreets.get(2).getAdjSub().addAll(Arrays.asList(subStreets.get(1),subStreets.get(3),subStreets.get(25),subStreets.get(28) ));
                subStreets.get(3).getAdjSub().addAll(Arrays.asList(subStreets.get(2),subStreets.get(4),subStreets.get(15),subStreets.get(25) ));
                subStreets.get(4).getAdjSub().addAll(Arrays.asList(subStreets.get(3),subStreets.get(5),subStreets.get(15),subStreets.get(20) ));
                subStreets.get(5).getAdjSub().addAll(Arrays.asList(subStreets.get(4),subStreets.get(16),subStreets.get(20) ));
                subStreets.get(6).getAdjSub().addAll(Arrays.asList(subStreets.get(0),subStreets.get(7),subStreets.get(13),subStreets.get(30) ));
                subStreets.get(7).getAdjSub().addAll(Arrays.asList(subStreets.get(6),subStreets.get(8),subStreets.get(27),subStreets.get(30) ));
                subStreets.get(8).getAdjSub().addAll(Arrays.asList(subStreets.get(7),subStreets.get(9),subStreets.get(27),subStreets.get(23),subStreets.get(22) ));
                subStreets.get(9).getAdjSub().addAll(Arrays.asList(subStreets.get(8),subStreets.get(18),subStreets.get(19),subStreets.get(22),subStreets.get(23) ));
                subStreets.get(10).getAdjSub().addAll(Arrays.asList(subStreets.get(13),subStreets.get(14),subStreets.get(23),subStreets.get(24) ));
                subStreets.get(11).getAdjSub().addAll(Arrays.asList(subStreets.get(14),subStreets.get(24),subStreets.get(12) ));
                subStreets.get(12).getAdjSub().addAll(Arrays.asList(subStreets.get(11),subStreets.get(24),subStreets.get(19) ));
                subStreets.get(13).getAdjSub().addAll(Arrays.asList(subStreets.get(0),subStreets.get(6),subStreets.get(10),subStreets.get(14) ));
                subStreets.get(14).getAdjSub().addAll(Arrays.asList(subStreets.get(10),subStreets.get(13),subStreets.get(11) ));
                subStreets.get(15).getAdjSub().addAll(Arrays.asList(subStreets.get(3),subStreets.get(4),subStreets.get(32),subStreets.get(33) ));
                subStreets.get(16).getAdjSub().addAll(Arrays.asList(subStreets.get(9),subStreets.get(17),subStreets.get(34) ));
                subStreets.get(17).getAdjSub().addAll(Arrays.asList(subStreets.get(16),subStreets.get(18),subStreets.get(34),subStreets.get(37) ));
                subStreets.get(18).getAdjSub().addAll(Arrays.asList(subStreets.get(19),subStreets.get(17),subStreets.get(9),subStreets.get(37) ));
                subStreets.get(19).getAdjSub().addAll(Arrays.asList(subStreets.get(18),subStreets.get(9),subStreets.get(12) ));
                subStreets.get(20).getAdjSub().addAll(Arrays.asList(subStreets.get(4),subStreets.get(5),subStreets.get(33),subStreets.get(34),subStreets.get(21) ));
                subStreets.get(21).getAdjSub().addAll(Arrays.asList(subStreets.get(20),subStreets.get(33),subStreets.get(34),subStreets.get(22),subStreets.get(36),subStreets.get(37) ));
                subStreets.get(22).getAdjSub().addAll(Arrays.asList(subStreets.get(21),subStreets.get(23),subStreets.get(36),subStreets.get(37),subStreets.get(8),subStreets.get(9) ));
                subStreets.get(23).getAdjSub().addAll(Arrays.asList(subStreets.get(22),subStreets.get(24),subStreets.get(8),subStreets.get(9),subStreets.get(10) ));
                subStreets.get(24).getAdjSub().addAll(Arrays.asList(subStreets.get(23),subStreets.get(10),subStreets.get(11),subStreets.get(12) ));
                subStreets.get(25).getAdjSub().addAll(Arrays.asList(subStreets.get(2),subStreets.get(3),subStreets.get(26),subStreets.get(31),subStreets.get(32) ));
                subStreets.get(26).getAdjSub().addAll(Arrays.asList(subStreets.get(25),subStreets.get(27),subStreets.get(31),subStreets.get(32),subStreets.get(35),subStreets.get(36) ));
                subStreets.get(27).getAdjSub().addAll(Arrays.asList(subStreets.get(26),subStreets.get(35),subStreets.get(36),subStreets.get(7),subStreets.get(8) ));
                subStreets.get(28).getAdjSub().addAll(Arrays.asList(subStreets.get(1),subStreets.get(2),subStreets.get(29),subStreets.get(31) ));
                subStreets.get(29).getAdjSub().addAll(Arrays.asList(subStreets.get(28),subStreets.get(30),subStreets.get(31),subStreets.get(35) ));
                subStreets.get(30).getAdjSub().addAll(Arrays.asList(subStreets.get(6),subStreets.get(7),subStreets.get(29),subStreets.get(35) ));
                subStreets.get(31).getAdjSub().addAll(Arrays.asList(subStreets.get(25),subStreets.get(26),subStreets.get(28),subStreets.get(29),subStreets.get(32) ));
                subStreets.get(32).getAdjSub().addAll(Arrays.asList(subStreets.get(31),subStreets.get(33),subStreets.get(25),subStreets.get(26),subStreets.get(15) ));
                subStreets.get(33).getAdjSub().addAll(Arrays.asList(subStreets.get(32),subStreets.get(34),subStreets.get(15),subStreets.get(20),subStreets.get(21) ));
                subStreets.get(34).getAdjSub().addAll(Arrays.asList(subStreets.get(16),subStreets.get(17),subStreets.get(33),subStreets.get(20),subStreets.get(21) ));
                subStreets.get(35).getAdjSub().addAll(Arrays.asList(subStreets.get(29),subStreets.get(30),subStreets.get(36),subStreets.get(26),subStreets.get(27) ));
                subStreets.get(36).getAdjSub().addAll(Arrays.asList(subStreets.get(35),subStreets.get(37),subStreets.get(26),subStreets.get(27),subStreets.get(21),subStreets.get(22) ));
                subStreets.get(37).getAdjSub().addAll(Arrays.asList(subStreets.get(36),subStreets.get(21),subStreets.get(22),subStreets.get(17),subStreets.get(18) ));


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
		
		 
	/*  in Loop 2: create needed fire trucks and trapped trucks for each
	  incident, save them in fireStationsTrucks arraylist  */
		Random rand = new Random();
		int randomIndex= rand.nextInt(fireStationsLocations.size()); // random index between 0 & array size.
	
		for(int i=0; i < incidents.size() ; i++)
			if(incidents.get(i).getHasTrapped() ) {

				fireStationsTrucks.add(new TrappedTruck(incidents.get(i), new Route(fireStationsLocations.get(randomIndex), incidents.get(i).getLocation())));
				fireStationsTrucks.add(new FireTruck(incidents.get(i), new Route(fireStationsLocations.get(randomIndex), incidents.get(i).getLocation())));
			}
			else
				fireStationsTrucks.add(new FireTruck(incidents.get(i), new Route(fireStationsLocations.get(randomIndex), incidents.get(i).getLocation())));

			
			
			
		
		
		
		
		// Loop3: make tables for displaying information, based on steps of 5 minutes
	}
}
