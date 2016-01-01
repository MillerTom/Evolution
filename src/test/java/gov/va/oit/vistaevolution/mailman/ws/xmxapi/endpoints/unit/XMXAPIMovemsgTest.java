/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIMovemsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for MOVEMSG method of XMXAPI Webservice
 */
public class XMXAPIMovemsgTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIMovemsgTest() {
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
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg001() throws VistaWebServiceFault {

		String expectedOutput = "ERROR,-1^Error in required input";

		XMXAPIMovemsgRequest request = new XMXAPIMovemsgRequest();
		request.setDuz("");
		request.setXmDuz(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIMovemsgEndpoint service = new XMXAPIMovemsgEndpointImpl(
				getVistaLinkContext(), new XMXAPIResponseFactory());

		XMXAPIMovemsgResponse response = service.movemsg(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. The user is not a recipient of the mail message
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^You are neither the originator nor a recipient of this message.^If you need to see it, ask someone to forward it to you."
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg002() throws VistaWebServiceFault {

		String expectedOutput = "-1^You are neither the originator nor a recipient of this message.^If you need to see it, ask someone to forward it to you.";

		XMXAPIMovemsgRequest request = new XMXAPIMovemsgRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIMovemsgEndpoint service = new XMXAPIMovemsgEndpointImpl(
				getVistaLinkContext(), new XMXAPIResponseFactory());

		XMXAPIMovemsgResponse response = service.movemsg(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
