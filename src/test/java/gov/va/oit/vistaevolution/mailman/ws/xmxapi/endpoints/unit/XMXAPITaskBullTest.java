package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPITaskBullEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITaskBullEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XMXAPITaskBullTest extends VistaLinkContextTestParent {
	XMXAPITaskBullRequest request;
	XMXAPITaskBullEndpoint service;

	@Before
	public void setUp() {
		request = new XMXAPITaskBullRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setMbn("XUSSPKI SAN");
		request.setXmParm(Arrays.asList(new XMXAPIArrayEntry("1", "TEST SUBJECT"), new XMXAPIArrayEntry("2", "SHARED,MAIL")));
		request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
		request.setMsg(Arrays.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));

		service = new XMXAPITaskBullEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Send the bulletin successfully</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=.5
	 * >SET XMDUZ=.5
	 * >SET XMBN="XMRDACK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=394
	 * </pre>
	 * 
	 */
	@Test
	public void testSuccessfulBulletin() throws VistaWebServiceFault {
		String expectedResponse = "394";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

	/**
	 * <em>No DUZ defined</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=""
	 * >SET XMDUZ=.5
	 * >SET XMBN="XMRDACK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 */
	@Test
	public void testMissingDuz() throws VistaWebServiceFault {
		String expectedResponse = "-1^Error in required input";

		request.setDuz("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>No XMDUZ defined</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=.5
	 * >SET XMDUZ=""
	 * >SET XMBN="XMRDACK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 */
	@Test
	public void testMissingXMDuz() throws VistaWebServiceFault {
		String expectedResponse = "-1^Error in required input";

		request.setXmDuz("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>No XMMBM defined</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=.5
	 * >SET XMDUZ=""
	 * >SET XMBN="XMRDACK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 */
	@Test
	public void testMissingXMMBM() throws VistaWebServiceFault {
		String expectedResponse = "-1^Error in required input";

		request.setMbn("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>No active user</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=120
	 * >SET XMDUZ=120
	 * >SET XMBN="XMRDACK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^User '120' not found."
	 * </pre>
	 * 
	 */
	@Test
	public void testNotActiveUser() throws VistaWebServiceFault {
		String expectedResponse = "-1^User '120' not found.";

		request.setDuz("120");
		request.setXmDuz("120");
		;

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Error generated from within the API.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=.5
	 * >SET XMDUZ=.5
	 * >SET XMBN="XMRGUESSWORK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG=""
	 * >SET XMINSTR=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Bulletin 'XMRGUESSWORK' not found."
	 * </pre>
	 * 
	 */
	@Test
	public void testAPIError() throws VistaWebServiceFault {
		String expectedResponse = "-1^Bulletin 'XMRGUESSWORK' not found.";

		request.setMbn("XMRGUESSWORK");
		request.setXmDuz("120");
		;

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Testing the full parameter list</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DUZ=.5
	 * >SET XMDUZ=.5
	 * >SET XMBN="XMRGUESSWORK"
	 * >SET XMPARM(1)="TEST SUBJECT",
	 * >SET XMPARM(2)="SHARED,MAIL"
	 * >SET XMTO(.6)=""
	 * >SET MSG="TEST INFORMATIONAL ADDITION TO BROADCAST"
	 * >SET XMINSTR="SELF BSK"
	 * 
	 * Procedure Call:
	 * 
	 * >D TASKBULL^XMWSOA03(RETURN,DUZ,XMDUZ,XMBN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Bulletin 'XMRGUESSWORK' not found."
	 * </pre>
	 * 
	 */
	@Test
	public void testFullParameterList() throws VistaWebServiceFault {
		String expectedResponse = "401";

		request.setMsg(Arrays.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

}
