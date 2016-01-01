
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameRequest;

@XmlRootElement(name = "XUAF4Name", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4Name", namespace = "http://vistaevolution.va.gov")
public class Name {

    @XmlElement(name = "XUAF4NameRequest", namespace = "")
    private XUAF4NameRequest xuaf4NameRequest;

    /**
     * 
     * @return
     *     returns XUAF4NameRequest
     */
    public XUAF4NameRequest getXuaf4NameRequest() {
        return this.xuaf4NameRequest;
    }

    /**
     * 
     * @param xuaf4NameRequest
     *     the value for the xuaf4NameRequest property
     */
    public void setXuaf4NameRequest(XUAF4NameRequest xuaf4NameRequest) {
        this.xuaf4NameRequest = xuaf4NameRequest;
    }

}
