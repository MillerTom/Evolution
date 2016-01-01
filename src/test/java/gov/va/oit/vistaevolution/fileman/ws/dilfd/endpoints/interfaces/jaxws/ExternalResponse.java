
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;

@XmlRootElement(name = "DILFDExternalResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDExternalResponse", namespace = "http://vistaevolution.va.gov")
public class ExternalResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFDExternalResponse _return;

    /**
     * 
     * @return
     *     returns DILFDExternalResponse
     */
    public DILFDExternalResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFDExternalResponse _return) {
        this._return = _return;
    }

}
