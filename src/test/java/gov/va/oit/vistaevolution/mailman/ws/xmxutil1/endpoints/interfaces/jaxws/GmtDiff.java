
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffRequest;

@XmlRootElement(name = "XMXUTIL1GMTDiff", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1GMTDiff", namespace = "http://vistaevolution.va.gov")
public class GmtDiff {

    @XmlElement(name = "arg0", namespace = "")
    private XMXUTIL1GMTDiffRequest arg0;

    /**
     * 
     * @return
     *     returns XMXUTIL1GMTDiffRequest
     */
    public XMXUTIL1GMTDiffRequest getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(XMXUTIL1GMTDiffRequest arg0) {
        this.arg0 = arg0;
    }

}
