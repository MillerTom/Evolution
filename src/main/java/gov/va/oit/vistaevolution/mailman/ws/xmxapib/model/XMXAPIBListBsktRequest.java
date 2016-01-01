package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.util.StrUtils;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPIBListBskt")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListBsktRequest extends AbstractXMXAPIBRequest{ 

	public XMXAPIBListBsktRequest() { 
		super();
	}

	@XmlElement(name = "xmFlags", required = false)
	private String xmFlags;
	@XmlElement(name = "xmAmt", required = false)
	private String xmAmt;
	@XmlElementWrapper(name = "xmStart")
	@XmlElement(name = "xmStartElement", required = false)
	private List<String> xmStart;
	@XmlElement(name = "xmPart", required = false)
	private String xmPart;

	public String getXmFlags() { 
		return this.xmFlags;
	}
	public void setXmFlags(String lvXmFlags) { 
		this.xmFlags = lvXmFlags;
	}
	public String getXmAmt() { 
		return this.xmAmt;
	}
	public void setXmAmt(String lvXmAmt) { 
		this.xmAmt = lvXmAmt;
	}
	public List<String> getXmStart() { 
		return this.xmStart;
	}
	public void setXmStart(List<String> lvXmStart) { 
		this.xmStart = lvXmStart;
	}
	public String getXmPart() { 
		return this.xmPart;
	}
	public void setXmPart(String lvXmPart) { 
		this.xmPart = lvXmPart;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("xmDuz ==> " + this.xmDuz + "\n");
		sb.append("xmFlags ==> " + this.xmFlags + "\n");
		sb.append("xmAmt ==> " + this.xmAmt + "\n");
		sb.append("xmStart ==> " + StrUtils.listToString(this.xmStart) + "\n");
		sb.append("xmPart ==> " + this.xmPart + "\n");
		return sb.toString();
	}

}
