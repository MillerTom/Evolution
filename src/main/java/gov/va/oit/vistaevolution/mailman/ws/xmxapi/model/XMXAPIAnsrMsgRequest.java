package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIAnsrMsgRequest extends AbstractXMXAPISendMsgRequest {

	public XMXAPIAnsrMsgRequest() {
		super();
	}

	@XmlElement(name = "xmk", required = false)
	private String xmk;
	
	@XmlElement(name = "xmkz", required = false)
	private String xmkz;


	public String getXmk() {
		return xmk;
	}

	public void setXmk(String xmk) {
		this.xmk = xmk;
	}

	public String getXmkz() {
		return xmkz;
	}

	public void setXmkz(String xmkz) {
		this.xmkz = xmkz;
	}

}
