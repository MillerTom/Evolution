/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model;

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
public class XMGAPI0SubChkValue {

	@XmlValue
	private String value;
	@XmlAttribute(required = false)
	private String correctedSubject;

	/**
	 * @param value
	 * @param correctedSubject
	 */
	public XMGAPI0SubChkValue(String value, boolean correctedSubject) {
		super();
		this.setValue(value);
		if (correctedSubject)
			this.setCorrectedSubject(Boolean.toString(correctedSubject));
		else
			this.setCorrectedSubject(null);
	}

	/**
	 * @param results
	 */
	public XMGAPI0SubChkValue(String results) {
		super();
		this.setValue(results);
		this.setCorrectedSubject(null);
	}

	/**
	 * Default no arg constructor super(); this.results = results;
	 * this.setCorrectedSubject(correctedSubject);
	 */
	public XMGAPI0SubChkValue() {
		super();
		this.setValue(null);
		this.setCorrectedSubject(null);
	}

	public String getValue() {
		return this.value;
	}

	protected void setValue(String results) {
		this.value = results;
	}

	public String getCorrectedSubject() {
		return correctedSubject;
	}

	protected void setCorrectedSubject(String correctedSubject) {
		this.correctedSubject = correctedSubject;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return value;
	}

}
