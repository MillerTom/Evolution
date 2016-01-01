/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

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
@XmlRootElement(name = "XMXAPIBNamebsktResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBNamebsktResponse extends AbstractVistaResponse {

	/**
	 * 
	 * settingsList :
	 * 
	 * certain MailMan settings when the user becomes himself/herself again,
	 * after having been a surrogate.
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages .
	 */

	@XmlElementWrapper(name = "settings")
	@XmlElement(name = "setting", required = false)
	protected List<String> settingsList;

	/**
	 * No Arguments Constructor.
	 */
	public XMXAPIBNamebsktResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param settingsList
	 * @param msgRoot
	 */
	public XMXAPIBNamebsktResponse(List<String> settingsList,
			List<String> msgRoot) {
		super(msgRoot);
		this.settingsList = settingsList;
	}

	/**
	 * @return the settingsList
	 */
	public List<String> getSettingsList() {
		return settingsList;
	}

	/**
	 * @param settingsList
	 *            the settingsList to set
	 */
	protected void setSettingsList(List<String> settingsList) {
		this.settingsList = settingsList;
	}

}
