package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFCrefRequest extends AbstractVistaRequest {

	/**
	 * openRoot:
	 * 
	 * (Required) An open root that is a global root ending in either an open
	 * parenthesis or a comma.
	 * 
	 */
	@XmlElement(required = true)
	private String openRoot;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DILFCrefRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param openRoot
	 */
	public DILFCrefRequest(String openRoot) {
		super();
		this.openRoot = openRoot;
	}

	/**
	 * @return the openRoot
	 */
	public String getOpenRoot() {
		return openRoot;
	}

	/**
	 * @param openRoot
	 *            the openRoot to set
	 */
	public void setOpenRoot(String openRoot) {
		this.openRoot = openRoot;
	}

}
