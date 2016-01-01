
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;

@XmlRootElement(name = "XMDEN1", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMDEN1", namespace = "http://vistaevolution.va.gov")
public class En1 {

    @XmlElement(name = "XMDEN1Request", namespace = "")
    private XMDEN1Request xmden1Request;

    /**
     * 
     * @return
     *     returns XMDEN1Request
     */
    public XMDEN1Request getXmden1Request() {
        return this.xmden1Request;
    }

    /**
     * 
     * @param xmden1Request
     *     the value for the xmden1Request property
     */
    public void setXmden1Request(XMDEN1Request xmden1Request) {
        this.xmden1Request = xmden1Request;
    }

}
