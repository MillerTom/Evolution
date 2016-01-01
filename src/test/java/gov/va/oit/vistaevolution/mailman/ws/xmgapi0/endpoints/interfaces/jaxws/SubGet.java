
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubgetRequest;

@XmlRootElement(name = "XMGAPI0SubGet", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI0SubGet", namespace = "http://vistaevolution.va.gov")
public class SubGet {

    @XmlElement(name = "XMGAPI0SubgetRequest", namespace = "")
    private XMGAPI0SubgetRequest xmgapi0SubgetRequest;

    /**
     * 
     * @return
     *     returns XMGAPI0SubgetRequest
     */
    public XMGAPI0SubgetRequest getXmgapi0SubgetRequest() {
        return this.xmgapi0SubgetRequest;
    }

    /**
     * 
     * @param xmgapi0SubgetRequest
     *     the value for the xmgapi0SubgetRequest property
     */
    public void setXmgapi0SubgetRequest(XMGAPI0SubgetRequest xmgapi0SubgetRequest) {
        this.xmgapi0SubgetRequest = xmgapi0SubgetRequest;
    }

}
