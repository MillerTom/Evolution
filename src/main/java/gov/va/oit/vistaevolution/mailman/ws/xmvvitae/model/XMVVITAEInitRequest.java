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
public class XMVVITAEInitRequest extends AbstractXMVVITAERequest {

	/**
	 * 
	 * duz:
	 * 
	 * User's DUZ
	 * 
	 * xmduz :
	 * 
	 * User (default) or surrogate DUZ.
	 * 
	 */

	/**
	 * No Arguments Constructor.
	 */
	public XMVVITAEInitRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param duz
	 * @param xmduz
	 */
	public XMVVITAEInitRequest(String duz, String xmduz) {
		super(duz, xmduz);
	}

}
