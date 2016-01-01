
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;

@XmlRootElement(name = "HTMLEncodeDecodeResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HTMLEncodeDecodeResponse", namespace = "http://vistaevolution.va.gov")
public class HtmlResponse {

    @XmlElement(name = "return", namespace = "")
    private DILFHtmlResponse _return;

    /**
     * 
     * @return
     *     returns DILFHtmlResponse
     */
    public DILFHtmlResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DILFHtmlResponse _return) {
        this._return = _return;
    }

}
