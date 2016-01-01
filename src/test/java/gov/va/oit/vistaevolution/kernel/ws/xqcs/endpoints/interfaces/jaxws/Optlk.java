
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkRequest;

@XmlRootElement(name = "XQCSOptlk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQCSOptlk", namespace = "http://vistaevolution.va.gov")
public class Optlk {

    @XmlElement(name = "XQCSOptlkRequest", namespace = "")
    private XQCSOptlkRequest xqcsOptlkRequest;

    /**
     * 
     * @return
     *     returns XQCSOptlkRequest
     */
    public XQCSOptlkRequest getXqcsOptlkRequest() {
        return this.xqcsOptlkRequest;
    }

    /**
     * 
     * @param xqcsOptlkRequest
     *     the value for the xqcsOptlkRequest property
     */
    public void setXqcsOptlkRequest(XQCSOptlkRequest xqcsOptlkRequest) {
        this.xqcsOptlkRequest = xqcsOptlkRequest;
    }

}
