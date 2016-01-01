
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusRequest;

@XmlRootElement(name = "XMS1Status", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMS1Status", namespace = "http://vistaevolution.va.gov")
public class Status {

    @XmlElement(name = "XMS1StatusRequest", namespace = "")
    private XMS1StatusRequest xms1StatusRequest;

    /**
     * 
     * @return
     *     returns XMS1StatusRequest
     */
    public XMS1StatusRequest getXms1StatusRequest() {
        return this.xms1StatusRequest;
    }

    /**
     * 
     * @param xms1StatusRequest
     *     the value for the xms1StatusRequest property
     */
    public void setXms1StatusRequest(XMS1StatusRequest xms1StatusRequest) {
        this.xms1StatusRequest = xms1StatusRequest;
    }

}
