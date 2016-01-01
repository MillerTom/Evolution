
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;

@XmlRootElement(name = "XMA03RenResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA03RenResponse", namespace = "http://vistaevolution.va.gov")
public class RenResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA03RenResponse _return;

    /**
     * 
     * @return
     *     returns XMA03RenResponse
     */
    public XMA03RenResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA03RenResponse _return) {
        this._return = _return;
    }

}
