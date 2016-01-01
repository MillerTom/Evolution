
package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;

@XmlRootElement(name = "XMAD2Bskt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMAD2Bskt", namespace = "http://vistaevolution.va.gov")
public class Bskt {

    @XmlElement(name = "XMAD2BsktRequest", namespace = "")
    private XMAD2BsktRequest xmad2BsktRequest;

    /**
     * 
     * @return
     *     returns XMAD2BsktRequest
     */
    public XMAD2BsktRequest getXmad2BsktRequest() {
        return this.xmad2BsktRequest;
    }

    /**
     * 
     * @param xmad2BsktRequest
     *     the value for the xmad2BsktRequest property
     */
    public void setXmad2BsktRequest(XMAD2BsktRequest xmad2BsktRequest) {
        this.xmad2BsktRequest = xmad2BsktRequest;
    }

}
