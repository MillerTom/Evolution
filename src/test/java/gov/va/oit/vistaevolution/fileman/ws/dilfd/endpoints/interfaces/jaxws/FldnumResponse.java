
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;

@XmlRootElement(name = "DILFDFldnumResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDFldnumResponse", namespace = "http://vistaevolution.va.gov")
public class FldnumResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFDFldnumResponse _return;

    /**
     * 
     * @return
     *     returns DILFDFldnumResponse
     */
    public DILFDFldnumResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFDFldnumResponse _return) {
        this._return = _return;
    }

}
