
public class CountyMapNode {
	public int[] longitude;
	public int[] lattitude;
	public int FIPS;
	public int population;
	
	CountyMapNode()
	{
		
	}
	
	public int[] getLongitude() {
		return longitude;
	}
	public void setLongitude(int[] longitude) {
		this.longitude = longitude;
	}
	public int[] getLattitude() {
		return lattitude;
	}
	public void setLattitude(int[] lattitude) {
		this.lattitude = lattitude;
	}
	public int getFIPS() {
		return FIPS;
	}
	public void setFIPS(int fIPS) {
		FIPS = fIPS;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}
