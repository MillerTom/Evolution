
package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgRequest;

@XmlRootElement(name = "XMBGRPMg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMBGRPMg", namespace = "http://vistaevolution.va.gov")
public class Mg {

    @XmlElement(name = "XMBGRPMgRequest", namespace = "")
    private XMBGRPMgRequest xmbgrpMgRequest;

    /**
     * 
     * @return
     *     returns XMBGRPMgRequest
     */
    public XMBGRPMgRequest getXmbgrpMgRequest() {
        return this.xmbgrpMgRequest;
    }

    /**
     * 
     * @param xmbgrpMgRequest
     *     the value for the xmbgrpMgRequest property
     */
    public void setXmbgrpMgRequest(XMBGRPMgRequest xmbgrpMgRequest) {
        this.xmbgrpMgRequest = xmbgrpMgRequest;
    }

}
