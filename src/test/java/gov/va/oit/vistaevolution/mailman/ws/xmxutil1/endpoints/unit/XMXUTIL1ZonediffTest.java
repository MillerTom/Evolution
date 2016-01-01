/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1ZonediffEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ZonediffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for ZONEDIFF method of XMXUTIL1 Webservice
 */
public class XMXUTIL1ZonediffTest extends VistaLinkContextTestParent {

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Get the difference between local time and a three-character time zone.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”EST”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=1"
	 * RETURN(2)="XMMM=0"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=1");
		results.add("XMMM=0");

		String expectedOutput = "XMHH=1\n" + "XMMM=0";

		XMXUTIL1ZonediffRequest request = new XMXUTIL1ZonediffRequest();
		request.setXmyt("EST");
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTIL1ZonediffEndpoint service = new XMXUTIL1ZonediffEndpointImpl(
				getVistaLinkContext(), new XMXUTIL1ResponseFactory());

		XMXUTIL1ZonediffResponse response = service.zonediff(request);

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Try to call the API with a null time zone.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=””
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Error in required input");

		String expectedOutput = "-1^Error in required input";

		XMXUTIL1ZonediffRequest request = new XMXUTIL1ZonediffRequest();
		request.setXmyt("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTIL1ZonediffEndpoint service = new XMXUTIL1ZonediffEndpointImpl(
				getVistaLinkContext(), new XMXUTIL1ResponseFactory());

		XMXUTIL1ZonediffResponse response = service.zonediff(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getErrors().get(0));

	}
}
