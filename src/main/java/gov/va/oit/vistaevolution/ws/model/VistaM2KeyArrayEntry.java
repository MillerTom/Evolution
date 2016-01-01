/**
 * 
 */
package gov.va.oit.vistaevolution.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author sorleski
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class VistaM2KeyArrayEntry {

	/**
	 *  This object will handle 2 key array entries like this: 
	 *  
	 *  
	 *  XMCRIT(“TEXT”,”C”)=0,XMCRIT(“TEXT”,”L”)=3
	 *  
	 */
	public VistaM2KeyArrayEntry() {	}
	public VistaM2KeyArrayEntry(String k1, String k2, String val) {
		this.key1 = k1;
		this.key2 = k2;
		this.value = val;
	}
	@XmlAttribute
	private String key1;
	@XmlAttribute
	private String key2;
	@XmlValue
	private String value;
	
	public void put(String k1, String k2, String val) { 
		this.key1 = k1;
		this.key2 = k2;
		this.value = val;
	}
	
	
	public String get() { 
		return this.value;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
	
