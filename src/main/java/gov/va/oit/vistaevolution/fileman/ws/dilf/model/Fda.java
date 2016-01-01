/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Leisa Martella
 *
 */
public class Fda {
	
	private String file;
	private String position;
	private String field;
	private String value;

	/**
	 * @return the file
	 */
	@XmlElement
	public String getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * @return the position
	 */
	@XmlElement
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the field
	 */
	@XmlElement
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the value
	 */
	@XmlElement
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
