package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4BNSTAEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BNSTAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTAResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4BNSTATest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BNSTATest() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up billing facility name using Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 				>S STA="665"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$BNSTA^XUAF4(STA)
	 * 
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN="ZTEST API BNSTA-XUAF4"
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testBNSTA001() throws VistaWebServiceFault {

		String testResponse = "ZTEST API BNSTA-XUAF4";

		XUAF4BNSTARequest request = new XUAF4BNSTARequest();
		request.setSta("665");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		XUAF4BNSTAEndpoint service = new XUAF4BNSTAEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4BNSTAResponse response = service.BNSTA(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getFacilityName());

	}

	/**
	 * <em>Test Case #2    Look Up bogus billing facility 
	 * name using Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 				>S STA="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$BNSTA^XUAF4(STA)
	 * 
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN=""
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testBNSTA002() throws VistaWebServiceFault {

		String testResponse = "";

		XUAF4BNSTARequest request = new XUAF4BNSTARequest();
		request.setSta("999999999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		XUAF4BNSTAEndpoint service = new XUAF4BNSTAEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4BNSTAResponse response = service.BNSTA(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getFacilityName());

	}

}
