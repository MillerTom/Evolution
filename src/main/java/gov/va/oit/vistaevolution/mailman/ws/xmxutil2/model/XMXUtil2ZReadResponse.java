package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXUtil2ZReadResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZReadResponse extends AbstractVistaResponse { 

	public XMXUtil2ZReadResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXUtil2ZReadResponse(String rr, List<String> errMessages) { 
		this.rawResponse = rr;
		this.errors = errMessages;
	}

	public XMXUtil2ZReadResponse(String rr) {
		this.rawResponse = rr;
		this.errors = new ArrayList<String>();
	}

	@XmlElement(name = "numResponsesRead", required = false)
	private String numResponsesRead;

	public String getNumResponsesRead() { 
		return this.numResponsesRead;
	}
	public void setNumResponsesRead(String lvNumResponsesRead) { 
		this.numResponsesRead = lvNumResponsesRead;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("numResponsesRead ==> " + this.numResponsesRead + "\n");
		return sb.toString();
	}

}