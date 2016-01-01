
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlRequest;

@XmlRootElement(name = "HTMLEncodeDecode", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HTMLEncodeDecode", namespace = "http://vistaevolution.va.gov")
public class Html {

    @XmlElement(name = "DILFHtmlRequest", namespace = "")
    private DILFHtmlRequest dilfHtmlRequest;

    /**
     * 
     * @return
     *     returns DILFHtmlRequest
     */
    public DILFHtmlRequest getDilfHtmlRequest() {
        return this.dilfHtmlRequest;
    }

    /**
     * 
     * @param dilfHtmlRequest
     *     the value for the dilfHtmlRequest property
     */
    public void setDilfHtmlRequest(DILFHtmlRequest dilfHtmlRequest) {
        this.dilfHtmlRequest = dilfHtmlRequest;
    }

}
