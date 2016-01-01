
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkRequest;

@XmlRootElement(name = "chk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chk", namespace = "http://vistaevolution.va.gov")
public class Chk {

    @XmlElement(name = "DIEChkRequest", namespace = "")
    private DIEChkRequest dieChkRequest;

    /**
     * 
     * @return
     *     returns DIEChkRequest
     */
    public DIEChkRequest getDieChkRequest() {
        return this.dieChkRequest;
    }

    /**
     * 
     * @param dieChkRequest
     *     the value for the dieChkRequest property
     */
    public void setDieChkRequest(DIEChkRequest dieChkRequest) {
        this.dieChkRequest = dieChkRequest;
    }

}
