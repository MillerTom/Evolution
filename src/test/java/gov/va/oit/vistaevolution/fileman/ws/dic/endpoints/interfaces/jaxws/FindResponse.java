
package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;

@XmlRootElement(name = "DICFindResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DICFindResponse", namespace = "http://vistaevolution.va.gov")
public class FindResponse {

    @XmlElement(name = "return", namespace = "")
    private DICFindResponse _return;

    /**
     * 
     * @return
     *     returns DICFindResponse
     */
    public DICFindResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DICFindResponse _return) {
        this._return = _return;
    }

}
