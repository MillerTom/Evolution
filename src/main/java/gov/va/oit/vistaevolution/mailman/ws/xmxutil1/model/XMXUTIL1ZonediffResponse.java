/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1ZonediffResponse {

	/**
	 * 
	 * hmList :
	 * 
	 * Array contains returned number of hours and minutes difference between
	 * the input and the local time zone.
	 * 
	 * errors :
	 * 
	 * Array that should receive any error messages returned!
	 * 
	 */

	@XmlElementWrapper(name = "hmList")
	@XmlElement(name = "entry", required = false)
	private List<String> hmList;

	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> errors;

	/**
	 * No Arguments Constructor.
	 */
	public XMXUTIL1ZonediffResponse() {
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param errors
	 * @param hmList
	 */
	public XMXUTIL1ZonediffResponse(List<String> hmList, List<String> errors) {
		this.hmList = hmList;
		this.errors = errors;
	}

	/**
	 * @return the hmList
	 */
	public List<String> getHmList() {
		return hmList;
	}

	/**
	 * @param hmList
	 *            the hmList to set
	 */
	public void setHmList(List<String> hmList) {
		this.hmList = hmList;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "XMXUTIL1ZonediffResponse [hmList=" + hmList + ", errors"
				+ errors + "]";
	}
}
