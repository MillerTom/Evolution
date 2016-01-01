
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;

@XmlRootElement(name = "XUAF4LKUP", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4LKUP", namespace = "http://vistaevolution.va.gov")
public class LKUP {

    @XmlElement(name = "XUAF4LKUPRequest", namespace = "")
    private XUAF4LKUPRequest xuaf4LKUPRequest;

    /**
     * 
     * @return
     *     returns XUAF4LKUPRequest
     */
    public XUAF4LKUPRequest getXuaf4LKUPRequest() {
        return this.xuaf4LKUPRequest;
    }

    /**
     * 
     * @param xuaf4LKUPRequest
     *     the value for the xuaf4LKUPRequest property
     */
    public void setXuaf4LKUPRequest(XUAF4LKUPRequest xuaf4LKUPRequest) {
        this.xuaf4LKUPRequest = xuaf4LKUPRequest;
    }

}
