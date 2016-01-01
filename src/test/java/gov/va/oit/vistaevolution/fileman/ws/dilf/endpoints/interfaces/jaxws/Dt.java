
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtRequest;

@XmlRootElement(name = "DILFDt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFDt", namespace = "http://vistaevolution.va.gov")
public class Dt {

    @XmlElement(name = "DILFDtRequest", namespace = "")
    private DILFDtRequest dilfDtRequest;

    /**
     * 
     * @return
     *     returns DILFDtRequest
     */
    public DILFDtRequest getDilfDtRequest() {
        return this.dilfDtRequest;
    }

    /**
     * 
     * @param dilfDtRequest
     *     the value for the dilfDtRequest property
     */
    public void setDilfDtRequest(DILFDtRequest dilfDtRequest) {
        this.dilfDtRequest = dilfDtRequest;
    }

}
