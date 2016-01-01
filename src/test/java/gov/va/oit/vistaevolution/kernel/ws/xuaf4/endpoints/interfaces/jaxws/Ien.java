
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenRequest;

@XmlRootElement(name = "XUAF4Ien", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4Ien", namespace = "http://vistaevolution.va.gov")
public class Ien {

    @XmlElement(name = "XUAF4IenRequest", namespace = "")
    private XUAF4IenRequest xuaf4IenRequest;

    /**
     * 
     * @return
     *     returns XUAF4IenRequest
     */
    public XUAF4IenRequest getXuaf4IenRequest() {
        return this.xuaf4IenRequest;
    }

    /**
     * 
     * @param xuaf4IenRequest
     *     the value for the xuaf4IenRequest property
     */
    public void setXuaf4IenRequest(XUAF4IenRequest xuaf4IenRequest) {
        this.xuaf4IenRequest = xuaf4IenRequest;
    }

}
