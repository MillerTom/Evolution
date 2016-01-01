
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest;

@XmlRootElement(name = "DIALOGBld", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIALOGBld", namespace = "http://vistaevolution.va.gov")
public class Bld {

    @XmlElement(name = "DIALOGBldRequest", namespace = "")
    private DIALOGBldRequest dialogBldRequest;

    /**
     * 
     * @return
     *     returns DIALOGBldRequest
     */
    public DIALOGBldRequest getDialogBldRequest() {
        return this.dialogBldRequest;
    }

    /**
     * 
     * @param dialogBldRequest
     *     the value for the dialogBldRequest property
     */
    public void setDialogBldRequest(DIALOGBldRequest dialogBldRequest) {
        this.dialogBldRequest = dialogBldRequest;
    }

}
