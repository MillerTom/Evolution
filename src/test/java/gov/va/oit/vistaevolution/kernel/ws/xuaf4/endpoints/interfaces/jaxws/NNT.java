
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;

@XmlRootElement(name = "XUAF4NNT", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4NNT", namespace = "http://vistaevolution.va.gov")
public class NNT {

    @XmlElement(name = "XUAF4NNTRequest", namespace = "")
    private XUAF4NNTRequest xuaf4NNTRequest;

    /**
     * 
     * @return
     *     returns XUAF4NNTRequest
     */
    public XUAF4NNTRequest getXuaf4NNTRequest() {
        return this.xuaf4NNTRequest;
    }

    /**
     * 
     * @param xuaf4NNTRequest
     *     the value for the xuaf4NNTRequest property
     */
    public void setXuaf4NNTRequest(XUAF4NNTRequest xuaf4NNTRequest) {
        this.xuaf4NNTRequest = xuaf4NNTRequest;
    }

}
