
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;

@XmlRootElement(name = "DILFDVfieldResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDVfieldResponse", namespace = "http://vistaevolution.va.gov")
public class VfieldResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFDVfieldResponse _return;

    /**
     * 
     * @return
     *     returns DILFDVfieldResponse
     */
    public DILFDVfieldResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFDVfieldResponse _return) {
        this._return = _return;
    }

}
