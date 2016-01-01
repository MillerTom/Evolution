
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest;

@XmlRootElement(name = "XMXAPIBRseqbskt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBRseqbskt", namespace = "http://vistaevolution.va.gov")
public class Rseqbskt {

    @XmlElement(name = "XMXAPIBRseqbsktRequest", namespace = "")
    private XMXAPIBRseqbsktRequest xmxapibRseqbsktRequest;

    /**
     * 
     * @return
     *     returns XMXAPIBRseqbsktRequest
     */
    public XMXAPIBRseqbsktRequest getXmxapibRseqbsktRequest() {
        return this.xmxapibRseqbsktRequest;
    }

    /**
     * 
     * @param xmxapibRseqbsktRequest
     *     the value for the xmxapibRseqbsktRequest property
     */
    public void setXmxapibRseqbsktRequest(XMXAPIBRseqbsktRequest xmxapibRseqbsktRequest) {
        this.xmxapibRseqbsktRequest = xmxapibRseqbsktRequest;
    }

}
