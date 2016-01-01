package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4MADDEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4MADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4MADDTest extends VistaLinkContextTestParent {

	public XUAF4MADDTest() {
		super();
	}

	/**
	 * <em>Test Case #1  Look up Institution by IEN and return address</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S XUIEN=6712
	 * 			
	 * 			Procedure Call:
	 * 			>D MADDR^XUSOAR(.RETURN,XUIEN)
	 * 			
	 * 			Expected Output:
	 * 			>ZW RETURN
	 * 			RETURN=" 407 N SALEM AVE^SUMTER^SC^29150-4115"
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testMADD001() throws VistaWebServiceFault {

		String testResponse = " 407 N SALEM AVE^SUMTER^SC^29150-4115";

		XUAF4MADDRequest request = new XUAF4MADDRequest();
		request.setIen("6712");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(null),
						null)).thenReturn(testResponse);

		XUAF4MADDEndpoint service = new XUAF4MADDEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4MADDResponse response = service.MADD(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResult());

	}

	/**
	 * <em>Test Case #2 Lookup an Institution with a bogus IEN and return a null value.</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S INST="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$MADD^XUAF4(INST)
	 * 			
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN=""
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testMADD002() throws VistaWebServiceFault {

		String testResponse = "";

		XUAF4MADDRequest request = new XUAF4MADDRequest();
		request.setIen("999999999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(null),
						null)).thenReturn(testResponse);

		XUAF4MADDEndpoint service = new XUAF4MADDEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4MADDResponse response = service.MADD(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResult());

	}

}
