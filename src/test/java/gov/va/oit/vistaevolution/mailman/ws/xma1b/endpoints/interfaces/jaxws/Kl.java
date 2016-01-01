
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlRequest;

@XmlRootElement(name = "XMA1BKl", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1BKl", namespace = "http://vistaevolution.va.gov")
public class Kl {

    @XmlElement(name = "XMA1BKlRequest", namespace = "")
    private XMA1BKlRequest xma1BKlRequest;

    /**
     * 
     * @return
     *     returns XMA1BKlRequest
     */
    public XMA1BKlRequest getXma1BKlRequest() {
        return this.xma1BKlRequest;
    }

    /**
     * 
     * @param xma1BKlRequest
     *     the value for the xma1BKlRequest property
     */
    public void setXma1BKlRequest(XMA1BKlRequest xma1BKlRequest) {
        this.xma1BKlRequest = xma1BKlRequest;
    }

}
