
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest;

@XmlRootElement(name = "XMXSEC1SsPriv", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXSEC1SsPriv", namespace = "http://vistaevolution.va.gov")
public class Sspriv {

    @XmlElement(name = "XMXSEC1SsPrivRequest", namespace = "")
    private XMXSEC1SsPrivRequest xmxsec1SsPrivRequest;

    /**
     * 
     * @return
     *     returns XMXSEC1SsPrivRequest
     */
    public XMXSEC1SsPrivRequest getXmxsec1SsPrivRequest() {
        return this.xmxsec1SsPrivRequest;
    }

    /**
     * 
     * @param xmxsec1SsPrivRequest
     *     the value for the xmxsec1SsPrivRequest property
     */
    public void setXmxsec1SsPrivRequest(XMXSEC1SsPrivRequest xmxsec1SsPrivRequest) {
        this.xmxsec1SsPrivRequest = xmxsec1SsPrivRequest;
    }

}
