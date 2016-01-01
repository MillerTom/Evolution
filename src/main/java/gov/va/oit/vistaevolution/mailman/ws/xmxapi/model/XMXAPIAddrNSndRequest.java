package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIAddrNSndRequest extends AbstractXMXAPISendMsgRequest {

	public XMXAPIAddrNSndRequest() {
		super();
	}

	@XmlElement(name = "xmStrip", required = false)
	private String xmStrip;

	public String getXmStrip() {
		return xmStrip;
	}

	public void setXmStrip(String xmStrip) {
		this.xmStrip = xmStrip;
	}

}
