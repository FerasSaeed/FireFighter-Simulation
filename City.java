package clock;
import java.util.*;
public class City {
	/**
 * This class runs the simulation
 * 
 * @author All team members
 *
 */
public class City {

	/**
	 * Here all streets in city will be saved
	 */
	public static ArrayList<SubStreet> subStreets = new ArrayList<>();
	/**
	 * here we save the locations of fire stations
	 */
	public static ArrayList<SubStreet> fireStationsLocations = new ArrayList<>();
	/**
	 * Here all incidents in city will be saved
	 */
	public static ArrayList<Incident> incidents = new ArrayList<>();
	/**
	 * Here all FireStations in city will be saved
	 */
	public static ArrayList<FireStationTruck> fireStationsTrucks = new ArrayList<>();


	/**
	 * Generate map, incidents, fire trucks, trapped trucks, and run the simulation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

			CityMap.generateMap();

			int incidentNum = 0;
			System.out.print("Enter the Number of incidents: ");

			// loop to check until the user enters a valid value
			while (true) {
				try {
					incidentNum = input.nextInt();
					if (incidentNum < 1) {

						System.out.print("Values must be positive! Enter the number of incidents:");
						continue;
					}
					if (incidentNum % 1 == 0) {
						break;
					}
				} catch (InputMismatchException e) {

					System.out.print("Invalid input! Enter the number of incidents: ");
					input.next();

				}
			}
			System.out.println();
			int phase = 0;


        // Loop1: for i from 1 to a random number (max is 20) generate incidents objects
        // that are saved in ArrayList<Incident> incidents
		int random = (int)(Math.random() * 20);
        	for (int i = 0; i < random; i++) {
           		incidents.add(new Incident(subStreets));
        	}
		
	//to print the table of incidents
		System.out.println("Number of Incident" + "\t" +"Time of Fire \t" + "Main street\t\t" + "Sub Street\t\t" + "Fire type\t" + "Has trapped?\t"
				+ "Trapped number");
		//get each report for incidents
		for (Incident inc : incidents) {
			System.out.println(inc.getAFullReport());

		}
        /*
         * Generate 3 fire stations subStreets randomly, choose 3 "unique" SubStreets
         * from the subStreets arraylist above which means a random number for an index,
         * that DOES NOT get repeated!
         */
        	ArrayList<SubStreet> V = subStreets;
        	int i = 0;
        	while (i < 8)
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

			
			
			
		
		
		
		
// to print the table of trucks trips
		System.out.println("\n" + "Truck Type \t" + " Trip Number \t" + "Current Main Street \t"
				+ "Current Sub Street \t" + "Current Time\t" + "Current Activity\t" + "Finished mission?"
				+ "\tFire type" + "\tTrapped" + "\t Mission Duration");
		System.out.println(
				"******************************************************************************************************************************************************************************************");
		int l = 0;
		for (int loop = 0; loop < 250; loop++) {
			for (int n = 0; n < fireStationsTrucks.size(); n++) {
			//Get a report from each truck
				fireStationsTrucks.get(n).currentReport(l);
			}
			//integer used to determine when all trucks finished their tasks
			int finished = 0;
			for (int checkFinished = 0; checkFinished < fireStationsTrucks.size(); checkFinished++) {
				if (fireStationsTrucks.get(checkFinished).statues()) {
					finished++;

				}

			}
			//if all trucks finished their tasks exit the loop
			if (finished == fireStationsTrucks.size()) {
				break;
			}
			l = l + 4;
			System.out.println(
					"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		}
		//to determine the average duration for all truck missions
		double average = 0;
		for (FireStationTruck truck : fireStationsTrucks) {

			average = average + truck.getMissionDur();

		}// print the average to all truck missions
		System.out.println("\n \n\nThe average Duration of all missions is: "
				+ (int) (average / fireStationsTrucks.size()) + " Minutes");
		
		double lateTruck = 0;
		for (FireStationTruck truck : fireStationsTrucks) {
			if(truck.getMissionDur()>45) {
				
				lateTruck++;
			}
			
			
		}
System.out.println("\n\n Percentage of missions lateness (more than 45 minutes until mission end time): " + (int)((lateTruck/fireStationsTrucks.size()*100)) + "%");
			
	
	
	}



private class CityMap {
		// all roads names
		private static String[] roadName;
		// all sub roads names
		private static String SubRoadName[];

		public static void generateMap() {

			// generate map for the city, save all subStreets in the arraylist above
			roadName = new String[] { "Madina road", "Madina road", "Madina road", "Madina road", "Madina road",
					"Madina road", "Madina road", "Madina road", "Madina road", "Madina road", "Prince Sultan Street",
					"King AbdulAziz", "King AbdulAziz", "Assalam", "Assalam", "Bin Baz", "Palestine", "Palestine",
					"Palestine", "Palestine", "Prince Mohammed", "Prince Mohammed", "Prince Mohammed",
					"Prince Mohammed", "Prince Mohammed", "Hira", "Hira", "Hira", "Nouzha Street", "Nouzha Street",
					"Nouzha Street", "Prince Majed", "Prince Majed", "Prince Majed", "Prince Majed", "Sixty Street",
					"Sixty Street", "Sixty Street" };
			SubRoadName = new String[] { "Assalam_MadinaA", "MadinaA_Nouzha", "Nouzha_Hira", "Hira_BinBaz",
					"BinBaz_PrinceMohammed", "PrinceMohammed_Palestine", "Assalam_Nouzha", "Nouzha_Hira",
					"Hira_PrinceMohammed", "PrinceMohammed_Palestine", "Assalam_PrinceMohammed2",
					"Assalam_PrinceMohammed", "PrinceMohammed_Palestine", "PrinceSultan_Madina",
					"PrinceSultan_KingAbdulAziz", "Madina_PrinceMajed", "PrinceMajed_Madina", "PrinceMajed_Setten",
					"Setten_Madina", "Madina_KingAbdulAziz", "PrinceMajed_Madina", "PrinceMajed_Setten",
					"Setten_Madina", "Madina_PrinceSultan", "PrinceSultan_KingAbdulAziz", "PrinceMajed_Madina",
					"PrinceMajed_Setten", "Setten_Madina", "PrinceMajed_Madina", "PrinceMajed_Setten", "Setten_Madina",
					"Nouzha_Hira", "Hira_BinBaz", "BinBaz_PrinceMohammed", "PrinceMohammed_Palestine", "Nouzha_Hira",
					"Hira_PrinceMohammed", "PrinceMohammed_Palestine" };
			// length for every substreet
			int roadLength[] = { 15, 11, 2, 2, 5, 3, 5, 2, 7, 3, 13, 14, 5, 2, 2, 4, 4, 2, 2, 2, 4, 2, 2, 3, 1, 3, 2, 2,
					3, 2, 1, 2, 2, 4, 3, 2, 7, 3 };
			for (int i = 0; i < roadName.length; i++) {
				subStreets.add(new SubStreet(roadName[i], SubRoadName[i], roadLength[i]));

			}
		
			
		//-----------------------------------------------------------------------------
			
			Khaled
		
	      //-----------------------------------------------------------------------------
	      //-----------------------------------------------------------------------------
			
			Mohammed
		
	      //-----------------------------------------------------------------------------
	      //-----------------------------------------------------------------------------
			
			Abdulqader
		
	      //-----------------------------------------------------------------------------

		}
	}

}
