
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest;

@XmlRootElement(name = "XLFDT3Leap", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XLFDT3Leap", namespace = "http://vistaevolution.va.gov")
public class Leap {

    @XmlElement(name = "XLFDT3LeapRequest", namespace = "")
    private XLFDT3LeapRequest xlfdt3LeapRequest;

    /**
     * 
     * @return
     *     returns XLFDT3LeapRequest
     */
    public XLFDT3LeapRequest getXlfdt3LeapRequest() {
        return this.xlfdt3LeapRequest;
    }

    /**
     * 
     * @param xlfdt3LeapRequest
     *     the value for the xlfdt3LeapRequest property
     */
    public void setXlfdt3LeapRequest(XLFDT3LeapRequest xlfdt3LeapRequest) {
        this.xlfdt3LeapRequest = xlfdt3LeapRequest;
    }

}
