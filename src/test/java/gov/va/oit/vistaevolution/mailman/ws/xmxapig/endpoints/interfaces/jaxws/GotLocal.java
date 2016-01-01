
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalRequest;

@XmlRootElement(name = "XMXAPIGGotLocal", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIGGotLocal", namespace = "http://vistaevolution.va.gov")
public class GotLocal {

    @XmlElement(name = "XMXAPIGGotLocalRequest", namespace = "")
    private XMXAPIGGotLocalRequest xmxapigGotLocalRequest;

    /**
     * 
     * @return
     *     returns XMXAPIGGotLocalRequest
     */
    public XMXAPIGGotLocalRequest getXmxapigGotLocalRequest() {
        return this.xmxapigGotLocalRequest;
    }

    /**
     * 
     * @param xmxapigGotLocalRequest
     *     the value for the xmxapigGotLocalRequest property
     */
    public void setXmxapigGotLocalRequest(XMXAPIGGotLocalRequest xmxapigGotLocalRequest) {
        this.xmxapigGotLocalRequest = xmxapigGotLocalRequest;
    }

}
