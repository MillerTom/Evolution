
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalRequest;

@XmlRootElement(name = "DILFDExternal", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDExternal", namespace = "http://vistaevolution.va.gov")
public class External {

    @XmlElement(name = "DILFDExternalRequest", namespace = "")
    private DILFDExternalRequest dilfdExternalRequest;

    /**
     * 
     * @return
     *     returns DILFDExternalRequest
     */
    public DILFDExternalRequest getDilfdExternalRequest() {
        return this.dilfdExternalRequest;
    }

    /**
     * 
     * @param dilfdExternalRequest
     *     the value for the dilfdExternalRequest property
     */
    public void setDilfdExternalRequest(DILFDExternalRequest dilfdExternalRequest) {
        this.dilfdExternalRequest = dilfdExternalRequest;
    }

}
