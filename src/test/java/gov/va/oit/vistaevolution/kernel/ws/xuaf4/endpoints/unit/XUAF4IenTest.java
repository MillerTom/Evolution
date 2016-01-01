/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4IenEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4IenEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for IEN method of XUAF4 Webservice
 */
public class XUAF4IenTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUAF4IenTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Lookup a Station Number and return its IEN value.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUSTA="101"
	 * 
	 * Procedure Call:
	 * >D IENR^XUSOAR(.RETURN,XUSTA)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=101
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testIen001() throws VistaWebServiceFault {

		String expectedOutput = "101";

		XUAF4IenRequest request = new XUAF4IenRequest("101");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4IenEndpoint service = new XUAF4IenEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4IenResponse response = service.ien(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIen());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Lookup a null Station Number and return a null value.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUSTA=""
	 * 
	 * Procedure Call:
	 * >D IENR^XUSOAR(.RETURN,XUSTA)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""
	 * 
	 * </pre>
	 */
	@Test
	public void testIen002() throws VistaWebServiceFault {

		String expectedOutput = "";

		XUAF4IenRequest request = new XUAF4IenRequest("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4IenEndpoint service = new XUAF4IenEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4IenResponse response = service.ien(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIen());
	}

}
