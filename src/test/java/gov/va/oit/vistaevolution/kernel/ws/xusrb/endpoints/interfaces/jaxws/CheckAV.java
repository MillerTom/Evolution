
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVRequest;

@XmlRootElement(name = "CheckAVXUSRB", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckAVXUSRB", namespace = "http://vistaevolution.va.gov")
public class CheckAV {

    @XmlElement(name = "XUSRBCheckAVRequest", namespace = "")
    private XUSRBCheckAVRequest xusrbCheckAVRequest;

    /**
     * 
     * @return
     *     returns XUSRBCheckAVRequest
     */
    public XUSRBCheckAVRequest getXusrbCheckAVRequest() {
        return this.xusrbCheckAVRequest;
    }

    /**
     * 
     * @param xusrbCheckAVRequest
     *     the value for the xusrbCheckAVRequest property
     */
    public void setXusrbCheckAVRequest(XUSRBCheckAVRequest xusrbCheckAVRequest) {
        this.xusrbCheckAVRequest = xusrbCheckAVRequest;
    }

}
