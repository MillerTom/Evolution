
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;

@XmlRootElement(name = "XMA21ChkResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA21ChkResponse", namespace = "http://vistaevolution.va.gov")
public class ChkResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA21ChkResponse _return;

    /**
     * 
     * @return
     *     returns XMA21ChkResponse
     */
    public XMA21ChkResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA21ChkResponse _return) {
        this._return = _return;
    }

}
