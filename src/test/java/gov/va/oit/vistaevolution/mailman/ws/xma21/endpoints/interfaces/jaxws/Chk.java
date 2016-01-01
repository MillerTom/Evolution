
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest;

@XmlRootElement(name = "XMA21Chk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA21Chk", namespace = "http://vistaevolution.va.gov")
public class Chk {

    @XmlElement(name = "XMA21ChkRequest", namespace = "")
    private XMA21ChkRequest xma21ChkRequest;

    /**
     * 
     * @return
     *     returns XMA21ChkRequest
     */
    public XMA21ChkRequest getXma21ChkRequest() {
        return this.xma21ChkRequest;
    }

    /**
     * 
     * @param xma21ChkRequest
     *     the value for the xma21ChkRequest property
     */
    public void setXma21ChkRequest(XMA21ChkRequest xma21ChkRequest) {
        this.xma21ChkRequest = xma21ChkRequest;
    }

}
