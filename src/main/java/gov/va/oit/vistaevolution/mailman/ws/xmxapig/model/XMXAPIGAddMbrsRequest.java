/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIGAddMbrsRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String duz;

	@XmlElement(required = true)
	private String xmDuz;

	@XmlElementWrapper(required = true, name = "xmGrps")
	@XmlElement(required = true, name = "xmGrp")
	private List<XMXAPIGListEntry> xmGrp;

	@XmlElementWrapper(required = true, name = "xmMbrs")
	@XmlElement(required = true, name = "xmMbr")
	private List<XMXAPIGListEntry> xmMbr;

	@XmlElementWrapper(required = false, name = "xmInstrs")
	@XmlElement(required = false, name = "xmInstr")
	private List<XMXAPIGListEntry> xmInstr;

	public String getDuz() {
		return duz;
	}

	public void setDuz(String duz) {
		this.duz = duz;
	}

	public String getXmDuz() {
		return xmDuz;
	}

	public void setXmDuz(String xmDuz) {
		this.xmDuz = xmDuz;
	}

	public List<XMXAPIGListEntry> getXmGrp() {
		return xmGrp;
	}

	public void setXmGrp(List<XMXAPIGListEntry> xmGrp) {
		this.xmGrp = xmGrp;
	}

	public List<XMXAPIGListEntry> getXmMbr() {
		return xmMbr;
	}

	public void setXmMbr(List<XMXAPIGListEntry> xmMbr) {
		this.xmMbr = xmMbr;
	}

	public List<XMXAPIGListEntry> getXmInstr() {
		return xmInstr;
	}

	public void setXmInstr(List<XMXAPIGListEntry> xmInstr) {
		this.xmInstr = xmInstr;
	}
}
