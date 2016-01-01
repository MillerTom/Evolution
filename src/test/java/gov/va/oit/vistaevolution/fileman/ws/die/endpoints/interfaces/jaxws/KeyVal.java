
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValRequest;

@XmlRootElement(name = "DIEKeyVal", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIEKeyVal", namespace = "http://vistaevolution.va.gov")
public class KeyVal {

    @XmlElement(name = "DIEKeyValRequest", namespace = "")
    private DIEKeyValRequest dieKeyValRequest;

    /**
     * 
     * @return
     *     returns DIEKeyValRequest
     */
    public DIEKeyValRequest getDieKeyValRequest() {
        return this.dieKeyValRequest;
    }

    /**
     * 
     * @param dieKeyValRequest
     *     the value for the dieKeyValRequest property
     */
    public void setDieKeyValRequest(DIEKeyValRequest dieKeyValRequest) {
        this.dieKeyValRequest = dieKeyValRequest;
    }

}
