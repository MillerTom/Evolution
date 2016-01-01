
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNRequest;

@XmlRootElement(name = "XMXUtil2KSeqN", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil2KSeqN", namespace = "http://vistaevolution.va.gov")
public class Kseqn {

    @XmlElement(name = "XMXUtil2KSeqNRequest", namespace = "")
    private XMXUtil2KSeqNRequest xmxUtil2KSeqNRequest;

    /**
     * 
     * @return
     *     returns XMXUtil2KSeqNRequest
     */
    public XMXUtil2KSeqNRequest getXmxUtil2KSeqNRequest() {
        return this.xmxUtil2KSeqNRequest;
    }

    /**
     * 
     * @param xmxUtil2KSeqNRequest
     *     the value for the xmxUtil2KSeqNRequest property
     */
    public void setXmxUtil2KSeqNRequest(XMXUtil2KSeqNRequest xmxUtil2KSeqNRequest) {
        this.xmxUtil2KSeqNRequest = xmxUtil2KSeqNRequest;
    }

}
