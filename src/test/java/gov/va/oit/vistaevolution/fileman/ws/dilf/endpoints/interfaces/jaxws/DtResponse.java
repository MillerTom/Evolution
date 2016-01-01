
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;

@XmlRootElement(name = "DILFDtResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDtResponse", namespace = "http://vistaevolution.va.gov")
public class DtResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFDtResponse _return;

    /**
     * 
     * @return
     *     returns DILFDtResponse
     */
    public DILFDtResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFDtResponse _return) {
        this._return = _return;
    }

}
