
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;

@XmlRootElement(name = "DILFCrefResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFCrefResponse", namespace = "http://vistaevolution.va.gov")
public class CrefResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFCrefResponse _return;

    /**
     * 
     * @return
     *     returns DILFCrefResponse
     */
    public DILFCrefResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFCrefResponse _return) {
        this._return = _return;
    }

}
