
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest;

@XmlRootElement(name = "DILFDFldnum", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDFldnum", namespace = "http://vistaevolution.va.gov")
public class Fldnum {

    @XmlElement(name = "DILFDFldnumRequest", namespace = "")
    private DILFDFldnumRequest dilfdFldnumRequest;

    /**
     * 
     * @return
     *     returns DILFDFldnumRequest
     */
    public DILFDFldnumRequest getDilfdFldnumRequest() {
        return this.dilfdFldnumRequest;
    }

    /**
     * 
     * @param dilfdFldnumRequest
     *     the value for the dilfdFldnumRequest property
     */
    public void setDilfdFldnumRequest(DILFDFldnumRequest dilfdFldnumRequest) {
        this.dilfdFldnumRequest = dilfdFldnumRequest;
    }

}
