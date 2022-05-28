
package FireFighter;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Generates routes between locations
 * @author Feras Alzahrani
 *
 */
public class Route {
//start location
	private SubStreet location;
	//string representing the route
	private String route;
	//length of the route
	private double length;
/**
 * Make a route between starting sub street and end sub street
 * @param start location of fire station
 * @param end location of incident
 */
	public Route(SubStreet start, SubStreet end) {
		location = start;
		makeRoute(start, end);}
	
	// we use these so we can generate 100 routes and determine the optimal route
	private ArrayList<SubStreet> allRoutes = new ArrayList<>();
	private ArrayList<SubStreet> optimalRoute = new ArrayList<>();

/**
 * Generates 200 routes and picks the best route
 * @param start location of fire station
 * @param end location of incident
 */
	public void makeRoute(SubStreet start, SubStreet end) {
//start route name
		route = start.getName() + " ";
		//add the start sub street to the all routes arraylist
		allRoutes.add(start);
//temporary list to be used in the loop
		ArrayList<SubStreet> s = start.getAdjSub();
		//integer to be used if a destination is reached
		int b = 1;
		//save optimal route here as a string
		String optimalR = "";
		for (int e = 0; e < 200; e++) {
			while (true) {
				for (int el = 0; el < s.size(); el++) {
					//if reached destination break
					if (s.get(el) == end) {
						b = 0;
						break;
					}

				}
				Collections.shuffle(s);
			//here we make sure not to repeat a sub street and also shuffle the array lists so we can try different routes
				if (!route.contains(s.get(0).getName())) {
					allRoutes.add(s.get(0));
					route = route + s.get(0).getName() + " ";
					s = s.get(0).getAdjSub();
				} else {
					Collections.shuffle(s);

					route = route + s.get(0).getName() + " ";
					allRoutes.add(s.get(0));
					s = s.get(0).getAdjSub();
				}
				//if b is 0 then we reached destination, break from loop after adding name of destination
				if (b == 0) {
					if (!route.contains(end.getName()))
						route = route + end.getName() + " ";
					if (!allRoutes.contains(end)) {
						allRoutes.add(end);
					}
					//here we see which route was the shortest 
					if (optimalR.length() == 0 || optimalR.length() > route.length()) {

						optimalR = route;

						optimalRoute = new ArrayList<>(allRoutes);
					}
					break;
				}

			}
			//reset all and start the loop again
			s = start.getAdjSub();
			route = start.getName() + " ";
			allRoutes.clear();
			allRoutes.add(start);

			b = 1;
		}
		//get the length of the best route
		for (SubStreet op : optimalRoute) {
			length = length + op.getLength() * op.getTrafficPercent();
		}
	}
/**
 * 
 * @return best route
 */
	public ArrayList<SubStreet> getRoute() {
		return optimalRoute;
	}
/**
 * 
 * @return route length after multiplication with traffic percentage
 */
	public double getLength() {
		return length;
	}
	/**
	 * 
	 * @return Fire station location
	 */
	public SubStreet getStartLocation() {return location;}
}
