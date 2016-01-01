package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.util.StrUtils;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class XMXAPILateMsgsRequest extends AbstractXMXAPIRequest {

	public XMXAPILateMsgsRequest() {
	}

	public XMXAPILateMsgsRequest(String duz, String xmDuz) {
		super(duz, xmDuz);
	}
	
	

	@XmlElement(name = "xmk", required = true)
	private String xmk;
	
	private HashMap<Object,Object> xmkza = new HashMap<Object, Object>();
	@XmlElementWrapper(name = "xmInstr")
	@XmlElement(name = "xmInstrElement", required = false)
	private List<String> xmInstr;

	public String getXmk() { 
		return this.xmk;
	}
	public void setXmk(String lvXmk) { 
		this.xmk = lvXmk;
	}
	
	@XmlElementWrapper(name = "xmkza", required=true)
	public HashMap<Object,Object> getXmkza() { 
		return this.xmkza;
	}
	public void setXmkza(HashMap<Object,Object> lvXmkza) { 
		this.xmkza = lvXmkza;
	}
	public List<String> getXmInstr() { 
		return this.xmInstr;
	}
	public void setXmInstr(List<String> lvXmInstr) { 
		this.xmInstr = lvXmInstr;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("duz ==> " + this.getDuz() + "\n");
		sb.append("xmk ==> " + this.getXmDuz() + "\n");
		sb.append("xmk ==> " + this.xmk + "\n");
		sb.append("xmkza ==> " + StrUtils.mapToString(this.xmkza) + "\n");
		sb.append("xmInstr ==> " + StrUtils.listToString(this.xmInstr) + "\n");
		return sb.toString();
	}

	
}
