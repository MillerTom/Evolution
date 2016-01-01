
package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListRequest;

@XmlRootElement(name = "DICList", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DICList", namespace = "http://vistaevolution.va.gov")
public class List {

    @XmlElement(name = "DICListRequest", namespace = "")
    private DICListRequest dicListRequest;

    /**
     * 
     * @return
     *     returns DICListRequest
     */
    public DICListRequest getDicListRequest() {
        return this.dicListRequest;
    }

    /**
     * 
     * @param dicListRequest
     *     the value for the dicListRequest property
     */
    public void setDicListRequest(DICListRequest dicListRequest) {
        this.dicListRequest = dicListRequest;
    }

}
