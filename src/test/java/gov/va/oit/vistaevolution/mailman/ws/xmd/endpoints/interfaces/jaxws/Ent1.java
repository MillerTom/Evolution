
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request;

@XmlRootElement(name = "XMDEnt1", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMDEnt1", namespace = "http://vistaevolution.va.gov")
public class Ent1 {

    @XmlElement(name = "XMDEnt1Request", namespace = "")
    private XMDEnt1Request xmdEnt1Request;

    /**
     * 
     * @return
     *     returns XMDEnt1Request
     */
    public XMDEnt1Request getXmdEnt1Request() {
        return this.xmdEnt1Request;
    }

    /**
     * 
     * @param xmdEnt1Request
     *     the value for the xmdEnt1Request property
     */
    public void setXmdEnt1Request(XMDEnt1Request xmdEnt1Request) {
        this.xmdEnt1Request = xmdEnt1Request;
    }

}
