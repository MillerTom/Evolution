
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaRequest;

@XmlRootElement(name = "DILFDa", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDa", namespace = "http://vistaevolution.va.gov")
public class Da {

    @XmlElement(name = "DILFDaRequest", namespace = "")
    private DILFDaRequest dilfDaRequest;

    /**
     * 
     * @return
     *     returns DILFDaRequest
     */
    public DILFDaRequest getDilfDaRequest() {
        return this.dilfDaRequest;
    }

    /**
     * 
     * @param dilfDaRequest
     *     the value for the dilfDaRequest property
     */
    public void setDilfDaRequest(DILFDaRequest dilfDaRequest) {
        this.dilfDaRequest = dilfDaRequest;
    }

}
