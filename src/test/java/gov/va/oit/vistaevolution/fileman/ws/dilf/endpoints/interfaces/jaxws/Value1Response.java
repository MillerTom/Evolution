
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Response;

@XmlRootElement(name = "DILFValue1Response", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFValue1Response", namespace = "http://vistaevolution.va.gov")
public class Value1Response {

    @XmlElement(name = "return", namespace = "")
    private DILFValue1Response _return;

    /**
     * 
     * @return
     *     returns DILFValue1Response
     */
    public DILFValue1Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFValue1Response _return) {
        this._return = _return;
    }

}
