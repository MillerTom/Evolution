
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsRequest;

@XmlRootElement(name = "XMXAPIGAddMbrs", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIGAddMbrs", namespace = "http://vistaevolution.va.gov")
public class AddMbrs {

    @XmlElement(name = "XMXAPIGAddMbrsRequest", namespace = "")
    private XMXAPIGAddMbrsRequest xmxapigAddMbrsRequest;

    /**
     * 
     * @return
     *     returns XMXAPIGAddMbrsRequest
     */
    public XMXAPIGAddMbrsRequest getXmxapigAddMbrsRequest() {
        return this.xmxapigAddMbrsRequest;
    }

    /**
     * 
     * @param xmxapigAddMbrsRequest
     *     the value for the xmxapigAddMbrsRequest property
     */
    public void setXmxapigAddMbrsRequest(XMXAPIGAddMbrsRequest xmxapigAddMbrsRequest) {
        this.xmxapigAddMbrsRequest = xmxapigAddMbrsRequest;
    }

}
