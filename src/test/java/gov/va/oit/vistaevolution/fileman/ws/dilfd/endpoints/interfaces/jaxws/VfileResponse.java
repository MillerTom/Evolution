
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;

@XmlRootElement(name = "DILFDVfieldResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDVfieldResponse", namespace = "http://vistaevolution.va.gov")
public class VfileResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFDVfileResponse _return;

    /**
     * 
     * @return
     *     returns DILFDVfileResponse
     */
    public DILFDVfileResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFDVfileResponse _return) {
        this._return = _return;
    }

}
