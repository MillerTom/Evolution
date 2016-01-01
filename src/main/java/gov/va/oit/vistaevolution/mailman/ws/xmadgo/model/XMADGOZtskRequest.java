/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * 
 * XMWSOA ZTSK
 * 
 * This RPC starts tasks to deliver messages in local delivery queues. It
 * has no effect if the background filer has been stopped or if the local
 * delivery queues are already active.
 * 
 * Returns:
 *    0^Tasks started to deliver messages in local delivery queues
 *    -1^Background filer set to stop"
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMADGOZtskRequest {

	public XMADGOZtskRequest() {
		super();
	}

}
