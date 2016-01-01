
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest;

@XmlRootElement(name = "XMXUTILKvapor", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILKvapor", namespace = "http://vistaevolution.va.gov")
public class Kvapor {

    @XmlElement(name = "XMXUTILKvaporRequest", namespace = "")
    private XMXUTILKvaporRequest xmxutilKvaporRequest;

    /**
     * 
     * @return
     *     returns XMXUTILKvaporRequest
     */
    public XMXUTILKvaporRequest getXmxutilKvaporRequest() {
        return this.xmxutilKvaporRequest;
    }

    /**
     * 
     * @param xmxutilKvaporRequest
     *     the value for the xmxutilKvaporRequest property
     */
    public void setXmxutilKvaporRequest(XMXUTILKvaporRequest xmxutilKvaporRequest) {
        this.xmxutilKvaporRequest = xmxutilKvaporRequest;
    }

}
