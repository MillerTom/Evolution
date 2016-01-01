package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1DecodeUpEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1DecodeUpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXUTIL1DecodeUpTest extends VistaLinkContextTestParent {

	public XMXUTIL1DecodeUpTest() {
		super();
	}
	
	/**
	 * <em>Encode string with an up caret </em>
	 * 
	 * <pre>
				Input Data:
				>Set U=”^”,STRING=”String Containing ^ is converted”
				
				Procedure Call:
				
				>S DATA=$$DecodeUp^XMXUTIL1(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA="String Containing ~U~ is converted"

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1DecodeUp001() throws VistaWebServiceFault {
		String testResponse = "String Containing ^ is converted";	
		
		XMXUTIL1DecodeUpRequest request = new XMXUTIL1DecodeUpRequest("String Containing ~U~ is converted");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUTIL1DecodeUpEndpoint service = new XMXUTIL1DecodeUpEndpointImpl(new XMXUTIL1ResponseFactory(), getVistaLinkContext() );

		XMXUTIL1DecodeUpResponse response = service.DecodeUp(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getDecodedValue());	// assertEquals(null == input) 
	}	// end test 1
	
	/**
	 * <em>string without any ~U~ is not changed </em>
	 * 
	 * <pre>
				Input Data:
				>Set U=”^”,STRING=”"String with no correct sequence is not changed"”
				
				Procedure Call:
				
				>S DATA=$$DecodeUp^XMXUTIL1(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA=""String with no correct sequence is not changed""

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1DecodeUp002() throws VistaWebServiceFault {
		String testResponse = "String with no correct sequence is not changed";	// this is the correct response - leave in ^s
		
		XMXUTIL1DecodeUpRequest request = new XMXUTIL1DecodeUpRequest("String with no correct sequence is not changed");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUTIL1DecodeUpEndpoint service = new XMXUTIL1DecodeUpEndpointImpl(new XMXUTIL1ResponseFactory(), getVistaLinkContext() );

		XMXUTIL1DecodeUpResponse response = service.DecodeUp(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getDecodedValue());	// assertEquals(null == input) 
	}	// end test 2
	
	/**
	 * <em>string with ^ is not changed </em>
	 * 
	 * <pre>
				Input Data:
				>Set U=”^”,STRING=”"String with ^ is not changed"”
				
				Procedure Call:
				
				>S DATA=$$DecodeUp^XMXUTIL1(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA=""String with no correct sequence is not changed""

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1DecodeUp003() throws VistaWebServiceFault {
		String testResponse = "String with ^ is not changed";	// this is the correct response - leave in ^s
		
		XMXUTIL1DecodeUpRequest request = new XMXUTIL1DecodeUpRequest("String with ^ is not changed");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUTIL1DecodeUpEndpoint service = new XMXUTIL1DecodeUpEndpointImpl(new XMXUTIL1ResponseFactory(), getVistaLinkContext() );

		XMXUTIL1DecodeUpResponse response = service.DecodeUp(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getDecodedValue());	// assertEquals(null == input) 
	}	// end test 3

}
