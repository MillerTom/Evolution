
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqRequest;

@XmlRootElement(name = "XMA1BKlq", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1BKlq", namespace = "http://vistaevolution.va.gov")
public class Klq {

    @XmlElement(name = "XMA1BKlqRequest", namespace = "")
    private XMA1BKlqRequest xma1BKlqRequest;

    /**
     * 
     * @return
     *     returns XMA1BKlqRequest
     */
    public XMA1BKlqRequest getXma1BKlqRequest() {
        return this.xma1BKlqRequest;
    }

    /**
     * 
     * @param xma1BKlqRequest
     *     the value for the xma1BKlqRequest property
     */
    public void setXma1BKlqRequest(XMA1BKlqRequest xma1BKlqRequest) {
        this.xma1BKlqRequest = xma1BKlqRequest;
    }

}
