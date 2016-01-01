/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIGListEntry {

	/**
	 * Default no-arg constructor.
	 */
	public XMXAPIGListEntry() {
		super();
	}

	/**
	 * 
	 * @param type
	 * @param value
	 */
	public XMXAPIGListEntry(String type, String value) {
		this.type = type;
		if (value == null) {
			this.value = "";
		} else {
			this.value = value;
		}
	}

	@XmlAttribute
	private String type;

	@XmlValue
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value == null) {
			this.value = "";
		} else {
			this.value = value;
		}
	}
}
