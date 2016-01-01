/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

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
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1OptgrpResponse extends AbstractVistaResponse {

	/**
	 * 
	 * optionsDataList :
	 * 
	 * Array contains what the user can do at the basket or message group level.
	 * 
	 */

	@XmlElementWrapper(name = "optionsDataList")
	@XmlElement(name = "option", required = false)
	protected List<String> optionsDataList;

	/**
	 * No Arguments Constructor.
	 */
	public XMXSEC1OptgrpResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param optionsDataList
	 */
	public XMXSEC1OptgrpResponse(List<String> optionsDataList,
			List<String> errors) {
		super(errors);
		this.optionsDataList = optionsDataList;
	}

	/**
	 * @return the optionsDataList
	 */
	public List<String> getOptionsDataList() {
		return optionsDataList;
	}

	/**
	 * @param optionsDataList
	 *            the optionsDataList to set
	 */
	public void setOptionsDataList(List<String> optionsDataList) {
		this.optionsDataList = optionsDataList;
	}

}
