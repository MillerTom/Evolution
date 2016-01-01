/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

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
public class DIDAttributeValue {

	@XmlAttribute(name = "name", required = true)
	private String name;

	@XmlAttribute(name = "flag", required = false)
	private String flag;

	@XmlValue
	private String value;
	
	
	/**
	 * Default no arg constructor for jaxb
	 */
	public DIDAttributeValue(){
		super();
	}
	
	/**
	 * @param name
	 * @param flag
	 * @param value
	 */
	public DIDAttributeValue(String name, String flag, String value) {
		super();
		this.setName(name);
		this.setFlag(flag);
		this.setValue(value);
	}

	
	/**
	 * @param line
	 */
	public DIDAttributeValue(String value) {
		super();
		this.setName(null);
		this.setFlag(null);
		this.setValue(value);
	}

	/**
	 * @param attribute
	 * @param string
	 */
	public DIDAttributeValue(String name, String value) {
		super();
		this.setName(name);
		this.setFlag(null);
		this.setValue(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getValue();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
