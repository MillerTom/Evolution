/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

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
public class XMXUTIL2InmsgResponse {
	
	@XmlElement(name = "error", required = true)
	private String error;

	@XmlElementWrapper(name = "xmim")
	@XmlElement(name = "xmim-line", required = true)
	private List<String> xmim;
	
	@XmlElementWrapper(name = "xminstr")
	@XmlElement(name = "xminstr-line", required = true)
	private List<String> xminstr;
	
	@XmlElementWrapper(name = "xmiu")
	@XmlElement(name = "xmiu-line", required = true)
	private List<String> xmiu;
	
	public XMXUTIL2InmsgResponse() {
		super();
	}

	public XMXUTIL2InmsgResponse(String error, List<String> xmim, List<String> xminstr, List<String> xmiu) {
		super();
		this.error = error;
		this.xmim = xmim;
		this.xminstr = xminstr;
		this.xmiu = xmiu;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getXmim() {
		return xmim;
	}

	public void setXmim(List<String> xmim) {
		this.xmim = xmim;
	}

	public List<String> getXminstr() {
		return xminstr;
	}

	public void setXminstr(List<String> xminstr) {
		this.xminstr = xminstr;
	}

	public List<String> getXmiu() {
		return xmiu;
	}

	public void setXmiu(List<String> xmiu) {
		this.xmiu = xmiu;
	}
	
}
