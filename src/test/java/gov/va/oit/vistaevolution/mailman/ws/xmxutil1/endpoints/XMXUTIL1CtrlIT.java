package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1CtrlEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUTIL1CtrlIT extends VistaLinkContextITParent {

	
	@Autowired
	private XMXUTIL1CtrlEndpoint service;
	
	private XMXUTIL1CtrlRequest request;
	private XMXUTIL1CtrlResponse response;
	
	public XMXUTIL1CtrlIT() {
		// TODO Auto-generated constructor stub
	}

	
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
	public void jtestCntrl001() throws VistaWebServiceFault {
		String testResponse = "this is a string with control c  and a control b ";	// this is the correct response - leave in ^s
		char ctrlB = 0x2; 
		char ctrlC = 0x3;
		String inputStr = "this is a string with control c " + Character.toString(ctrlC) + " and a control b " + Character.toString(ctrlB);
		request = new XMXUTIL1CtrlRequest(inputStr);

		response = service.Ctrl(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCleanedVal());

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
	public void jtestCtrl002() throws VistaWebServiceFault {
		String testResponse = "this is a string with no control characters";	
		
		request = new XMXUTIL1CtrlRequest(testResponse);

		response = service.Ctrl(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCleanedVal());

	
	}
}
