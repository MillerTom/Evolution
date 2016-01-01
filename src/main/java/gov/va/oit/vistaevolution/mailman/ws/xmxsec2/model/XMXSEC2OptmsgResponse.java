/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model;

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
@XmlRootElement(name = "XMXSEC2OptmsgResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC2OptmsgResponse extends AbstractXMXSEC2Response {

	/**
	 * 
	 * optionsList :
	 * 
	 * available options that user can edit .
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages .
	 */

	@XmlElementWrapper(name = "options")
	@XmlElement(name = "option", required = false)
	protected List<String> optionsList;

	/**
	 * No Arguments Constructor.
	 */
	public XMXSEC2OptmsgResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param optionsList
	 * @param msgRoot
	 */
	public XMXSEC2OptmsgResponse(List<String> optionsList, List<String> msgRoot) {
		super(msgRoot);
		this.optionsList = optionsList;
	}

	/**
	 * @return the optionsList
	 */
	public List<String> getOptionsList() {
		return optionsList;
	}

	/**
	 * @param optionsList
	 *            the optionsList to set
	 */
	protected void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}
}
