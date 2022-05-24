package clock;
import java.util.ArrayList;
public class SubStreet {
	// Main street name
	private String mainS;
	// Sub Street name
	private String name;
	// all adjacent sub streets
	private ArrayList<SubStreet> adjacentSubStreets = new ArrayList<>();
	// length of sub street
	public int length;
	// Traffic percent on each sub street
	public SubStreet(String mainS,String name, int length) {
		this.name = name;
		this.length = length;
		this.mainS = mainS;
	}
	// add adjacent sub street
	public void addSubStreet(SubStreet s) {
		adjacentSubStreets.add(s);
	}
	public String getName() {
		return name;
	}
	public String getMainName() {
		return mainS;
	}
	public double getTrafficPercent() {
		return 1 + Math.random()*0.5;	
	}
	public ArrayList<SubStreet> getAdjSub() {
		return adjacentSubStreets;
	}
}
