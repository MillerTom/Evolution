/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXUTILNonewResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNonewResponse extends AbstractVistaResponse {

	/**
	 * 
	 * outputData :
	 * 
	 * Array that should receive result
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages .
	 */
	@XmlElementWrapper(name = "outputData")
	@XmlElement(name = "entry", required = false)
	protected List<String> outputData;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * No Arguments Constructor.
	 */
	public XMXUTILNonewResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputData
	 * @param msgRoot
	 */
	public XMXUTILNonewResponse(List<String> outputData, List<String> msgRoot) {
		super();
		this.outputData = outputData;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the outputData
	 */
	public List<String> getOutputData() {
		return outputData;
	}

	/**
	 * @param outputData
	 *            the outputData to set
	 */
	protected void setOutputData(List<String> outputData) {
		this.outputData = outputData;
	}

	/**
	 * @return the msgRoot
	 */
	public List<String> getMsgRoot() {
		return msgRoot;
	}

	/**
	 * @param msgRoot
	 *            the msgRoot to set
	 */
	protected void setMsgRoot(List<String> msgRoot) {
		this.msgRoot = msgRoot;
	}

}
