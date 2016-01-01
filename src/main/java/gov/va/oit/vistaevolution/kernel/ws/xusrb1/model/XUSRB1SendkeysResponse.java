package gov.va.oit.vistaevolution.kernel.ws.xusrb1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rcollins
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB1SendkeysResponse {

	/**
	 * 
	 */
	public XUSRB1SendkeysResponse() {
		this(null);
	}

	@XmlElement(required = true)
	private List<String> returns;

	/**
	 * @return the returns
	 */
	public List<String> getReturns() {
		return returns;
	}

	/**
	 * @param returns
	 *            the returns to set
	 */
	public void setReturns(List<String> returns) {
		this.returns = returns;
	}

	/**
	 * Bean constructor initializes value
	 * 
	 * @param value
	 */
	public XUSRB1SendkeysResponse(final List<String> value) {

		super();
		this.returns = value;
	}

}
