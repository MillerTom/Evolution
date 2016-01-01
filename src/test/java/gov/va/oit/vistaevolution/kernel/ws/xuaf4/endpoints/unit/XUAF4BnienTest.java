/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4BnienEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BnienEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for BNIEN method of XUAF4 Webservice
 */
public class XUAF4BnienTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BnienTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Use the IEN of an institution to return the BILLING FACILITY.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=11555
	 * 
	 * Procedure Call:
	 * >D BNIENR^XUSOAR(.XURET,XUIEN)
	 * 
	 * Expected Output:
	 * >ZW XURET
	 * XURET="TEST BILLING FACILITY"
	 * 
	 * </pre>
	 */
	@Test
	public void testBnien001() throws VistaWebServiceFault {

		String expectedOutput = "TEST BILLING FACILITY";

		XUAF4BnienRequest request = new XUAF4BnienRequest();
		request.setXuien("11555");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4BnienEndpoint service = new XUAF4BnienEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4BnienResponse response = service.bnien(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getBfName());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Use the IEN of a non-existent institution.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=99999
	 * 
	 * Procedure Call:
	 * >D BNIENR^XUSOAR(.XURET,XUIEN)
	 * 
	 * Expected Output:
	 * >ZW XURET
	 * XURET=""
	 * 
	 * </pre>
	 */
	@Test
	public void testBnien002() throws VistaWebServiceFault {

		String expectedOutput = "";

		XUAF4BnienRequest request = new XUAF4BnienRequest();
		request.setXuien("99999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4BnienEndpoint service = new XUAF4BnienEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4BnienResponse response = service.bnien(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getBfName());

	}

}
