
package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindRequest;

@XmlRootElement(name = "DICFind", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DICFind", namespace = "http://vistaevolution.va.gov")
public class Find {

    @XmlElement(name = "DICFindRequest", namespace = "")
    private DICFindRequest dicFindRequest;

    /**
     * 
     * @return
     *     returns DICFindRequest
     */
    public DICFindRequest getDicFindRequest() {
        return this.dicFindRequest;
    }

    /**
     * 
     * @param dicFindRequest
     *     the value for the dicFindRequest property
     */
    public void setDicFindRequest(DICFindRequest dicFindRequest) {
        this.dicFindRequest = dicFindRequest;
    }

}
