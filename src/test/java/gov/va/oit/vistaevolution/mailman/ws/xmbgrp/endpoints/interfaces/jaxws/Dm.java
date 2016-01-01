
package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmRequest;

@XmlRootElement(name = "XMBGRPDm", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMBGRPDm", namespace = "http://vistaevolution.va.gov")
public class Dm {

    @XmlElement(name = "XMBGRPDmRequest", namespace = "")
    private XMBGRPDmRequest xmbgrpDmRequest;

    /**
     * 
     * @return
     *     returns XMBGRPDmRequest
     */
    public XMBGRPDmRequest getXmbgrpDmRequest() {
        return this.xmbgrpDmRequest;
    }

    /**
     * 
     * @param xmbgrpDmRequest
     *     the value for the xmbgrpDmRequest property
     */
    public void setXmbgrpDmRequest(XMBGRPDmRequest xmbgrpDmRequest) {
        this.xmbgrpDmRequest = xmbgrpDmRequest;
    }

}
