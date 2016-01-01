
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskRequest;

@XmlRootElement(name = "XMADGOZtsk", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMADGOZtsk", namespace = "http://vistaevolution.va.gov")
public class Ztsk {

    @XmlElement(name = "XMADGOZtsk", namespace = "")
    private XMADGOZtskRequest xmadgoZtsk;

    /**
     * 
     * @return
     *     returns XMADGOZtskRequest
     */
    public XMADGOZtskRequest getXmadgoZtsk() {
        return this.xmadgoZtsk;
    }

    /**
     * 
     * @param xmadgoZtsk
     *     the value for the xmadgoZtsk property
     */
    public void setXmadgoZtsk(XMADGOZtskRequest xmadgoZtsk) {
        this.xmadgoZtsk = xmadgoZtsk;
    }

}
