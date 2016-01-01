
package gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCResponse;

@XmlRootElement(name = "valCResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valCResponse", namespace = "http://vistaevolution.va.gov")
public class ValCResponse {

    @XmlElement(name = "return", namespace = "")
    private DDR3ValCResponse _return;

    /**
     * 
     * @return
     *     returns DDR3ValCResponse
     */
    public DDR3ValCResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DDR3ValCResponse _return) {
        this._return = _return;
    }

}
