/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA21WhoResponse {

	@XmlElementWrapper(name = "response")
    @XmlElement(name = "response-line", required = true)
    private List<String> response;
	
	public XMA21WhoResponse() {
		super();
	}
	
	public XMA21WhoResponse(List<String> response) {
		super();
		this.response = response;
	}

    /**
     * @return the response
     */
    public List<String> getResponse() {
        return this.response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(final List<String> response) {
        this.response = response;
    }

}
