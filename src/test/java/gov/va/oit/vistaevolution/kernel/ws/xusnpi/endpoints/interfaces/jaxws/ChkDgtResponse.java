
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;

@XmlRootElement(name = "XUSNPIChkDgtResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSNPIChkDgtResponse", namespace = "http://vistaevolution.va.gov")
public class ChkDgtResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSNPIChkDgtResponse _return;

    /**
     * 
     * @return
     *     returns XUSNPIChkDgtResponse
     */
    public XUSNPIChkDgtResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSNPIChkDgtResponse _return) {
        this._return = _return;
    }

}
