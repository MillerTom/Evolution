
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest;

@XmlRootElement(name = "XMXUTIL2Subj", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2Subj", namespace = "http://vistaevolution.va.gov")
public class Subj {

    @XmlElement(name = "XMXUTIL2SubjRequest", namespace = "")
    private XMXUTIL2SubjRequest xmxutil2SubjRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2SubjRequest
     */
    public XMXUTIL2SubjRequest getXmxutil2SubjRequest() {
        return this.xmxutil2SubjRequest;
    }

    /**
     * 
     * @param xmxutil2SubjRequest
     *     the value for the xmxutil2SubjRequest property
     */
    public void setXmxutil2SubjRequest(XMXUTIL2SubjRequest xmxutil2SubjRequest) {
        this.xmxutil2SubjRequest = xmxutil2SubjRequest;
    }

}
