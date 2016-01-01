
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpRequest;

@XmlRootElement(name = "help", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "help", namespace = "http://vistaevolution.va.gov")
public class Help {

    @XmlElement(name = "DIEHelpRequest", namespace = "")
    private DIEHelpRequest dieHelpRequest;

    /**
     * 
     * @return
     *     returns DIEHelpRequest
     */
    public DIEHelpRequest getDieHelpRequest() {
        return this.dieHelpRequest;
    }

    /**
     * 
     * @param dieHelpRequest
     *     the value for the dieHelpRequest property
     */
    public void setDieHelpRequest(DIEHelpRequest dieHelpRequest) {
        this.dieHelpRequest = dieHelpRequest;
    }

}
