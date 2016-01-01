package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil3QDResponse extends AbstractXMXUtil3Response {

    @XmlElement(required = false)
    private String to;

    @XmlElement(required = false)
    private String toId;

    @XmlElement(required = false)
    private String fwdByDuz;

    @XmlElement(required = false)
    private String fwdBy;

    @XmlElement(required = false)
    private String fwdOn;

    @XmlElement(required = false)
    private String fwdByOrig;

    @XmlElement(required = false)
    private String fwdTypeOrig;

}
