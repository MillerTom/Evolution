package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.XMXSECBcastEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECBcastEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXSECBcastTest extends VistaLinkContextTestParent {

	public XMXSECBcastTest() {
		super();
	}
	
	
	/**
	 * <em>Test Case #1    Look Up Bogus msg using msg id, 
	 * 						return null
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="999999999"

			Procedure Call:
				>S RETURN=$$XMXSEC^BCAST(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN=""

	 * </pre>
	 * 
	 */

	@Test
	public void testBcast001() throws VistaWebServiceFault {
		String testResponse = null;
		
		XMXSECBcastRequest request = new XMXSECBcastRequest("999999999");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSECBcastEndpoint service = new XMXSECBcastEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECBcastResponse response = service.Bcast(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgWasBroadCast());
	}
	
	/**
	 * <em>Test Case #2  Look Up msg that was not broadcasted using msg id, 
	 * 						return 0
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="123"

			Procedure Call:
				>S RETURN=$$XMXSEC^BCAST(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="0"

	 * </pre>
	 * 
	 */

	@Test
	public void testBcast002() throws VistaWebServiceFault {
		String testResponse = "0";
		
		XMXSECBcastRequest request = new XMXSECBcastRequest("123");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSECBcastEndpoint service = new XMXSECBcastEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECBcastResponse response = service.Bcast(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgWasBroadCast());
	}
	/**
	  * <em>Test Case #3   Look Up msg that was broadcasted using msg id, 
	 * 						return 1
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="1234"

			Procedure Call:
				>S RETURN=$$XMXSEC^BCAST(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="1"

	 * </pre>
	 * 
	 */

	@Test
	public void testBcast003() throws VistaWebServiceFault {
		String testResponse = "1";
		
		XMXSECBcastRequest request = new XMXSECBcastRequest("1234");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSECBcastEndpoint service = new XMXSECBcastEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECBcastResponse response = service.Bcast(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgWasBroadCast());
	}

	



}
