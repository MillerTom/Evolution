
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest;

@XmlRootElement(name = "XUSRB2Userinfo", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSRB2Userinfo", namespace = "http://vistaevolution.va.gov")
public class Userinfo {

    @XmlElement(name = "XUSRB2UserinfoRequest", namespace = "")
    private XUSRB2UserinfoRequest xusrb2UserinfoRequest;

    /**
     * 
     * @return
     *     returns XUSRB2UserinfoRequest
     */
    public XUSRB2UserinfoRequest getXusrb2UserinfoRequest() {
        return this.xusrb2UserinfoRequest;
    }

    /**
     * 
     * @param xusrb2UserinfoRequest
     *     the value for the xusrb2UserinfoRequest property
     */
    public void setXusrb2UserinfoRequest(XUSRB2UserinfoRequest xusrb2UserinfoRequest) {
        this.xusrb2UserinfoRequest = xusrb2UserinfoRequest;
    }

}
