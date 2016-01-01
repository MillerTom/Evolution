
package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;

@XmlRootElement(name = "XMAD2BsktResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMAD2BsktResponse", namespace = "http://vistaevolution.va.gov")
public class BsktResponse {

    @XmlElement(name = "return", namespace = "")
    private XMAD2BsktResponse _return;

    /**
     * 
     * @return
     *     returns XMAD2BsktResponse
     */
    public XMAD2BsktResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMAD2BsktResponse _return) {
        this._return = _return;
    }

}
