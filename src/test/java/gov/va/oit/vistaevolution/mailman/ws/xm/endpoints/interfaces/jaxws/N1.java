
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request;

@XmlRootElement(name = "N1XM", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "N1XM", namespace = "http://vistaevolution.va.gov")
public class N1 {

    @XmlElement(name = "XMN1Request", namespace = "")
    private XMN1Request xmn1Request;

    /**
     * 
     * @return
     *     returns XMN1Request
     */
    public XMN1Request getXmn1Request() {
        return this.xmn1Request;
    }

    /**
     * 
     * @param xmn1Request
     *     the value for the xmn1Request property
     */
    public void setXmn1Request(XMN1Request xmn1Request) {
        this.xmn1Request = xmn1Request;
    }

}
