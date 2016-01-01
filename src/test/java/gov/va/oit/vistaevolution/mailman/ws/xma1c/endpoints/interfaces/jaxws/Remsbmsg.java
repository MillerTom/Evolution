
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest;

@XmlRootElement(name = "XMA1CRemsbmsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1CRemsbmsg", namespace = "http://vistaevolution.va.gov")
public class Remsbmsg {

    @XmlElement(name = "XMA1CRemsbmsgRequest", namespace = "")
    private XMA1CRemsbmsgRequest xma1CRemsbmsgRequest;

    /**
     * 
     * @return
     *     returns XMA1CRemsbmsgRequest
     */
    public XMA1CRemsbmsgRequest getXma1CRemsbmsgRequest() {
        return this.xma1CRemsbmsgRequest;
    }

    /**
     * 
     * @param xma1CRemsbmsgRequest
     *     the value for the xma1CRemsbmsgRequest property
     */
    public void setXma1CRemsbmsgRequest(XMA1CRemsbmsgRequest xma1CRemsbmsgRequest) {
        this.xma1CRemsbmsgRequest = xma1CRemsbmsgRequest;
    }

}
