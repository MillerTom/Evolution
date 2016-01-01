/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2LineResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String numOfLines;

    /**
	 * 
	 */
    public XMXUtil2LineResponse() {
    }

    public XMXUtil2LineResponse(String status, List<String> errors) {
	super(status, errors);
    }

    /**
     * @param numOfLines
     */
    public XMXUtil2LineResponse(String numOfLines) {
	super();
	this.numOfLines = numOfLines;
    }

    public String getNumOfLines() {
	return this.numOfLines;
    }

    protected void setNumOfLines(String numOfLines) {
	this.numOfLines = numOfLines;
    }

}