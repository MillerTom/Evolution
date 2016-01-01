
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest;

@XmlRootElement(name = "XUSTZIPLkCheck", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSTZIPLkCheck", namespace = "http://vistaevolution.va.gov")
public class LkCheck {

    @XmlElement(name = "XUSTZIPLkCheck", namespace = "")
    private XUSTZIPLkCheckRequest xustzipLkCheck;

    /**
     * 
     * @return
     *     returns XUSTZIPLkCheckRequest
     */
    public XUSTZIPLkCheckRequest getXustzipLkCheck() {
        return this.xustzipLkCheck;
    }

    /**
     * 
     * @param xustzipLkCheck
     *     the value for the xustzipLkCheck property
     */
    public void setXustzipLkCheck(XUSTZIPLkCheckRequest xustzipLkCheck) {
        this.xustzipLkCheck = xustzipLkCheck;
    }

}
