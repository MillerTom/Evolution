
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest;

@XmlRootElement(name = "XUSNPIChkDgt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSNPIChkDgt", namespace = "http://vistaevolution.va.gov")
public class ChkDgt {

    @XmlElement(name = "XUSNPIChkDgtRequest", namespace = "")
    private XUSNPIChkDgtRequest xusnpiChkDgtRequest;

    /**
     * 
     * @return
     *     returns XUSNPIChkDgtRequest
     */
    public XUSNPIChkDgtRequest getXusnpiChkDgtRequest() {
        return this.xusnpiChkDgtRequest;
    }

    /**
     * 
     * @param xusnpiChkDgtRequest
     *     the value for the xusnpiChkDgtRequest property
     */
    public void setXusnpiChkDgtRequest(XUSNPIChkDgtRequest xusnpiChkDgtRequest) {
        this.xusnpiChkDgtRequest = xusnpiChkDgtRequest;
    }

}
