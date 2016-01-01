
package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgResponse;

@XmlRootElement(name = "XMBGRPMgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMBGRPMgResponse", namespace = "http://vistaevolution.va.gov")
public class MgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMBGRPMgResponse _return;

    /**
     * 
     * @return
     *     returns XMBGRPMgResponse
     */
    public XMBGRPMgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMBGRPMgResponse _return) {
        this._return = _return;
    }

}
