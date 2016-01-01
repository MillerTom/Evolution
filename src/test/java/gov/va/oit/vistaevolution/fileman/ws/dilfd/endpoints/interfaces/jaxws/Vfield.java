
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest;

@XmlRootElement(name = "DILFDVfield", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDVfield", namespace = "http://vistaevolution.va.gov")
public class Vfield {

    @XmlElement(name = "DILFDVfieldRequest", namespace = "")
    private DILFDVfieldRequest dilfdVfieldRequest;

    /**
     * 
     * @return
     *     returns DILFDVfieldRequest
     */
    public DILFDVfieldRequest getDilfdVfieldRequest() {
        return this.dilfdVfieldRequest;
    }

    /**
     * 
     * @param dilfdVfieldRequest
     *     the value for the dilfdVfieldRequest property
     */
    public void setDilfdVfieldRequest(DILFDVfieldRequest dilfdVfieldRequest) {
        this.dilfdVfieldRequest = dilfdVfieldRequest;
    }

}
