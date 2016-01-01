
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest;

@XmlRootElement(name = "DILFDRoot", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDRoot", namespace = "http://vistaevolution.va.gov")
public class Root {

    @XmlElement(name = "DILFDRootRequest", namespace = "")
    private DILFDRootRequest dilfdRootRequest;

    /**
     * 
     * @return
     *     returns DILFDRootRequest
     */
    public DILFDRootRequest getDilfdRootRequest() {
        return this.dilfdRootRequest;
    }

    /**
     * 
     * @param dilfdRootRequest
     *     the value for the dilfdRootRequest property
     */
    public void setDilfdRootRequest(DILFDRootRequest dilfdRootRequest) {
        this.dilfdRootRequest = dilfdRootRequest;
    }

}
