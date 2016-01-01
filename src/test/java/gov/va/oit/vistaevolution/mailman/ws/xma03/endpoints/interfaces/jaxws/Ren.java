
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;

@XmlRootElement(name = "XMA03Ren", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA03Ren", namespace = "http://vistaevolution.va.gov")
public class Ren {

    @XmlElement(name = "XMA03RenRequest", namespace = "")
    private XMA03RenRequest xma03RenRequest;

    /**
     * 
     * @return
     *     returns XMA03RenRequest
     */
    public XMA03RenRequest getXma03RenRequest() {
        return this.xma03RenRequest;
    }

    /**
     * 
     * @param xma03RenRequest
     *     the value for the xma03RenRequest property
     */
    public void setXma03RenRequest(XMA03RenRequest xma03RenRequest) {
        this.xma03RenRequest = xma03RenRequest;
    }

}
