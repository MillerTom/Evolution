package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get Recipient Information for an Alert
 * Output Parameters Class:
 * 
 * response:     (Required) Returns recipients of alert with 
 *              ID of XUAID from the ALERT TRACKING (#8992.1) 
 *              file in the array specified by XURET.  If 
 *              the specified alert is not present, the array 
 *              root is returned with a NULL value.  Use 
 *              XQALUSRS as the return root to simulate calling 
 *              the API with a null root.
 *              
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLUserlistResponse {

	@XmlElementWrapper(name = "response")
	@XmlElement(name = "response-line", required = true)
	private List<String> response;

	/**
     * @return the response
     */
    public List<String> getReturns() {
        return this.response;
    }

    /**
     * @param response the response to set
     */
    public void setReturns(List<String> response) {
        this.response = response;
    }

    /**
	 * Default Bean Constructor
	 */
	public XQALBUTLUserlistResponse() {
		super();
	}
	
	/**
	 * Construtor initializes object values
	 * @param response
	 */
	public XQALBUTLUserlistResponse(List<String> response) {
		this();
		this.response = response;
	}



}
