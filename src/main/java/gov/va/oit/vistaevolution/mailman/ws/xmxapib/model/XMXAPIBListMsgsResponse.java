package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPIBListMsgsResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListMsgsResponse extends AbstractVistaResponse { 

	public XMXAPIBListMsgsResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXAPIBListMsgsResponse(String rr, List<String> errMessages) { 
		this.rawResponse = rr;
		this.errors = errMessages;
	}

	@XmlElementWrapper(name = "listMsgsLst")
	@XmlElement(name = "listMsgsLstElement", required = false)
	private List<XMXAPIBListMsgsEntry> listMsgsLst;

	public List<XMXAPIBListMsgsEntry> getListMsgsLst() { 
		return this.listMsgsLst;
	}
	public void setListMsgsLst(List<XMXAPIBListMsgsEntry> lvListMsgsLst) { 
		this.listMsgsLst = lvListMsgsLst;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("listMsgsLst ==> " + StrUtils.listToString(this.listMsgsLst) + "\n");
		sb.append("errors ==> " + StrUtils.listToString(this.errors) + "\n");
		sb.append("rawResponse ==> " + this.rawResponse + "\n");
		return sb.toString();
	}

}
