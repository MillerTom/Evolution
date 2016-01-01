/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIGJoinRequest {
	
	@XmlElement(required = true)
	private String duz;

	@XmlElement(required = true)
	private String xmduz;
	
	@XmlElement(required = true)
	private String xmgroup;
	
	@XmlElementWrapper(name = "xminstr")
	@XmlElement(name = "xminstr-line", required = false)
	private List<String> xminstr;

	public XMXAPIGJoinRequest() {
		super();
	}

	public XMXAPIGJoinRequest(String duz, String xmduz, String xmgroup) {
		super();
		this.duz = duz;
		this.xmduz = xmduz;
		this.xmgroup = xmgroup;
		this.xminstr = new ArrayList<String>();
	}

	public XMXAPIGJoinRequest(String duz, String xmduz, String xmgroup, List<String> xminstr) {
		super();
		this.duz = duz;
		this.xmduz = xmduz;
		this.xmgroup = xmgroup;
		this.xminstr = xminstr;
	}
	
	public String getDuz() {
		return duz;
	}

	public void setDuz(String duz) {
		this.duz = duz;
	}

	public String getXmduz() {
		return xmduz;
	}

	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	public String getXmgroup() {
		return xmgroup;
	}

	public void setXmgroup(String xmgroup) {
		this.xmgroup = xmgroup;
	}

	public List<String> getXminstr() {
		return xminstr;
	}

	public void setXminstr(List<String> xminstr) {
		this.xminstr = xminstr;
	}
	
}
