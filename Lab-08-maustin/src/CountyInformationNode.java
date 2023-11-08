
public class CountyInformationNode {
	public String date;
	public String county;
	public String state;
	public String FIPS;
	public String cases;
	public String deaths;
	
	@Override
	public String toString() {
		return "countyNYTData [date=" + date + ", county=" + county + ", state=" + state + ", FIPS=" + FIPS + ", cases="
				+ cases + ", deaths=" + deaths + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFIPS() {
		return FIPS;
	}

	public void setFIPS(String fIPS) {
		FIPS = fIPS;
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	public CountyInformationNode(String date, String county, String state, String fIPS, String cases, String deaths) {
		super();
		this.date = date;
		this.county = county;
		this.state = state;
		FIPS = fIPS;
		this.cases = cases;
		this.deaths = deaths;
	}
	
	

}
