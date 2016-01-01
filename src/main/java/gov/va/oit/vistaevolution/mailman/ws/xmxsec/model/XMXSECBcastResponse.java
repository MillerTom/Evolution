package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXSECBcastResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECBcastResponse extends AbstractXMXSECResponse {
	
	@XmlElementWrapper(name = "targetRoot")
	@XmlElement(name = "targetRootElement", required = false)
	private List<String> targetRoot;
	
	@XmlElement(name = "msgWasBroadCast", required = true)
	private String msgWasBroadCast;
	
	// constructors
	public XMXSECBcastResponse() {
		super();
		this.msgRoot = new ArrayList<String>();
	}

	public XMXSECBcastResponse(List<String> msgRoot) {
		super(msgRoot);
	}
	public XMXSECBcastResponse(String msgBcast, List<String> tRoot) {
		this.msgWasBroadCast = msgBcast;
		this.targetRoot = tRoot;
		this.msgRoot = tRoot;
	}
	
	
	public List<String> getTargetRoot() {
		return targetRoot;
	}

	public void setTargetRoot(List<String> targetRoot) {
		this.targetRoot = targetRoot;
	}

	public String getMsgWasBroadCast() {
		return msgWasBroadCast;
	}

	public void setMsgWasBroadCast(String msgWasBroadCast) {
		this.msgWasBroadCast = msgWasBroadCast;
	}

}
