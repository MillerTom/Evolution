package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1DecodeUpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUTIL1DecodeUpIT extends VistaLinkContextITParent{

	
	@Autowired
	private XMXUTIL1DecodeUpEndpoint service;
	
	private XMXUTIL1DecodeUpRequest request;
	private XMXUTIL1DecodeUpResponse response;
	public XMXUTIL1DecodeUpIT() {
		
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
		
		request = new XMXUTIL1DecodeUpRequest("String Containing ~U~ is converted");
		
		response = service.DecodeUp(request);		
		
		
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
		
		request = new XMXUTIL1DecodeUpRequest("String with no correct sequence is not changed");
		response = service.DecodeUp(request);		
		
		
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
		
		request = new XMXUTIL1DecodeUpRequest("String with ^ is not changed");
		
		response = service.DecodeUp(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getDecodedValue());	// assertEquals(null == input) 
	}	// end test 3


}
