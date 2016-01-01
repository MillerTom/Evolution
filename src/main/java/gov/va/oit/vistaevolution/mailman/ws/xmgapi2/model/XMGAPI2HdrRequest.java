/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMGAPI2HdrRequest extends AbstractVistaRequest{

	@XmlElement(name = "duz", required = true)
	private String duz;
	
	@XmlElement(name = "xmduz", required = true)
	private String xmduz;
	
	@XmlElement(name = "msg", required = true)
	private String msg;
	
	@XmlElement(name = "flag", required = true)
	private String flag;

	/**
	 * Default No-arg constructor
	 */
	public XMGAPI2HdrRequest() {
		super();
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


}
