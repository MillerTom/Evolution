package gov.va.oit.vistaevolution.fileman.ws.ddr2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DDR2Find1CRequest {

	/**
	 * DDR FIND1
	 * 
	 * 
	 * This function returns the internal entry number of a record using
	 * $$FIND1^DIC.
	 * 
	 * Input Parameters:
	 * 
	 * This array contains the following parameters necessary to call $$FIND1^DIC.
	 * 		"FILE" the file or subfile number to search
	 * 		"IENS" the IENS that identifies the subfile if FILE is a subfile number
	 *      "FLAGS" possible values include:
	 *           A  allow pure numeric input to always be tried as an IEN
	 *           M  multiple index allowed
	 *           O  only find an exact match if possible
	 *           Q  quick lookup
	 *           X  exact match only
	 *           R  record the ien in ^DISV via RECALL^DILFD
	 *      "VALUE" Value to look up
	 *      "XREF" the indexes that would be searched for a match
	 *      "SCREEN" screen to apply to the record found
	 *      
	 *  Response:
	 *  This parameter returns a valid internal record number if a match
	 *  is found, a 0 if no match was found or a -1 if an error occurred.
	 *  (For now, this is 'single value'.  It will return the error array
	 *  later.)
	 *  
	 */
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = false)
	private String iens;
	@XmlElement(required = true)
	private String value;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = true)
	private List<String> flags;
	@XmlElement(required = false)
	private String xref;
	@XmlElement(required = false)
	private String screen;

	public DDR2Find1CRequest() {
	}

	/**
	 * Constructor for all fields
	 * @param file
	 * @param iens
	 * @param value
	 * @param xref
	 * @param screen
	 * @param flags
	 */
	public DDR2Find1CRequest(String file, String iens, String value, String xref, String screen, List<String> flags) {
		this.file = file;
		this.iens = iens;
		this.value = value;
		this.xref = xref;
		this.screen = screen;
		this.flags = flags;
	}

	/**
	 * Constructor for required fields only
	 * @param file
	 * @param value
	 * @param flags
	 */
	public DDR2Find1CRequest(String file, String value, List<String> flags) {
		this.file = file;
		this.value = value;
		this.flags = flags;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @return the iens
	 */
	public String getIens() {
		return iens;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the flags
	 */
	public List<String> getFlags() {
		return flags;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @param iens
	 *            the iens to set
	 */
	public void setIens(String iens) {
		this.iens = iens;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @param flags
	 *            the flags to set
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	/**
	 * @return the xref
	 */
	public String getXref() {
		return xref;
	}

	/**
	 * @param xref the xref to set
	 */
	public void setXref(String xref) {
		this.xref = xref;
	}

	/**
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}

	/**
	 * @param screen the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "DDR2Find1CRequest [file=" + file + ", iens=" + iens
				+ ", value=" + value + ", flags=" + flags + ", xref=" + xref
				+ ", screen=" + screen + "]";
	}

}
