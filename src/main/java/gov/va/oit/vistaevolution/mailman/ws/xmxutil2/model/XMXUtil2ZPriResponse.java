package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import java.util.ArrayList;
import java.util.List;

import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXUtil2ZPriResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZPriResponse extends AbstractVistaResponse { 

	public XMXUtil2ZPriResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXUtil2ZPriResponse(String rr, List<String> errMsgs) {
		this.rawResponse = rr;
		this.errors = errMsgs;
	}

	public XMXUtil2ZPriResponse(String rawResponse) {
		this.rawResponse = rawResponse;
		this.errors = new ArrayList<String>();
	}

	@XmlElement(name = "msgIsPriority", required = false)
	private String msgIsPriority;

	
	public String getMsgIsPriority() {
		return msgIsPriority;
	}

	public void setMsgIsPriority(String msgIsPriority) {
		this.msgIsPriority = msgIsPriority;
	}
	
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("msgIsPriority ==> " + this.msgIsPriority + "\n");
		sb.append("errors ==> " + StrUtils.listToString(this.errors) + "\n");
		return sb.toString();
	}

}
