package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil3QLResponse extends AbstractXMXUtil3Response {
    @XmlElement(required = false)
    private String byDuz;

    @XmlElement(required = false)
    private String byName;

    @XmlElement(required = false)
    private String when;

    @XmlElement(required = false)
    private String whenMm;
}
