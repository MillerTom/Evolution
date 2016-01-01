package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXUtil2DateResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2DateResponse extends AbstractVistaResponse { 

	@XmlElement(required = false)
	private String msgDate;
	
	
	
	
	public XMXUtil2DateResponse() {
		super();
		this.errors = new ArrayList<String>();
	}


	public XMXUtil2DateResponse(String msgDate) {
		super();
		this.msgDate = msgDate;
	}


	public XMXUtil2DateResponse(String msgDate, List<String> errMsgs2) {
		this.msgDate = msgDate;
		this.errors = errMsgs2;
	}


	public String getMsgDate() {
		return msgDate;
	}


	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}
	
}
