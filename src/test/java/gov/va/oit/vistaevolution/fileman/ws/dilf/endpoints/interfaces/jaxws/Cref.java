
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefRequest;

@XmlRootElement(name = "DILFCref", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFCref", namespace = "http://vistaevolution.va.gov")
public class Cref {

    @XmlElement(name = "DILFCrefRequest", namespace = "")
    private DILFCrefRequest dilfCrefRequest;

    /**
     * 
     * @return
     *     returns DILFCrefRequest
     */
    public DILFCrefRequest getDilfCrefRequest() {
        return this.dilfCrefRequest;
    }

    /**
     * 
     * @param dilfCrefRequest
     *     the value for the dilfCrefRequest property
     */
    public void setDilfCrefRequest(DILFCrefRequest dilfCrefRequest) {
        this.dilfCrefRequest = dilfCrefRequest;
    }

}
