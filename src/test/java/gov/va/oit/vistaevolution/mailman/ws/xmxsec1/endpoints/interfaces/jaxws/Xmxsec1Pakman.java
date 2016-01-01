
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest;

@XmlRootElement(name = "XMXSEC1Pakman", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXSEC1Pakman", namespace = "http://vistaevolution.va.gov")
public class Xmxsec1Pakman {

    @XmlElement(name = "XMXSEC1Pakman", namespace = "")
    private XMXSEC1PakmanRequest xmxsec1Pakman;

    /**
     * 
     * @return
     *     returns XMXSEC1PakmanRequest
     */
    public XMXSEC1PakmanRequest getXmxsec1Pakman() {
        return this.xmxsec1Pakman;
    }

    /**
     * 
     * @param xmxsec1Pakman
     *     the value for the xmxsec1Pakman property
     */
    public void setXmxsec1Pakman(XMXSEC1PakmanRequest xmxsec1Pakman) {
        this.xmxsec1Pakman = xmxsec1Pakman;
    }

}
