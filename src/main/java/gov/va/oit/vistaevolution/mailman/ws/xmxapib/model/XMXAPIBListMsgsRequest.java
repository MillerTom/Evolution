package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.util.StrUtils;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "XMXAPIBListMsgsRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListMsgsRequest extends AbstractXMXAPIBRequest {

	public XMXAPIBListMsgsRequest() { 
		super();
	}

	@XmlElement(name = "xmk", required = true)
	private String xmk;
	@XmlElement(name = "xmFlds", required = false)
	private String xmFlds;
	@XmlElement(name = "xmFlags", required = false)
	private String xmFlags;
	@XmlElement(name = "xmAmt", required = false)
	private String xmAmt;
	@XmlElementWrapper(name = "xmStart")
	@XmlElement(name = "xmStartElement", required = false)
	private List<String> xmStart;
	@XmlElement(name = "xmCrit", required = false)
	private List<Object> xmCrit;

	public String getXmk() { 
		return this.xmk;
	}
	public void setXmk(String lvXmk) { 
		this.xmk = lvXmk;
	}
	public String getXmFlds() { 
		return this.xmFlds;
	}
	public void setXmFlds(String lvXmFlds) { 
		this.xmFlds = lvXmFlds;
	}
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
	public List<Object> getXmCrit() {
		return xmCrit;
	}
	public void setXmCrit(List<Object> xmCrit) {
		this.xmCrit = xmCrit;
	}
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("xmk ==> " + this.xmk + "\n");
		sb.append("xmFlds ==> " + this.xmFlds + "\n");
		sb.append("xmFlags ==> " + this.xmFlags + "\n");
		sb.append("xmAmt ==> " + this.xmAmt + "\n");
		sb.append("xmStart ==> " + StrUtils.listToString(this.xmStart) + "\n");
		sb.append("xmCrit ==> " + this.xmCrit + "\n");
		return sb.toString();
	}
}
