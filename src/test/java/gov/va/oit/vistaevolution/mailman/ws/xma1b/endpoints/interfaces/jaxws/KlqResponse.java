
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;

@XmlRootElement(name = "XMA1BKlqResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1BKlqResponse", namespace = "http://vistaevolution.va.gov")
public class KlqResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA1BKlqResponse _return;

    /**
     * 
     * @return
     *     returns XMA1BKlqResponse
     */
    public XMA1BKlqResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA1BKlqResponse _return) {
        this._return = _return;
    }

}
