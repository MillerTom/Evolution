package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECBcastRequest {

	@XmlElement( required = true)
	private String msgId;
	
	public XMXSECBcastRequest() {
		super();
	}
	public XMXSECBcastRequest(String msgId) {
		super();
		this.msgId = msgId;
	}
	
	
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
