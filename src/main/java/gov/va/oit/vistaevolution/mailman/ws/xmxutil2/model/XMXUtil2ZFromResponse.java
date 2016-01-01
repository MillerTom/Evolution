package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import java.util.List;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZFromResponse extends AbstractVistaResponse {


	public XMXUtil2ZFromResponse() { 
		super();
	}

	public XMXUtil2ZFromResponse(String zfrom, List<String> errMsgs) {
		this.zfromInfo = zfrom;
		this.msgRoot = errMsgs;
	}

	@XmlElement(name = "zfromInfo", required = false)
	private String zfromInfo;
	
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	private List<String> msgRoot;

	public String getZfromInfo() { 
		return this.zfromInfo;
	}
	public void setZfromInfo(String lvZfromInfo) { 
		this.zfromInfo = lvZfromInfo;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("zfromInfo ==> " + this.zfromInfo + "\n");
		return sb.toString();
	}
	public List<String> getMsgRoot() {
		return msgRoot;
	}
	public void setMsgRoot(List<String> msgRoot) {
		this.msgRoot = msgRoot;
	}

}

