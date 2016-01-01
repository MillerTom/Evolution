
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;

@XmlRootElement(name = "XUSRBValidAV", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSRBValidAV", namespace = "http://vistaevolution.va.gov")
public class ValidAV {

    @XmlElement(name = "XUSRBValidAVRequest", namespace = "")
    private XUSRBValidAVRequest xusrbValidAVRequest;

    /**
     * 
     * @return
     *     returns XUSRBValidAVRequest
     */
    public XUSRBValidAVRequest getXusrbValidAVRequest() {
        return this.xusrbValidAVRequest;
    }

    /**
     * 
     * @param xusrbValidAVRequest
     *     the value for the xusrbValidAVRequest property
     */
    public void setXusrbValidAVRequest(XUSRBValidAVRequest xusrbValidAVRequest) {
        this.xusrbValidAVRequest = xusrbValidAVRequest;
    }

}
