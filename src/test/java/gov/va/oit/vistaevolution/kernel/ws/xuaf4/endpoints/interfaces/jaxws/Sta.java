
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest;

@XmlRootElement(name = "XUAF4STA", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4STA", namespace = "http://vistaevolution.va.gov")
public class Sta {

    @XmlElement(name = "XUAF4STARequest", namespace = "")
    private XUAF4STARequest xuaf4STARequest;

    /**
     * 
     * @return
     *     returns XUAF4STARequest
     */
    public XUAF4STARequest getXuaf4STARequest() {
        return this.xuaf4STARequest;
    }

    /**
     * 
     * @param xuaf4STARequest
     *     the value for the xuaf4STARequest property
     */
    public void setXuaf4STARequest(XUAF4STARequest xuaf4STARequest) {
        this.xuaf4STARequest = xuaf4STARequest;
    }

}
