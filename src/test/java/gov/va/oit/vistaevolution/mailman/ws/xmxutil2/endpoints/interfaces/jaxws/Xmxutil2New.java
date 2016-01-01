
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest;

@XmlRootElement(name = "XMXUTIL2New", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2New", namespace = "http://vistaevolution.va.gov")
public class Xmxutil2New {

    @XmlElement(name = "XMXUTIL2NewRequest", namespace = "")
    private XMXUTIL2NewRequest xmxutil2NewRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2NewRequest
     */
    public XMXUTIL2NewRequest getXmxutil2NewRequest() {
        return this.xmxutil2NewRequest;
    }

    /**
     * 
     * @param xmxutil2NewRequest
     *     the value for the xmxutil2NewRequest property
     */
    public void setXmxutil2NewRequest(XMXUTIL2NewRequest xmxutil2NewRequest) {
        this.xmxutil2NewRequest = xmxutil2NewRequest;
    }

}
