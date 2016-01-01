
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryRequest;

@XmlRootElement(name = "XQALBUTLAhistory", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALBUTLAhistory", namespace = "http://vistaevolution.va.gov")
public class Ahistory {

    @XmlElement(name = "XQALBUTLAhistoryRequest", namespace = "")
    private XQALBUTLAhistoryRequest xqalbutlAhistoryRequest;

    /**
     * 
     * @return
     *     returns XQALBUTLAhistoryRequest
     */
    public XQALBUTLAhistoryRequest getXqalbutlAhistoryRequest() {
        return this.xqalbutlAhistoryRequest;
    }

    /**
     * 
     * @param xqalbutlAhistoryRequest
     *     the value for the xqalbutlAhistoryRequest property
     */
    public void setXqalbutlAhistoryRequest(XQALBUTLAhistoryRequest xqalbutlAhistoryRequest) {
        this.xqalbutlAhistoryRequest = xqalbutlAhistoryRequest;
    }

}
