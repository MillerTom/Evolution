
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest;

@XmlRootElement(name = "XMA21Who", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA21Who", namespace = "http://vistaevolution.va.gov")
public class Who {

    @XmlElement(name = "XMA21WhoRequest", namespace = "")
    private XMA21WhoRequest xma21WhoRequest;

    /**
     * 
     * @return
     *     returns XMA21WhoRequest
     */
    public XMA21WhoRequest getXma21WhoRequest() {
        return this.xma21WhoRequest;
    }

    /**
     * 
     * @param xma21WhoRequest
     *     the value for the xma21WhoRequest property
     */
    public void setXma21WhoRequest(XMA21WhoRequest xma21WhoRequest) {
        this.xma21WhoRequest = xma21WhoRequest;
    }

}
