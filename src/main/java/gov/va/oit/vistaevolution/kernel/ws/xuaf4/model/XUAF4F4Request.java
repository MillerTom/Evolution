/**
 * author Steve Orleski
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sorleski
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4F4Request extends AbstractVistaRequest {

	/**
	 * 
	 * sta:
	 * 
	 * (Required) Station Number
	 * 
	 * 
	 * flag:
	 * 
	 * (Optional) Flags that represent the Station Number Status. Possible
	 * values are: • A—Active entries only. • M—Medical treating facilities
	 * only.
	 * 
	 * inDate:
	 * 
	 * (Optional) Return name on this VA FileMan internal date.
	 * 
	 */
	@XmlElement(required = true)
	private String sta;
	@XmlElement(required = false)
	private String flag;
	@XmlElement(required = false)
	private String inDate;

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4F4Request() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param sta
	 * @param flag
	 * @param inDate
	 */
	public XUAF4F4Request(String sta, String flag, String inDate) {
		super();
		this.sta = sta;
		this.flag = flag;
		this.inDate = inDate;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

}
