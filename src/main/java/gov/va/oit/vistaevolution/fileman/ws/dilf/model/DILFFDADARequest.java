/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFFDADARequest extends AbstractDILFFDARequest {

	@XmlElementWrapper(required = true)
	@XmlElement(name = "entry", required = true)
	private List<String> da;

	/**
	 * 
	 */
	public DILFFDADARequest() {
		super(null, null, null, null);
		setDa(null);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 */
	DILFFDADARequest(String file, List<String> da, String field) {
		super(file, field);
		setDa(da);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param value
	 */
	DILFFDADARequest(String file, List<String> da, String field,
			List<String> value) {
		super(file, field, value);
		setDa(da);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param flags
	 * @param value
	 */
	public DILFFDADARequest(String file, List<String> da, String field,
			String flags, List<String> value) {
		super(file, field, flags, value);
		setDa(da);
	}

	/**
	 * 
	 * @param file
	 * @param iens
	 * @param field
	 * @param flags
	 */
	public DILFFDADARequest(String file, List<String> da, String field,
			String flags) {
		super(file, field, flags);
		setDa(da);
	}

	public List<String> getDa() {
		return da;
	}

	protected void setDa(List<String> da) {
		this.da = da;
	}

}
