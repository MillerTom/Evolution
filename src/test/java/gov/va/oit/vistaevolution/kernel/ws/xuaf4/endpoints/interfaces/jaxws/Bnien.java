
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienRequest;

@XmlRootElement(name = "XUAF4Bnien", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4Bnien", namespace = "http://vistaevolution.va.gov")
public class Bnien {

    @XmlElement(name = "XUAF4BnienRequest", namespace = "")
    private XUAF4BnienRequest xuaf4BnienRequest;

    /**
     * 
     * @return
     *     returns XUAF4BnienRequest
     */
    public XUAF4BnienRequest getXuaf4BnienRequest() {
        return this.xuaf4BnienRequest;
    }

    /**
     * 
     * @param xuaf4BnienRequest
     *     the value for the xuaf4BnienRequest property
     */
    public void setXuaf4BnienRequest(XUAF4BnienRequest xuaf4BnienRequest) {
        this.xuaf4BnienRequest = xuaf4BnienRequest;
    }

}
