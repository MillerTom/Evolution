
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkRequest;

@XmlRootElement(name = "XMGAPI0SubChk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI0SubChk", namespace = "http://vistaevolution.va.gov")
public class SubChk {

    @XmlElement(name = "XMGAPI0SubChkRequest", namespace = "")
    private XMGAPI0SubChkRequest xmgapi0SubChkRequest;

    /**
     * 
     * @return
     *     returns XMGAPI0SubChkRequest
     */
    public XMGAPI0SubChkRequest getXmgapi0SubChkRequest() {
        return this.xmgapi0SubChkRequest;
    }

    /**
     * 
     * @param xmgapi0SubChkRequest
     *     the value for the xmgapi0SubChkRequest property
     */
    public void setXmgapi0SubChkRequest(XMGAPI0SubChkRequest xmgapi0SubChkRequest) {
        this.xmgapi0SubChkRequest = xmgapi0SubChkRequest;
    }

}
