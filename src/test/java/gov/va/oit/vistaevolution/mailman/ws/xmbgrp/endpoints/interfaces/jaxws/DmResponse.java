
package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmResponse;

@XmlRootElement(name = "XMBGRPDmResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMBGRPDmResponse", namespace = "http://vistaevolution.va.gov")
public class DmResponse {

    @XmlElement(name = "return", namespace = "")
    private XMBGRPDmResponse _return;

    /**
     * 
     * @return
     *     returns XMBGRPDmResponse
     */
    public XMBGRPDmResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMBGRPDmResponse _return) {
        this._return = _return;
    }

}
