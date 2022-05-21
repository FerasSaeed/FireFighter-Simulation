
package clock;

import java.util.ArrayList;
import java.util.Collections;

public class Route {

	String route;
	double length;

	// we use these so we can generate 100 routes and determine the optimal route
	public ArrayList<SubStreet> allRoutes = new ArrayList<>();

	public ArrayList<SubStreet> optimalRoute = new ArrayList<>();


	public void makeRoute(SubStreet start, SubStreet end) {

		route = start.getName() + " ";
		allRoutes.add(start);

		ArrayList<SubStreet> s = start.getAdjSub();
		int b = 1;
		String optimalR = "";
		for (int e = 0; e < 100; e++) {
			while (true) {
				for (int el = 0; el < s.size(); el++) {
					if (s.get(el) == end) {
						b = 0;
						break;
					}

				}
				Collections.shuffle(s);
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
				if (b == 0) {
					if (!route.contains(end.getName()))
						route = route + end.getName() + " ";
					if (!allRoutes.contains(end)) {
						allRoutes.add(end);
					}
					if (optimalR.length() == 0 || optimalR.length() > route.length()) {

						optimalR = route;

						optimalRoute = new ArrayList<>(allRoutes);
					}
					break;
				}

			}
			s = start.getAdjSub();
			route = start.getName() + " ";
			allRoutes.clear();
			allRoutes.add(start);

			b = 1;
		}
		for (SubStreet op : optimalRoute) {
			length = length + op.length * op.getTrafficPercent();
		}
	}

	public ArrayList<SubStreet> getRoute() {
		return optimalRoute;
	}

	public double getLength() {
		return length;
	}
}
