/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * 
 * XMWSOA GET NET NAME
 * 
 * This RPC returns network name of user, including @site name.  If there's
 * an error, it returns an error message.
 * 
 * Input Parameters:
 * 
 * 		XMDUZ		(Required) User DUZ or any string.
 * 
 * Response:
 * 		Returns the user's Network Name and Domain name (i.e., @site name).
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNetNameRequest {

	@XmlElement(required = true)
	private String xmDuz;

	public XMXUTILNetNameRequest() {
		super();
	}

	public XMXUTILNetNameRequest(String xmDuz) {
		super();
		this.xmDuz = xmDuz;
	}

	/**
	 * @return the xmDuz
	 */
	public String getXmDuz() {
		return xmDuz;
	}

	/**
	 * @param xmDuz the xmDuz to set
	 */
	public void setXmDuz(String xmDuz) {
		this.xmDuz = xmDuz;
	}

}
