package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * File Root Resolver
 * Output Parameter Class:
 *
 * glbName:   Output variable
 *
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDRootResponse {

    @XmlElement(required = true)
    private String glbName;

    /**
     * @return the glbName
     */
    public String getGlbName() {
        return this.glbName;
    }

    /**
     * @param glbName the glbName to set
     */
    public void setGlbName(final String glbName) {
        this.glbName = glbName;
    }

    /**
     * Default Bean Constructor
     */
    public DILFDRootResponse() {
        super();
    }

    /**
     * Constructor initializes the class
     * @param value
     */
    public DILFDRootResponse(final String value) {

        super();
        this.glbName = value;
    }

}
