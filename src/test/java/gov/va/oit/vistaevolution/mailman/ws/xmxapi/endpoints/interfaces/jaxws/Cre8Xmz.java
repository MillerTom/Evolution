
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZRequest;

@XmlRootElement(name = "XMXAPICre8XMZ", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPICre8XMZ", namespace = "http://vistaevolution.va.gov")
public class Cre8Xmz {

    @XmlElement(name = "XMXAPICre8XMZRequest", namespace = "")
    private XMXAPICre8XMZRequest xmxapiCre8XMZRequest;

    /**
     * 
     * @return
     *     returns XMXAPICre8XMZRequest
     */
    public XMXAPICre8XMZRequest getXmxapiCre8XMZRequest() {
        return this.xmxapiCre8XMZRequest;
    }

    /**
     * 
     * @param xmxapiCre8XMZRequest
     *     the value for the xmxapiCre8XMZRequest property
     */
    public void setXmxapiCre8XMZRequest(XMXAPICre8XMZRequest xmxapiCre8XMZRequest) {
        this.xmxapiCre8XMZRequest = xmxapiCre8XMZRequest;
    }

}
