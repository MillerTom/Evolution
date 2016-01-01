package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1CtrlEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1CtrlEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

public class XMXUTIL1CtrlTest extends VistaLinkContextTestParent {

	public XMXUTIL1CtrlTest() {
		super();
	}
	
	/**
	 * <em>Strip control characters from a string!! 
	 * 
	 *  Test a string with no control characters!</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>Set STRING=”String with no control chars”
				
				Procedure Call:
				
				>S DATA=$$Ctrl^XMXUTIL1(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA="String with no control chars"

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1Ctrl001() throws VistaWebServiceFault {
		String testResponse = "test, string with no control chars";	// this is the correct response - leave in ^s
		
		XMXUTIL1CtrlRequest request = new XMXUTIL1CtrlRequest("test, string with no control chars");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUTIL1CtrlEndpoint service = new XMXUTIL1CtrlEndpointImpl(new XMXUTIL1ResponseFactory(), getVistaLinkContext() );

		XMXUTIL1CtrlResponse response = service.Ctrl(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getCleanedVal());	// assertEquals(null == input) 
	}	// end test 1

	/**
	 * <em>Strip control characters from a string!! 
	 * 
	 *  Test a string with control characters!</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>Set STRING=”"this is a test with control c " + Character.toString(ctrlC) + " and a control b " + Character.toString(ctrlB);”
				
				Procedure Call:
				
				>S DATA=$$Ctrl^XMXUTIL1(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA="this is a test with control c and a control b"

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1Ctrl002() throws VistaWebServiceFault {
		String testResponse = "test, this is a string with control c  and a control b ";	// this is the correct response - leave in ^s
		char ctrlB = 0x2; 
		char ctrlC = 0x3;
		String inputStr = "test, this is a string with control c " + Character.toString(ctrlC) + " and a control b " + Character.toString(ctrlB);
		XMXUTIL1CtrlRequest request = new XMXUTIL1CtrlRequest(inputStr);
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUTIL1CtrlEndpoint service = new XMXUTIL1CtrlEndpointImpl(new XMXUTIL1ResponseFactory(), getVistaLinkContext() );

		XMXUTIL1CtrlResponse response = service.Ctrl(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getCleanedVal());	// assertEquals(null == input) 
	}	// end test 1
}
