package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIGGotLocalRequest extends AbstractVistaRequest {

    @XmlElement(name = "group", required = false)
    private String GROUP;

    @XmlElement(name = "xdays", required = false)
    private String XDAYS;

    public XMXAPIGGotLocalRequest() {
	super();
    }

    public String getGROUP() {
	return GROUP;
    }

    public void setGROUP(String gROUP) {
	GROUP = gROUP;
    }

    public String getXDAYS() {
	return XDAYS;
    }

    public void setXDAYS(String xDAYS) {
	XDAYS = xDAYS;
    }

}
