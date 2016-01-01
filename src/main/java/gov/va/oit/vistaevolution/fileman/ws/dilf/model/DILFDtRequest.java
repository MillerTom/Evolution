package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDtRequest extends AbstractVistaRequest {

	/**
	 * flags:
	 * 
	 * (Optional) Flags to control processing of user input and the type of
	 * output returned.
	 * 
	 * inDate:
	 * 
	 * (Required) Date input as entered by the user in any of the formats known
	 * to VA FileMan.
	 * 
	 * limit:
	 * 
	 * (Optional) A value equal to a date/time in VA FileMan internal format or
	 * NOW.
	 * 
	 */

	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = false)
	private List<String> flags;
	@XmlElement(required = true)
	private String inDate;
	@XmlElement(required = false)
	private String limit;

	/**
	 * No Arguments Constructor
	 */
	public DILFDtRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param flags
	 * @param inDate
	 * @param limit
	 */
	public DILFDtRequest(List<String> flags, String inDate, String limit) {
		super();
		this.flags = flags;
		this.inDate = inDate;
		this.limit = limit;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param inDate
	 */
	public DILFDtRequest(String inDate) {
		super();
		this.inDate = inDate;
	}

	/**
	 * @return the flags
	 */
	public List<String> getFlags() {
		return flags;
	}

	/**
	 * @param flags
	 *            the flags to set
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	/**
	 * @return the inDate
	 */
	public String getInDate() {
		return inDate;
	}

	/**
	 * @param inDate
	 *            the inDate to set
	 */
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

}
