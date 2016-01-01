
package gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveRequest;

@XmlRootElement(name = "XUSAPActive", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSAPActive", namespace = "http://vistaevolution.va.gov")
public class Active {

    @XmlElement(name = "XUSAPActiveRequest", namespace = "")
    private XUSAPActiveRequest xusapActiveRequest;

    /**
     * 
     * @return
     *     returns XUSAPActiveRequest
     */
    public XUSAPActiveRequest getXusapActiveRequest() {
        return this.xusapActiveRequest;
    }

    /**
     * 
     * @param xusapActiveRequest
     *     the value for the xusapActiveRequest property
     */
    public void setXusapActiveRequest(XUSAPActiveRequest xusapActiveRequest) {
        this.xusapActiveRequest = xusapActiveRequest;
    }

}
