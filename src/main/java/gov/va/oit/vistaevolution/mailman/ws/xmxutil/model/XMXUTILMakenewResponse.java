/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILMakenewResponse extends AbstractVistaResponse {

	/**
	 * 
	 * addMsgResult :
	 * 
	 * String that will receive making new message result
	 * 
	 */
	@XmlElement(required = false)
	private String addMsgResult;

	/**
	 * No Arguments Constructor.
	 */
	public XMXUTILMakenewResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param addMsgResult
	 */
	public XMXUTILMakenewResponse(String addResult) {
		super();
		this.addMsgResult = addResult;
	}

	/**
	 * @return the addMsgResult
	 */
	public String getAddMsgResult() {
		return addMsgResult;
	}

	/**
	 * @param addMsgResult
	 *            the addMsgResult to set
	 */
	public void setAddMsgResult(String addMsgResult) {
		this.addMsgResult = addMsgResult;
	}

}
