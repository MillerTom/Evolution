
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkRequest;

@XmlRootElement(name = "XQCSChk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQCSChk", namespace = "http://vistaevolution.va.gov")
public class Chk {

    @XmlElement(name = "XQCSChkRequest", namespace = "")
    private XQCSChkRequest xqcsChkRequest;

    /**
     * 
     * @return
     *     returns XQCSChkRequest
     */
    public XQCSChkRequest getXqcsChkRequest() {
        return this.xqcsChkRequest;
    }

    /**
     * 
     * @param xqcsChkRequest
     *     the value for the xqcsChkRequest property
     */
    public void setXqcsChkRequest(XQCSChkRequest xqcsChkRequest) {
        this.xqcsChkRequest = xqcsChkRequest;
    }

}
