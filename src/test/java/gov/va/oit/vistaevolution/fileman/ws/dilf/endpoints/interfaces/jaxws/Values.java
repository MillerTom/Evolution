
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesRequest;

@XmlRootElement(name = "DILFValues", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFValues", namespace = "http://vistaevolution.va.gov")
public class Values {

    @XmlElement(name = "DILFValuesRequest", namespace = "")
    private DILFValuesRequest dilfValuesRequest;

    /**
     * 
     * @return
     *     returns DILFValuesRequest
     */
    public DILFValuesRequest getDilfValuesRequest() {
        return this.dilfValuesRequest;
    }

    /**
     * 
     * @param dilfValuesRequest
     *     the value for the dilfValuesRequest property
     */
    public void setDilfValuesRequest(DILFValuesRequest dilfValuesRequest) {
        this.dilfValuesRequest = dilfValuesRequest;
    }

}
