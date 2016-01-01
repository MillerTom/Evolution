/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1;

/**
 * Place holder object for user token
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 */
public class UserToken {

	/**Social Security Number*/
	 private String ssn;
	 /**User's Name*/
	 private String name;
	 /**Station's Name*/
	 private String stationName;
	 /**Station Number - three digit number, sometimes followed by an alpha character*/
	 private String stationNum;
	 /**Local User ID Number, aka an Internal Entry Number (IEN) */
	 private String duz;
	 /**User's Telephone Number*/
	 private String teleNum;
	 /**VA-wide Person Identifier*/
	 private String vpid;
	 
	 
	/**
	 * creates an empty User Token object
	 */
	public UserToken() {
		ssn = "";
		name = "";
		stationName = "";
		stationNum = "";
		duz = "";
		teleNum = "";
		vpid = "";
	}
	
	/**
	 * creates an empty User Token object
	 * @param (String) ssn - social security number
	 * @param (String) name - user name
	 * @param (String) stationName - station name
	 * @param (String) stationNum - station number
	 * @param (String) duz - internal entry identification number
	 * @param (String) teleNum - user telephone number
	 * @param (String) vpid - VA-wide person identifier
	 */
	public UserToken(String ssn, String name, String stationName, String stationNum, String duz, String teleNum, String vpid) {
		this.ssn = ssn;
		this.name = name;
		this.stationName= stationName;
		this.stationNum = stationNum;
		this.duz = duz;
		this.teleNum = teleNum;
		this.vpid = vpid;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the stationNum
	 */
	public String getStationNum() {
		return stationNum;
	}

	/**
	 * @param stationNum the stationNum to set
	 */
	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}

	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz the duz to set
	 */
	public void setDuz(String duz) {
		this.duz = duz;
	}

	/**
	 * @return the teleNum
	 */
	public String getTeleNum() {
		return teleNum;
	}

	/**
	 * @param teleNum the teleNum to set
	 */
	public void setTeleNum(String teleNum) {
		this.teleNum = teleNum;
	}

	/**
	 * @return the vpid
	 */
	public String getVpid() {
		return vpid;
	}

	/**
	 * @param vpid the vpid to set
	 */
	public void setVpid(String vpid) {
		this.vpid = vpid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserToken [toString()=" + super.toString() + "]";
	}
	
	

}
