package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1CopyRecpResponse extends AbstractXMXSEC1Response {

	public XMXSEC1CopyRecpResponse() { 
		super();
	}

	public XMXSEC1CopyRecpResponse(String msgOk2, List<String> errMsgs) {
		super(errMsgs);
		this.msgOK = msgOk2;
	}

	@XmlElement(name = "msgOK", required = false)
	private String msgOK;
	@XmlElementWrapper(name = "targetRoot")
	@XmlElement(name = "targetRoot", required = false)
	private List<String> targetRoot;

	public String getMsgOK() { 
		return this.msgOK;
	}
	public void setMsgOK(String lvMsgOK) { 
		this.msgOK = lvMsgOK;
	}
	public List<String> getTargetRoot() { 
		return this.targetRoot;
	}
	public void setTargetRoot(List<String> lvTargetRoot) { 
		this.targetRoot = lvTargetRoot;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("msgOK ==> " + this.msgOK + "\n");
		sb.append("targetRoot ==> " + this.targetRoot + "\n");
		return sb.toString();
	}

}
