
package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;

@XmlRootElement(name = "DDR2Find1C", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDR2Find1C", namespace = "http://vistaevolution.va.gov")
public class Find1C {

    @XmlElement(name = "DDR2Find1CRequest", namespace = "")
    private DDR2Find1CRequest ddr2Find1CRequest;

    /**
     * 
     * @return
     *     returns DDR2Find1CRequest
     */
    public DDR2Find1CRequest getDdr2Find1CRequest() {
        return this.ddr2Find1CRequest;
    }

    /**
     * 
     * @param ddr2Find1CRequest
     *     the value for the ddr2Find1CRequest property
     */
    public void setDdr2Find1CRequest(DDR2Find1CRequest ddr2Find1CRequest) {
        this.ddr2Find1CRequest = ddr2Find1CRequest;
    }

}
