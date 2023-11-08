import java.io.Serializable;

public class gameFileObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1315069472434509271L;
	String companyString ="";
	String gameNameString="";
	Boolean adventureBoolean=false;
	Boolean actionBoolean = false;
	Boolean puzzleBoolean=false;
	Integer lengthInteger =0;
	String descriptionString;
	Boolean USABoolean=false;
	Boolean JapanBoolean = false;
	Boolean CanadaBoolean=false;
	
	
	public gameFileObject(String companyString, String gameNameString,
			Boolean adventureBoolean, Boolean actionBoolean, Boolean puzzleBoolean, Integer lengthInteger,
			String descriptionString, Boolean uSABoolean, Boolean japanBoolean, Boolean canadaBoolean) {
		super();
		this.companyString = companyString;
		this.gameNameString = gameNameString;
		this.adventureBoolean = adventureBoolean;
		this.actionBoolean = actionBoolean;
		this.puzzleBoolean = puzzleBoolean;
		this.lengthInteger = lengthInteger;
		this.descriptionString = descriptionString;
		USABoolean = uSABoolean;
		JapanBoolean = japanBoolean;
		CanadaBoolean = canadaBoolean;
	}
	
	public String getCompanyString() {
		return companyString;
	}
	public void setCompanyString(String companyString) {
		this.companyString = companyString;
	}
	public String getGameNameString() {
		return gameNameString;
	}
	public void setGameNameString(String gameNameString) {
		this.gameNameString = gameNameString;
	}
	public Boolean getAdventureBoolean() {
		return adventureBoolean;
	}
	public void setAdventureBoolean(Boolean adventureBoolean) {
		this.adventureBoolean = adventureBoolean;
	}
	public Boolean getActionBoolean() {
		return actionBoolean;
	}
	public void setActionBoolean(Boolean actionBoolean) {
		this.actionBoolean = actionBoolean;
	}
	public Boolean getPuzzleBoolean() {
		return puzzleBoolean;
	}
	public void setPuzzleBoolean(Boolean puzzleBoolean) {
		this.puzzleBoolean = puzzleBoolean;
	}
	public Integer getLengthInteger() {
		return lengthInteger;
	}
	public void setLengthInteger(Integer lengthInteger) {
		this.lengthInteger = lengthInteger;
	}
	public String getDescriptionString() {
		return descriptionString;
	}
	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}
	public Boolean getUSABoolean() {
		return USABoolean;
	}
	public void setUSABoolean(Boolean uSABoolean) {
		USABoolean = uSABoolean;
	}
	public Boolean getJapanBoolean() {
		return JapanBoolean;
	}
	public void setJapanBoolean(Boolean japanBoolean) {
		JapanBoolean = japanBoolean;
	}
	public Boolean getCanadaBoolean() {
		return CanadaBoolean;
	}
	public void setCanadaBoolean(Boolean canadaBoolean) {
		CanadaBoolean = canadaBoolean;
	}
	
	
	
	

}
