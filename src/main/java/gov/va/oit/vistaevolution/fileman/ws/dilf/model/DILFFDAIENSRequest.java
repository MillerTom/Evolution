/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFFDAIENSRequest extends AbstractDILFFDARequest {

	@XmlElement
	private String iens;

	/**
	 * 
	 */
	public DILFFDAIENSRequest() {
		super(null, null, null, null);
		setIens(null);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 */
	public DILFFDAIENSRequest(String file, String iens, String field) {
		super(file, field);
		setIens(iens);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param value
	 */
	public DILFFDAIENSRequest(String file, String iens, String field,
			List<String> value) {
		super(file, field, value);
		setIens(iens);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param flags
	 * @param value
	 */
	public DILFFDAIENSRequest(String file, String iens, String field,
			String flags, List<String> value) {
		super(file, field, flags, value);
		setIens(iens);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param flags
	 */
	public DILFFDAIENSRequest(String file, String iens, String field,
			String flags) {
		super(file, field, flags);
		setIens(iens);
	}

	public String getIens() {
		return iens;
	}

	protected void setIens(String iens) {
		this.iens = iens;
	}

}
