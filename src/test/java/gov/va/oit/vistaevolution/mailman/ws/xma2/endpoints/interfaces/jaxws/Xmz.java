
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest;

@XmlRootElement(name = "XMA2Xmz", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA2Xmz", namespace = "http://vistaevolution.va.gov")
public class Xmz {

    @XmlElement(name = "XMA2XmzRequest", namespace = "")
    private XMA2XmzRequest xma2XmzRequest;

    /**
     * 
     * @return
     *     returns XMA2XmzRequest
     */
    public XMA2XmzRequest getXma2XmzRequest() {
        return this.xma2XmzRequest;
    }

    /**
     * 
     * @param xma2XmzRequest
     *     the value for the xma2XmzRequest property
     */
    public void setXma2XmzRequest(XMA2XmzRequest xma2XmzRequest) {
        this.xma2XmzRequest = xma2XmzRequest;
    }

}
