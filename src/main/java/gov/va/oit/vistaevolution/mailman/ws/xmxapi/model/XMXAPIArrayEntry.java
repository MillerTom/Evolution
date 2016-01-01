package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIArrayEntry {

	@XmlAttribute
	private String index;
	@XmlValue
	private String value;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIArrayEntry() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param index
	 * @param value
	 */
	public XMXAPIArrayEntry(String index, String value) {
		super();
		this.index = index;
		this.value = value;
	}

}
