
package gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCRequest;

@XmlRootElement(name = "valC", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valC", namespace = "http://vistaevolution.va.gov")
public class ValC {

    @XmlElement(name = "DDR3ValCRequest", namespace = "")
    private DDR3ValCRequest ddr3ValCRequest;

    /**
     * 
     * @return
     *     returns DDR3ValCRequest
     */
    public DDR3ValCRequest getDdr3ValCRequest() {
        return this.ddr3ValCRequest;
    }

    /**
     * 
     * @param ddr3ValCRequest
     *     the value for the ddr3ValCRequest property
     */
    public void setDdr3ValCRequest(DDR3ValCRequest ddr3ValCRequest) {
        this.ddr3ValCRequest = ddr3ValCRequest;
    }

}
