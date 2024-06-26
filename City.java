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
		
			
// generate map by adding adjacent streets
			SubStreet sub0 = subStreets.get(0);
			ArrayList<SubStreet> subb0 = sub0.getAdjSub();

			subb0.add(subStreets.get(1));
			subb0.add(subStreets.get(13));
			subb0.add(subStreets.get(6));
			SubStreet sub1 = subStreets.get(1);

			ArrayList<SubStreet> subb1 = sub1.getAdjSub();

			subb1.add(subStreets.get(0));
			subb1.add(subStreets.get(2));
			subb1.add(subStreets.get(28));

			SubStreet sub2 = subStreets.get(2);

			ArrayList<SubStreet> subb2 = sub2.getAdjSub();

			subb2.add(subStreets.get(1));
			subb2.add(subStreets.get(3));
			subb2.add(subStreets.get(25));
			subb2.add(subStreets.get(28));
			SubStreet sub3 = subStreets.get(3);

			ArrayList<SubStreet> subb3 = sub3.getAdjSub();

			subb3.add(subStreets.get(2));
			subb3.add(subStreets.get(4));
			subb3.add(subStreets.get(25));
			subb3.add(subStreets.get(15));
			SubStreet sub4 = subStreets.get(4);

			ArrayList<SubStreet> subb4 = sub4.getAdjSub();

			subb4.add(subStreets.get(3));
			subb4.add(subStreets.get(5));
			subb4.add(subStreets.get(15));
			subb4.add(subStreets.get(20));			
			SubStreet sub5 = subStreets.get(5);

			ArrayList<SubStreet> subb5 = sub5.getAdjSub();

			subb5.add(subStreets.get(4));
			subb5.add(subStreets.get(16));
			subb5.add(subStreets.get(20));
			SubStreet sub6 = subStreets.get(6);

			ArrayList<SubStreet> subb6 = sub6.getAdjSub();

			subb6.add(subStreets.get(0));
			subb6.add(subStreets.get(7));
			subb6.add(subStreets.get(13));
			subb6.add(subStreets.get(30));
			SubStreet sub7 = subStreets.get(7);

			ArrayList<SubStreet> subb7 = sub7.getAdjSub();

			subb7.add(subStreets.get(6));
			subb7.add(subStreets.get(8));
			subb7.add(subStreets.get(27));
			subb7.add(subStreets.get(30));

			SubStreet sub8 = subStreets.get(8);
			ArrayList<SubStreet> subb8 = sub8.getAdjSub();

			subb8.add(subStreets.get(7));
			subb8.add(subStreets.get(9));
			subb8.add(subStreets.get(27));
			subb8.add(subStreets.get(23));
			subb8.add(subStreets.get(22));

			SubStreet sub9 = subStreets.get(9);
			ArrayList<SubStreet> subb9 = sub9.getAdjSub();

			subb9.add(subStreets.get(8));
			subb9.add(subStreets.get(18));
			subb9.add(subStreets.get(19));
			subb9.add(subStreets.get(23));
			subb9.add(subStreets.get(22));

			SubStreet sub10 = subStreets.get(10);
			ArrayList<SubStreet> subb10 = sub10.getAdjSub();

			subb10.add(subStreets.get(13));
			subb10.add(subStreets.get(14));
			subb10.add(subStreets.get(24));
			subb10.add(subStreets.get(23));

			SubStreet sub11 = subStreets.get(11);
			ArrayList<SubStreet> subb11 = sub11.getAdjSub();

			subb11.add(subStreets.get(14));
			subb11.add(subStreets.get(24));
			subb11.add(subStreets.get(12));

			SubStreet sub12 = subStreets.get(12);
			ArrayList<SubStreet> subb12 = sub12.getAdjSub();

			subb12.add(subStreets.get(11));
			subb12.add(subStreets.get(24));
			subb12.add(subStreets.get(19));

			SubStreet sub13 = subStreets.get(13);
			ArrayList<SubStreet> subb13 = sub13.getAdjSub();

			subb13.add(subStreets.get(0));
			subb13.add(subStreets.get(6));
			subb13.add(subStreets.get(10));
			subb13.add(subStreets.get(14));

			SubStreet sub14 = subStreets.get(14);
			ArrayList<SubStreet> subb14 = sub14.getAdjSub();

			subb14.add(subStreets.get(10));
			subb14.add(subStreets.get(13));
			subb14.add(subStreets.get(11));

			SubStreet sub15 = subStreets.get(15);
			ArrayList<SubStreet> subb15 = sub15.getAdjSub();

			subb15.add(subStreets.get(3));
			subb15.add(subStreets.get(4));
			subb15.add(subStreets.get(32));
			subb15.add(subStreets.get(33));

			SubStreet sub16 = subStreets.get(16);
			ArrayList<SubStreet> subb16 = sub16.getAdjSub();

			subb16.add(subStreets.get(17));
			subb16.add(subStreets.get(9));
			subb16.add(subStreets.get(34));

			SubStreet sub17 = subStreets.get(17);
			ArrayList<SubStreet> subb17 = sub17.getAdjSub();

			subb17.add(subStreets.get(16));
			subb17.add(subStreets.get(18));
			subb17.add(subStreets.get(34));
			subb17.add(subStreets.get(37));

			SubStreet sub18 = subStreets.get(18);
			ArrayList<SubStreet> subb18 = sub18.getAdjSub();

			subb18.add(subStreets.get(17));
			subb18.add(subStreets.get(19));
			subb18.add(subStreets.get(9));
			subb18.add(subStreets.get(37));

			SubStreet sub19 = subStreets.get(19);
			ArrayList<SubStreet> subb19 = sub19.getAdjSub();

			subb19.add(subStreets.get(18));
			subb19.add(subStreets.get(9));
			subb19.add(subStreets.get(12));

			SubStreet sub20 = subStreets.get(20);
			ArrayList<SubStreet> subb20 = sub20.getAdjSub();

			subb20.add(subStreets.get(5));
			subb20.add(subStreets.get(4));
			subb20.add(subStreets.get(34));
			subb20.add(subStreets.get(33));
			subb20.add(subStreets.get(21));


		
	      
			
		        SubStreet sub21 = subStreets.get(21);
			ArrayList<SubStreet> subb21 = sub21.getAdjSub();

			subb21.add(subStreets.get(20));
			subb21.add(subStreets.get(33));
			subb21.add(subStreets.get(34));
			subb21.add(subStreets.get(36));
			subb21.add(subStreets.get(22));
			subb21.add(subStreets.get(37));

			SubStreet sub22 = subStreets.get(22);
			ArrayList<SubStreet> subb22 = sub22.getAdjSub();

			subb22.add(subStreets.get(21));
			subb22.add(subStreets.get(23));
			subb22.add(subStreets.get(8));
			subb22.add(subStreets.get(36));
			subb22.add(subStreets.get(9));
			subb22.add(subStreets.get(37));

			SubStreet sub23 = subStreets.get(23);
			ArrayList<SubStreet> subb23 = sub23.getAdjSub();

			subb23.add(subStreets.get(22));
			subb23.add(subStreets.get(24));
			subb23.add(subStreets.get(8));
			subb23.add(subStreets.get(9));
			subb23.add(subStreets.get(10));

			SubStreet sub24 = subStreets.get(24);
			ArrayList<SubStreet> subb24 = sub24.getAdjSub();

			subb24.add(subStreets.get(23));
			subb24.add(subStreets.get(10));
			subb24.add(subStreets.get(11));
			subb24.add(subStreets.get(12));

			SubStreet sub25 = subStreets.get(25);
			ArrayList<SubStreet> subb25 = sub25.getAdjSub();

			subb25.add(subStreets.get(2));
			subb25.add(subStreets.get(3));
			subb25.add(subStreets.get(31));
			subb25.add(subStreets.get(26));
			subb25.add(subStreets.get(32));

			SubStreet sub26 = subStreets.get(26);
			ArrayList<SubStreet> subb26 = sub26.getAdjSub();

			subb26.add(subStreets.get(25));
			subb26.add(subStreets.get(27));
			subb26.add(subStreets.get(31));
			subb26.add(subStreets.get(32));
			subb26.add(subStreets.get(35));
			subb26.add(subStreets.get(36));

			SubStreet sub27 = subStreets.get(27);
			ArrayList<SubStreet> subb27 = sub27.getAdjSub();

			subb27.add(subStreets.get(26));
			subb27.add(subStreets.get(35));
			subb27.add(subStreets.get(36));
			subb27.add(subStreets.get(7));
			subb27.add(subStreets.get(8));

			SubStreet sub28 = subStreets.get(28);
			ArrayList<SubStreet> subb28 = sub28.getAdjSub();

			subb28.add(subStreets.get(1));
			subb28.add(subStreets.get(2));
			subb28.add(subStreets.get(29));
			subb28.add(subStreets.get(31));

		
			
​SubStreet sub29 = subStreets.get(29);
​​​ArrayList<SubStreet> subb29 = sub29.getAdjSub();
 
​​​subb29.add(subStreets.get(28));
​​​subb29.add(subStreets.get(30));
​​​subb29.add(subStreets.get(31));
​​​subb29.add(subStreets.get(35));
 
​​​SubStreet sub30 = subStreets.get(30);
​​​ArrayList<SubStreet> subb30 = sub30.getAdjSub();
 
​​​subb30.add(subStreets.get(6));
​​​subb30.add(subStreets.get(7));
​​​subb30.add(subStreets.get(29));
​​​subb30.add(subStreets.get(35));
 
​​​SubStreet sub31 = subStreets.get(31);
​​​ArrayList<SubStreet> subb31 = sub31.getAdjSub();
 
​​​subb31.add(subStreets.get(25));
​​​subb31.add(subStreets.get(26));
​​​subb31.add(subStreets.get(29));
​​​subb31.add(subStreets.get(28));
​​​subb31.add(subStreets.get(32));
 
​​​SubStreet sub32 = subStreets.get(32);
​​​ArrayList<SubStreet> subb32 = sub32.getAdjSub();
 
​​​subb32.add(subStreets.get(31));
​​​subb32.add(subStreets.get(33));
​​​subb32.add(subStreets.get(25));
​​​subb32.add(subStreets.get(26));
​​​subb32.add(subStreets.get(15));
 
​​​SubStreet sub33 = subStreets.get(33);
​​​ArrayList<SubStreet> subb33 = sub33.getAdjSub();
 
​​​subb33.add(subStreets.get(32));
​​​subb33.add(subStreets.get(34));
​​​subb33.add(subStreets.get(15));
​​​subb33.add(subStreets.get(20));
​​​subb33.add(subStreets.get(21));
 
​​​SubStreet sub34 = subStreets.get(34);
​​​ArrayList<SubStreet> subb34 = sub34.getAdjSub();
 
​​​subb34.add(subStreets.get(17));
​​​subb34.add(subStreets.get(16));
​​​subb34.add(subStreets.get(33));
​​​subb34.add(subStreets.get(20));
​​​subb34.add(subStreets.get(21));
 
​​​SubStreet sub35 = subStreets.get(35);
​​​ArrayList<SubStreet> subb35 = sub35.getAdjSub();
 
​​​subb35.add(subStreets.get(29));
​​​subb35.add(subStreets.get(30));
​​​subb35.add(subStreets.get(36));
​​​subb35.add(subStreets.get(26));
​​​subb35.add(subStreets.get(27));
 
​​​SubStreet sub36 = subStreets.get(36);
​​​ArrayList<SubStreet> subb36 = sub36.getAdjSub();
 
​​​subb36.add(subStreets.get(35));
​​​subb36.add(subStreets.get(37));
​​​subb36.add(subStreets.get(26));
​​​subb36.add(subStreets.get(27));
​​​subb36.add(subStreets.get(21));
​​​subb36.add(subStreets.get(22));
 
​​​SubStreet sub37 = subStreets.get(37);
​​​ArrayList<SubStreet> subb37 = sub37.getAdjSub();
 
​​​subb37.add(subStreets.get(36));
​​​subb37.add(subStreets.get(21));
​​​subb37.add(subStreets.get(22));
​​​subb37.add(subStreets.get(17));
​​​subb37.add(subStreets.get(18));

		}
	}

}
