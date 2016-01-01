/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 * 
 */
public class XMXEDITConfirmIT extends VistaLinkContextITParent {

	@Autowired
	private XMXEDITConfirmEndpoint endpoint;

	@Autowired
	private XMXAPIAddrNSndEndpoint msgService;

	/**
	 * <pre>
	 * >S XMY=999,XMINSTR("FLAGS")="R"
	 * >D CONFIRM^XMWSOA08(.RETURN,XMY,.XMINSTR)
	 * >ZW RETURN
	 * 
	 * RETURN="-1^Message not found"
	 * </pre>
	 */
	@Test @Ignore
	public void testConfirm001() {

		XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();

		request.setXmz("999");
		request.setXminstr("R");

		XMXEDITConfirmResponse response = this.endpoint.confirm(request);
		assertNotNull(response);
		assertEquals("Message not found", response.getMessage());
		assertEquals(null, response.getSpecial());
	}

	/**
	 * <pre>
	 * 
	 * Create a message and send it
	 * >S XMDUZ=DUZ,XMSUBJ="XMWSOA CONFIRM TOGGLE TEST",MSG(1)="CONFIRM TOGGLE"
	 * >S XMTO(.6)="",XMINSTR("FLAGS")="R"
	 * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,.XMINSTR)
	 * >ZW RETURN
	 * RETURN=73973 (any number here is good)
	 * 
	 * Try setting the confirmation flag
	 * >S XMZ=RETURN,XMINSTR("FLAGS")=""
	 * >D CONFIRM^XMWSOA08(.RETURN,XMZ,.XMINSTR)
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test @Ignore
	public void testConfirm002() {

		XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();
		// XMXAPIAddrNSndResponse msgResponse = this.createMessage();

		// request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("");

		XMXEDITConfirmResponse response = this.endpoint.confirm(request);
		assertNotNull(response);
		assertEquals("Error in required input", response.getMessage());
		assertEquals(null, response.getSpecial());
	}

	/**
	 * Create a message and send it >S
	 * XMDUZ=DUZ,XMSUBJ="XMWSOA CONFIRM TOGGLE TEST",MSG(1)="CONFIRM TOGGLE" >S
	 * XMTO(.6)="",XMINSTR("FLAGS")="R" >D
	 * SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,.XMINSTR) >ZW RETURN
	 * RETURN=73973 (any number here is good)
	 * 
	 * Close the message >S XMZ=RETURN,XMINSTR(â€œFLAGSâ€�)=â€�Râ€� >D
	 * CONFIRM^XMWSOA08(.RET,XMZ,.XMINSTR) >ZW RET
	 * RET=="0^'Confirm Receipt Requested' flag removed.^"
	 * 
	 */
	@Test @Ignore
	public void testConfirm003() {

		XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();
		// XMXAPIAddrNSndResponse msgResponse = this.createMessage();

		// request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("R");

		XMXEDITConfirmResponse response = this.endpoint.confirm(request);
		assertNotNull(response);
		assertEquals("Confirm Receipt Requested", response.getMessage());
		assertEquals("flag removed.^", response.getSpecial());
	}

	/**
	 * Create a message and send it >S
	 * XMDUZ=DUZ,XMSUBJ="XMWSOA CONFIRM TOGGLE TEST",MSG(1)="CONFIRM TOGGLE" >S
	 * XMTO(.6)="",XMINSTR("FLAGS")="R" >D
	 * SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,.XMINSTR) >ZW RETURN
	 * RETURN=73973 (any number here is good)
	 * 
	 * Close the message >S XMZ=RETURN,XMINSTR(â€œFLAGSâ€�)=â€�PIXCSRFâ€� >D
	 * CONFIRM^XMWSOA08(.RET,XMZ,.XMINSTR) >ZW RET RET=â€�0^â€™Confirm Receipt
	 * Requestedâ€™ flag removed.^PIXCSFâ€�
	 */
	@Test @Ignore
	public void testConfirm004() {

		XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();
		// XMXAPIAddrNSndResponse msgResponse = this.createMessage();

		// request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("PIXCSRF");

		XMXEDITConfirmResponse response = this.endpoint.confirm(request);
		assertNotNull(response);
		assertEquals("Confirm Receipt Requested", response.getMessage());
		assertEquals("flag removed.^PIXCSF", response.getSpecial());
	}

	// protected XMXAPIAddrNSndResponse createMessage() {
	//
	// XMXAPIAddrNSndRequest msgRequest = new XMXAPIAddrNSndRequest();
	//
	// ArrayList<String> msg = new ArrayList<String>();
	// msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	// msg.add("ZZ BASE Test case for API CONFIRM^XMXEDIT");
	//
	// ArrayList<String> xmto = new ArrayList<String>();
	// xmto.add(".6");
	//
	// String duz = "1";
	// String xmDuz = "1";
	// String xmSubj = "XMWSOA CONFIRM TOGGLE TEST";
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
