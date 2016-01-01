package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4LKUPEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4LKUPEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4LKUPTest extends VistaLinkContextTestParent {

	public XUAF4LKUPTest() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up Institution by Station Name</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="OFFICE OF INFORMATION SRV CNTR"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=468
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP001() throws VistaWebServiceFault {

		String testResponse = "468";

		XUAF4LKUPRequest request = new XUAF4LKUPRequest();
		request.setInst("OFFICE OF INFORMATION SRV CNTR");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		XUAF4LKUPEndpoint service = new XUAF4LKUPEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4LKUPResponse response = service.LKUP(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getIen());

	}

	/**
	 * <em>Test Case #2    Look Up Institution by IEN</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="`468"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=468
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP002() throws VistaWebServiceFault {

		String testResponse = "468";

		XUAF4LKUPRequest request = new XUAF4LKUPRequest();
		request.setInst("`468");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		XUAF4LKUPEndpoint service = new XUAF4LKUPEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4LKUPResponse response = service.LKUP(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getIen());

	}

}
