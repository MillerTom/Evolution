/**
 *
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * <pre>
 * Verify User's Mail Group Memebership
 * Output Parameters Class:
 *
 * returnCode:   (Required) The results of the
 *              call:
 *
 *              0^User is not a member    (False)
 *              1^User is a member        (True)
 *             -1^Error in required input
 *             -1^Mail group not found
  * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA21ChkResponse {

	@XmlElement(name = "return-code", required = true)
	private String returnCode;

	@XmlElement(name = "return-msg", required = true)
	private String returnMsg;

	/**
     * @return the returnCode
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * @param returnCode the returnCode to set
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    
    public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	/**
     * Default Constructor
     */
    public XMA21ChkResponse() {
		super();
	}

    /**
     * Constructor initializes the object
     * @param value
     */
	public XMA21ChkResponse(String returnCode, String returnMsg) {
		this();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}


}
