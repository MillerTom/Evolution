/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMVVITAEOtherRequest extends AbstractXMVVITAERequest {

	/**
	 * DUZ :
	 * 
	 * User's DUZ.
	 * 
	 * XMDUZ :
	 * 
	 * Surrogate DUZ.
	 * 
	 */

	/**
	 * No Arguments Constructor.
	 */
	public XMVVITAEOtherRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param duz
	 * @param xmduz
	 */
	public XMVVITAEOtherRequest(String duz, String xmduz) {
		super(duz, xmduz);
	}

}
