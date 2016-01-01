package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class XMXAPILateMsgsResponse extends AbstractVistaResponse {

		
	public XMXAPILateMsgsResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXAPILateMsgsResponse(String rr, List<String> errMessages) { 
		this.rawResponse = rr;
		this.errors = errMessages;
	}

	public XMXAPILateMsgsResponse(String mvMsgResults) {
		this.moveResults = mvMsgResults;
	}

	@XmlElement(name = "moveResults", required = true)
	private String moveResults;

	public String getMoveResults() { 
		return this.moveResults;
	}
	public void setMoveResults(String lvMoveResults) { 
		this.moveResults = lvMoveResults;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("moveResults ==> " + this.moveResults + "\n");
		sb.append("errors ==> " + StrUtils.listToString(this.errors) + "\n");
		return sb.toString();
	}

}
