package gov.va.oit.vistaevolution.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class VistaM1KeyArrayEntry {

	public VistaM1KeyArrayEntry() {	}
	public VistaM1KeyArrayEntry(String k1, String val) {
		this.key = k1;
    	this.value = val;	
	}

	@XmlAttribute
    private String key;

    @XmlValue
    private String value;
    
    
    public void put(String k1, String val) { 
    	this.key = k1;
    	this.value = val;
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
