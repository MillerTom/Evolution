package gov.va.oit.vistaevolution.fileman.ws.ddr3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * file	(Required) File or subfile number.
 * iens	Note: parameter is not required in the RPC call
 * 		Standard IENS indicating internal entry numbers.
 * field	(Required) Field number for which data is being validated.
 * value	(Required) Value to be validated as input by a user. VALUE can take several forms depending on the data type involved; e.g., a partial, unambiguous match for a pointer; any of the supported ways to input dates (such as "TODAY" or "11/3/93").
 * </pre>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DDR3ValCRequest {
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = false)
	private String iens;
	@XmlElement(required = true)
	private String field;
	@XmlElement(required = true)
	private String value;

	public DDR3ValCRequest() {
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getIens() {
		return iens;
	}

	public void setIens(String iens) {
		this.iens = iens;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
