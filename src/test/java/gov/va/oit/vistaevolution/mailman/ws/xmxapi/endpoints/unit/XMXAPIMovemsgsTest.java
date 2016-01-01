package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIMovemsgsEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for MOVEMSGS method of XMXAPI Webservice
 */
public class XMXAPIMovemsgsTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIMovemsgsTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=""
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs001() throws VistaWebServiceFault {

		String expectedOutput = "ERROR,-1^Error in required input";

		XMXAPIMovemsgsRequest request = new XMXAPIMovemsgsRequest();
		request.setDuz("");
		request.setXmDuz(".5");
		request.setXmk(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIMovemsgsEndpoint service = new XMXAPIMovemsgsEndpointImpl(
				getVistaLinkContext(), new XMXAPIResponseFactory());

		XMXAPIMovemsgsResponse response = service.movemsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. The user is not a recipient of the mail message.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^You are neither the originator nor a recipient of this message. ^If you need to see it, ask someone to forward it to you."
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs002() throws VistaWebServiceFault {

		String expectedOutput = "-1^You are neither the originator nor a recipient of this message. ^If you need to see it, ask someone to forward it to you.";

		XMXAPIMovemsgsRequest request = new XMXAPIMovemsgsRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmk(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIMovemsgsEndpoint service = new XMXAPIMovemsgsEndpointImpl(
				getVistaLinkContext(), new XMXAPIResponseFactory());

		XMXAPIMovemsgsResponse response = service.movemsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
