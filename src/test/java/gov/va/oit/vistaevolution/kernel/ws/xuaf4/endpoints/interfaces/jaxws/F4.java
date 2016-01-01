
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Request;

@XmlRootElement(name = "F4XUAF4", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "F4XUAF4", namespace = "http://vistaevolution.va.gov")
public class F4 {

    @XmlElement(name = "XUAF4F4Request", namespace = "")
    private XUAF4F4Request xuaf4F4Request;

    /**
     * 
     * @return
     *     returns XUAF4F4Request
     */
    public XUAF4F4Request getXuaf4F4Request() {
        return this.xuaf4F4Request;
    }

    /**
     * 
     * @param xuaf4F4Request
     *     the value for the xuaf4F4Request property
     */
    public void setXuaf4F4Request(XUAF4F4Request xuaf4F4Request) {
        this.xuaf4F4Request = xuaf4F4Request;
    }

}
