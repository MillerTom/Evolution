
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFRequest;

@XmlRootElement(name = "XUAF4TF", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4TF", namespace = "http://vistaevolution.va.gov")
public class Tf {

    @XmlElement(name = "XUAF4TFRequest", namespace = "")
    private XUAF4TFRequest xuaf4TFRequest;

    /**
     * 
     * @return
     *     returns XUAF4TFRequest
     */
    public XUAF4TFRequest getXuaf4TFRequest() {
        return this.xuaf4TFRequest;
    }

    /**
     * 
     * @param xuaf4TFRequest
     *     the value for the xuaf4TFRequest property
     */
    public void setXuaf4TFRequest(XUAF4TFRequest xuaf4TFRequest) {
        this.xuaf4TFRequest = xuaf4TFRequest;
    }

}
