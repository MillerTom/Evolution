
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;

@XmlRootElement(name = "DILFValuesResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFValuesResponse", namespace = "http://vistaevolution.va.gov")
public class ValuesResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFValuesResponse _return;

    /**
     * 
     * @return
     *     returns DILFValuesResponse
     */
    public DILFValuesResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFValuesResponse _return) {
        this._return = _return;
    }

}
