
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefRequest;

@XmlRootElement(name = "DILFORef", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFORef", namespace = "http://vistaevolution.va.gov")
public class Oref {

    @XmlElement(name = "DILFORefRequest", namespace = "")
    private DILFORefRequest dilfoRefRequest;

    /**
     * 
     * @return
     *     returns DILFORefRequest
     */
    public DILFORefRequest getDilfoRefRequest() {
        return this.dilfoRefRequest;
    }

    /**
     * 
     * @param dilfoRefRequest
     *     the value for the dilfoRefRequest property
     */
    public void setDilfoRefRequest(DILFORefRequest dilfoRefRequest) {
        this.dilfoRefRequest = dilfoRefRequest;
    }

}
