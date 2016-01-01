package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIEChkResponse {

	/**
	 * data :
	 * 
	 * the Internal Entry Number (IEN) of a single record entry in a file based
	 * on input value(s).
	 * 
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 */
	@XmlElement(required = false)
	private List<String> data;

	public DIEChkResponse() {
		super();
	}

	public DIEChkResponse(List<String> data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}

}
