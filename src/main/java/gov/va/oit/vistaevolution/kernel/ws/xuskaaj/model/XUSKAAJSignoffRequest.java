/**
 *
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Kill Entry in Sign-on Log
 * Input Parameters Class:
 * 
 * da:       (Required, Sequence = 1) The DA (IEN) of 
 *           the user's signon log entry. 
 * 
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSKAAJSignoffRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String da;

	public XUSKAAJSignoffRequest() {
		super();
	}

	public XUSKAAJSignoffRequest(final String da) {
		super();
		this.da = da;
	}

	public String getDa() {
		return this.da;
	}

	public void setDa(final String da) {
		this.da = da;
	}

}
