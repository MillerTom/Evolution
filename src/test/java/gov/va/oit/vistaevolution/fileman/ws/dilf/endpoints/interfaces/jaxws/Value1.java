
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Request;

@XmlRootElement(name = "DILFValue1", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DILFValue1", namespace = "http://vistaevolution.va.gov")
public class Value1 {

    @XmlElement(name = "DILFValue1Request", namespace = "")
    private DILFValue1Request dilfValue1Request;

    /**
     * 
     * @return
     *     returns DILFValue1Request
     */
    public DILFValue1Request getDilfValue1Request() {
        return this.dilfValue1Request;
    }

    /**
     * 
     * @param dilfValue1Request
     *     the value for the dilfValue1Request property
     */
    public void setDilfValue1Request(DILFValue1Request dilfValue1Request) {
        this.dilfValue1Request = dilfValue1Request;
    }

}
