
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;

@XmlRootElement(name = "XUSTZIPLkCheckResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSTZIPLkCheckResponse", namespace = "http://vistaevolution.va.gov")
public class LkCheckResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSTZIPLkCheckResponse _return;

    /**
     * 
     * @return
     *     returns XUSTZIPLkCheckResponse
     */
    public XUSTZIPLkCheckResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSTZIPLkCheckResponse _return) {
        this._return = _return;
    }

}
