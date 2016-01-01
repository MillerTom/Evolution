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

@XmlRootElement(name = "XMXAPIBListBsktResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListBsktResponse extends AbstractVistaResponse { 

	public XMXAPIBListBsktResponse() { 
		super();
		this.errors = new ArrayList<String>();
	}

	public XMXAPIBListBsktResponse(String rr, List<String> errMessages) { 
		this.rawResponse = rr;
		this.errors = errMessages;
	}

	@XmlElementWrapper(name = "basketList")
	@XmlElement(name = "basketListElement", required = false)
	private List<XMXAPIBListBsktEntry> basketList;

	public List<XMXAPIBListBsktEntry> getBasketList() { 
		return this.basketList;
	}
	public void setBasketList(List<XMXAPIBListBsktEntry> lvBasketList) { 
		this.basketList = lvBasketList;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("basketList ==> " + StrUtils.listToString(this.basketList) + "\n");
		return sb.toString();
	}

}
