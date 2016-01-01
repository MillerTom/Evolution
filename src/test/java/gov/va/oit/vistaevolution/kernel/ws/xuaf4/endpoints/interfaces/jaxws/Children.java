
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenRequest;

@XmlRootElement(name = "XUAF4Children", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4Children", namespace = "http://vistaevolution.va.gov")
public class Children {

    @XmlElement(name = "XUAF4ChildrenRequest", namespace = "")
    private XUAF4ChildrenRequest xuaf4ChildrenRequest;

    /**
     * 
     * @return
     *     returns XUAF4ChildrenRequest
     */
    public XUAF4ChildrenRequest getXuaf4ChildrenRequest() {
        return this.xuaf4ChildrenRequest;
    }

    /**
     * 
     * @param xuaf4ChildrenRequest
     *     the value for the xuaf4ChildrenRequest property
     */
    public void setXuaf4ChildrenRequest(XUAF4ChildrenRequest xuaf4ChildrenRequest) {
        this.xuaf4ChildrenRequest = xuaf4ChildrenRequest;
    }

}
