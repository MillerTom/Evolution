
package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;

@XmlRootElement(name = "DICListResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DICListResponse", namespace = "http://vistaevolution.va.gov")
public class ListResponse {

    @XmlElement(name = "return", namespace = "")
    private DICListResponse _return;

    /**
     * 
     * @return
     *     returns DICListResponse
     */
    public DICListResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DICListResponse _return) {
        this._return = _return;
    }

}
