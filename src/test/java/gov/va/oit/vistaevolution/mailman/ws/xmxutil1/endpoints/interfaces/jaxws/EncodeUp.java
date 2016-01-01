
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;

@XmlRootElement(name = "XMXUTIL1Encodeup", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1Encodeup", namespace = "http://vistaevolution.va.gov")
public class EncodeUp {

    @XmlElement(name = "arg0", namespace = "")
    private XMXUTIL1EncodeupRequest arg0;

    /**
     * 
     * @return
     *     returns XMXUTIL1EncodeupRequest
     */
    public XMXUTIL1EncodeupRequest getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(XMXUTIL1EncodeupRequest arg0) {
        this.arg0 = arg0;
    }

}
