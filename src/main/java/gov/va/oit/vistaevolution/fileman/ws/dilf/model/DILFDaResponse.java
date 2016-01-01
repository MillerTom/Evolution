package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

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
public class DILFDaResponse extends AbstractVistaResponse {

	/**
	 * da :
	 * 
	 * array with the record numbers from the IENS-- the array is structured
	 * like the traditional VA FileMan DA() array.
	 * 
	 */
	@XmlElementWrapper(name = "recordNumbers")
	@XmlElement(name = "recordNumber", required = false)
	private List<String> da;

	/**
	 * No Arguments Constructor.
	 * 
	 */
	public DILFDaResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param da
	 */
	public DILFDaResponse(List<String> da) {
		super();
		this.da = da;
	}

	/**
	 * @return the da
	 */
	public List<String> getDa() {
		return da;
	}

	/**
	 * @param da
	 *            the da to set
	 */
	public void setDa(List<String> da) {
		this.da = da;
	}

}
