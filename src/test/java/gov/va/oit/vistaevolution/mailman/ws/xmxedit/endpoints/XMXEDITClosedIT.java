/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 * 
 */
public class XMXEDITClosedIT extends EvolutionIT<XMXEDITClosedEndpoint> {

	/**
	 * <pre>
	 * Create a message and send it
	 *  >S XMDUZ=DUZ,XMSUBJ="XMWSOA CLOSED TOGGLE TEST",MSG(1)="CLOSED TOGGLE"
	 *  >S XMTO(.6)="",XMINSTR("FLAGS")=""
	 *  >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,.XMINSTR)
	 *  >ZW RETURN
	 *  RETURN=73973 (any number here is good)
	 * 
	 *  Close the message
	 *  >S XMZ=RETURN,XMINSTR(â€œFLAGSâ€�)=â€�Xâ€�
	 *  >D CLOSED^XMWSOA08(.RET,XMZ,.XMINSTR)
	 *  >ZW RET
	 *  RET=â€�0^â€™Closedâ€™ flag removed.^â€�
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testClosed001() throws VistaWebServiceFault {

		XMXEDITClosedRequest request = new XMXEDITClosedRequest();
		// XMXAPIAddrNSndResponse msgResponse = this.createMessage();

		// request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("X");

		XMXEDITClosedResponse response = service.closed(request);
		assertNotNull(response);
		assertEquals("Closed", response.getMessage());
		assertEquals("flag removed.^", response.getSpecial());
	}

	/**
	 * <pre>
	 * Create a message and send it
	 * >S XMDUZ=DUZ,XMSUBJ="XMWSOA CLOSED TOGGLE TEST",MSG(1)="CLOSED TOGGLE"
	 * >S XMTO(.6)="",XMINSTR("FLAGS")=""
	 * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,.XMINSTR)
	 * >ZW RETURN
	 * RETURN=73973 (any number here is good)
	 * 
	 * Close the message
	 * >S XMZ=RETURN,XMINSTR(â€œFLAGSâ€�)=â€�PIXCSRFâ€�
	 * >D CLOSED^XMWSOA08(.RET,XMZ,.XMINSTR)
	 * >ZW RET
	 * RET=â€�0^â€™Closedâ€™ flag removed.^PICSRFâ€�
	 * </pre>
	 */
	@Test @Ignore
	public void testClosed002() throws VistaWebServiceFault {

		XMXEDITClosedRequest request = new XMXEDITClosedRequest();
		// XMXAPIAddrNSndResponse msgResponse = this.createMessage();

		// request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("PICSRF");

		XMXEDITClosedResponse response = service.closed(request);
		assertNotNull(response);
		assertEquals("Closed", response.getMessage());
	}

	/**
	 * <pre>
	 * This tests when a message is not in the system
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test @Ignore
	public void testClosed003() throws VistaWebServiceFault {

		XMXEDITClosedRequest request = new XMXEDITClosedRequest();

		request.setXmz("7");
		request.setXminstr("PICSRF");

		XMXEDITClosedResponse response = service.closed(request);
		assertNotNull(response);
		// assertEquals("Message not found", service.getMessage());
		assertEquals(null, response.getSpecial());
	}

	@Override
	protected Class<XMXEDITClosedEndpoint> getType() {
		return XMXEDITClosedEndpoint.class;
	}

	// protected XMXAPIAddrNSndResponse createMessage() {
	//
	// XMXAPIAddrNSndRequest msgRequest = new XMXAPIAddrNSndRequest();
	//
	// ArrayList<String> msg = new ArrayList<String>();
	// msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	// msg.add("ZZ BASE Test case for API CLOSED^XMXEDIT");
	//
	// ArrayList<String> xmto = new ArrayList<String>();
	// xmto.add("CUNNINGHAM, ALLEN");
	//
	// String duz = "1";
	// String xmDuz = "1";
	// String xmSubj = "ZZ VISTA API EXPOSURE CLOSED^XMXEDIT";
	// String xmStrip = "";
	// String xmInstr = "I";
	//
	// msgRequest.setDuz(duz);
	// msgRequest.setXmDuz(xmDuz);
	// msgRequest.setXmSubj(xmSubj);
	// msgRequest.setXmz(msg);
	// msgRequest.setXmStrip(xmStrip);
	// msgRequest.setXmto(xmto);
	// msgRequest.setXmInstr(xmInstr);
	//
	// return msgService.AddrNSnd(msgRequest);
	// }

}
