
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest;

@XmlRootElement(name = "XMA1CSetsb", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1CSetsb", namespace = "http://vistaevolution.va.gov")
public class Setsb {

    @XmlElement(name = "XMA1CSetsbRequest", namespace = "")
    private XMA1CSetsbRequest xma1CSetsbRequest;

    /**
     * 
     * @return
     *     returns XMA1CSetsbRequest
     */
    public XMA1CSetsbRequest getXma1CSetsbRequest() {
        return this.xma1CSetsbRequest;
    }

    /**
     * 
     * @param xma1CSetsbRequest
     *     the value for the xma1CSetsbRequest property
     */
    public void setXma1CSetsbRequest(XMA1CSetsbRequest xma1CSetsbRequest) {
        this.xma1CSetsbRequest = xma1CSetsbRequest;
    }

}
