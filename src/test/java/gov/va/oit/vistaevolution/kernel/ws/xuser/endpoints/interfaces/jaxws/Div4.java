
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request;

@XmlRootElement(name = "XUSERDiv4", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSERDiv4", namespace = "http://vistaevolution.va.gov")
public class Div4 {

    @XmlElement(name = "XUSERDiv4Request", namespace = "")
    private XUSERDiv4Request xuserDiv4Request;

    /**
     * 
     * @return
     *     returns XUSERDiv4Request
     */
    public XUSERDiv4Request getXuserDiv4Request() {
        return this.xuserDiv4Request;
    }

    /**
     * 
     * @param xuserDiv4Request
     *     the value for the xuserDiv4Request property
     */
    public void setXuserDiv4Request(XUSERDiv4Request xuserDiv4Request) {
        this.xuserDiv4Request = xuserDiv4Request;
    }

}
