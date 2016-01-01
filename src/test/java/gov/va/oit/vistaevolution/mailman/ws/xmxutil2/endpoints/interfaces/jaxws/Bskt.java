
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest;

@XmlRootElement(name = "BsktXMXUTIL2", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BsktXMXUTIL2", namespace = "http://vistaevolution.va.gov")
public class Bskt {

    @XmlElement(name = "XMXUTIL2BsktRequest", namespace = "")
    private XMXUTIL2BsktRequest xmxutil2BsktRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2BsktRequest
     */
    public XMXUTIL2BsktRequest getXmxutil2BsktRequest() {
        return this.xmxutil2BsktRequest;
    }

    /**
     * 
     * @param xmxutil2BsktRequest
     *     the value for the xmxutil2BsktRequest property
     */
    public void setXmxutil2BsktRequest(XMXUTIL2BsktRequest xmxutil2BsktRequest) {
        this.xmxutil2BsktRequest = xmxutil2BsktRequest;
    }

}
