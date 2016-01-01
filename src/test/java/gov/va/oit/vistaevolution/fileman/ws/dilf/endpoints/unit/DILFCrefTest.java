package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFCrefEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFCrefEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for Cref method of DILF Webservice
 */
public class DILFCrefTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DILFCrefTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * global with ending comma
	 * 
	 * <pre>
	 * 	 >S GLB="^DIZ(99999,"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="^DIZ(99999)"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref001() throws VistaWebServiceFault {

		String expectedOutput = "^DIZ(99999)";

		DILFCrefRequest request = new DILFCrefRequest();
		request.setOpenRoot("^DIZ(99999,");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFCrefEndpoint service = new DILFCrefEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFCrefResponse response = service.cref(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getClosedRoot());
	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * null global value
	 * 
	 * <pre>
	 * 	 >S GLB=""
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref002() throws VistaWebServiceFault {

		String expectedOutput = "";

		DILFCrefRequest request = new DILFCrefRequest();
		request.setOpenRoot("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFCrefEndpoint service = new DILFCrefEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFCrefResponse response = service.cref(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getClosedRoot());
	}

}
