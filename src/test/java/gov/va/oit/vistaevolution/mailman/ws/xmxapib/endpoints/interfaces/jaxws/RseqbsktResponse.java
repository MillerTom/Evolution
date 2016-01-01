
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;

@XmlRootElement(name = "XMXAPIBRseqbsktResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBRseqbsktResponse", namespace = "http://vistaevolution.va.gov")
public class RseqbsktResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIBRseqbsktResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIBRseqbsktResponse
     */
    public XMXAPIBRseqbsktResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIBRseqbsktResponse _return) {
        this._return = _return;
    }

}
