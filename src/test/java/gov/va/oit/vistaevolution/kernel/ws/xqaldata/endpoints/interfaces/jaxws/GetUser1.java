
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Request;

@XmlRootElement(name = "XQALDATAGetUser1", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALDATAGetUser1", namespace = "http://vistaevolution.va.gov")
public class GetUser1 {

    @XmlElement(name = "XQALDATAGetUser1Request", namespace = "")
    private XQALDATAGetUser1Request xqaldataGetUser1Request;

    /**
     * 
     * @return
     *     returns XQALDATAGetUser1Request
     */
    public XQALDATAGetUser1Request getXqaldataGetUser1Request() {
        return this.xqaldataGetUser1Request;
    }

    /**
     * 
     * @param xqaldataGetUser1Request
     *     the value for the xqaldataGetUser1Request property
     */
    public void setXqaldataGetUser1Request(XQALDATAGetUser1Request xqaldataGetUser1Request) {
        this.xqaldataGetUser1Request = xqaldataGetUser1Request;
    }

}
