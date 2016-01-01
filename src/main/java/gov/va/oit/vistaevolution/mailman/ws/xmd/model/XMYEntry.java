package gov.va.oit.vistaevolution.mailman.ws.xmd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMYEntry {

	@XmlAttribute
	public String key;

	@XmlValue
	private String value;

	/**
	 * @param key
	 * @param value
	 */
	public XMYEntry() {
		super();
		this.setKey(null);
		this.setValue(null);
	}
	
	/**
	 * @param key
	 * @param value
	 */
	public XMYEntry(String key, String value) {
		super();
		this.setKey(key);
		this.setValue(value);
	}

	
	public String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	protected void setValue(String value) {
		this.value = value;
	}
}
