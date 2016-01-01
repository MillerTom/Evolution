/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

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
public class XMXAPIGAddMbrsResponse extends AbstractVistaResponse{

	@XmlElement(required = false)
	private String result;
	
	
	/**
	 * Default no-arg Constructor
	 */
	public XMXAPIGAddMbrsResponse(){
		super();
	}
	
	/**
	 * @param string
	 */
	public XMXAPIGAddMbrsResponse(String result) {
		this.result = result;
	}
	
	public XMXAPIGAddMbrsResponse(String status, List<String> errors) {
		super(status, errors);
		result=null;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
