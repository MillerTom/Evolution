/**
 *
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Kill Entry in Sign-on Log
 * Output Parameters Class:
 * 
 * ret:         (Required) Returns 1.  The return value has 
 *              no significance.
 *              
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSKAAJSignoffResponse extends AbstractVistaResponse {

	@XmlElement(name = "ret", required = true)
	private String ret;

	public XUSKAAJSignoffResponse() {
		super();
	}

	public XUSKAAJSignoffResponse(final String ret) {
		super();
		this.ret = ret;
	}

	public String getRet() {
		return this.ret;
	}

	public void setRet(final String ret) {
		this.ret = ret;
	}

}
