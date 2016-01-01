package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXSEC1ZssPrivResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1ZssPrivResponse extends AbstractVistaResponse { 

	public XMXSEC1ZssPrivResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXSEC1ZssPrivResponse(String rr, List<String> errMessages) { 
		this.rawResponse = rr;
		this.errors = errMessages;
	}

	@XmlElement(name = "userCanDoSuperSearch", required = false)
	private String userCanDoSuperSearch;

	public String getUserCanDoSuperSearch() { 
		return this.userCanDoSuperSearch;
	}
	public void setUserCanDoSuperSearch(String lvUserCanDoSuperSearch) { 
		this.userCanDoSuperSearch = lvUserCanDoSuperSearch;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("userCanDoSuperSearch ==> " + this.userCanDoSuperSearch + "\n");
		return sb.toString();
	}

}

