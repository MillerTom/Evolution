
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest;

@XmlRootElement(name = "DILFDVfield", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDVfield", namespace = "http://vistaevolution.va.gov")
public class Vfile {

    @XmlElement(name = "DILFDVfileRequest", namespace = "")
    private DILFDVfileRequest dilfdVfileRequest;

    /**
     * 
     * @return
     *     returns DILFDVfileRequest
     */
    public DILFDVfileRequest getDilfdVfileRequest() {
        return this.dilfdVfileRequest;
    }

    /**
     * 
     * @param dilfdVfileRequest
     *     the value for the dilfdVfileRequest property
     */
    public void setDilfdVfileRequest(DILFDVfileRequest dilfdVfileRequest) {
        this.dilfdVfileRequest = dilfdVfileRequest;
    }

}
