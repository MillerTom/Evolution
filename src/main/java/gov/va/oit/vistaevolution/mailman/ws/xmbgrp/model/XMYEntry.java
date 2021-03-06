package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model;

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
	 * Default Empty Constructor
	 */
	public XMYEntry() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param key
	 * @param value
	 */
	public XMYEntry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
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
