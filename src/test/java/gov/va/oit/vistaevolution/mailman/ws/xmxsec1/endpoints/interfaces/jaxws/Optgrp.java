
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpRequest;

@XmlRootElement(name = "XMXSEC1Optgrp", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXSEC1Optgrp", namespace = "http://vistaevolution.va.gov")
public class Optgrp {

    @XmlElement(name = "XMXSEC1OptgrpRequest", namespace = "")
    private XMXSEC1OptgrpRequest xmxsec1OptgrpRequest;

    /**
     * 
     * @return
     *     returns XMXSEC1OptgrpRequest
     */
    public XMXSEC1OptgrpRequest getXmxsec1OptgrpRequest() {
        return this.xmxsec1OptgrpRequest;
    }

    /**
     * 
     * @param xmxsec1OptgrpRequest
     *     the value for the xmxsec1OptgrpRequest property
     */
    public void setXmxsec1OptgrpRequest(XMXSEC1OptgrpRequest xmxsec1OptgrpRequest) {
        this.xmxsec1OptgrpRequest = xmxsec1OptgrpRequest;
    }

}
