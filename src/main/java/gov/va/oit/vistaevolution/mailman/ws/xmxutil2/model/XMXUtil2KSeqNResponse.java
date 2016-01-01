/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

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
public class XMXUtil2KSeqNResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String sequenceNumber;

    public String getSequenceNumber() {
	return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }

}
