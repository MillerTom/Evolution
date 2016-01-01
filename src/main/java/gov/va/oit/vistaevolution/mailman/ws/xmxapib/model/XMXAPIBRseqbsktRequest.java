/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBRseqbsktRequest extends AbstractXMXAPIBRequest {

    @XmlElement(required = true)
    private String xmk;

	public XMXAPIBRseqbsktRequest() {
		super();
	}

	public XMXAPIBRseqbsktRequest(String duz, String xmDuz, String xmk) {
		super();
		this.duz = duz;
		this.xmDuz = xmDuz;
		this.xmk = xmk;
	}

	public String getXmk() {
		return xmk;
	}

	public void setXmk(String xmk) {
		this.xmk = xmk;
	}
	
}
