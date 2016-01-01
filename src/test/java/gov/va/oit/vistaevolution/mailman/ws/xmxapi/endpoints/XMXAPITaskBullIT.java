package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITaskBullEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPITaskBullIT extends EvolutionIT<XMXAPITaskBullEndpoint> {

	private XMXAPITaskBullRequest request;

	@Override
	protected Class<XMXAPITaskBullEndpoint> getType() {
		return XMXAPITaskBullEndpoint.class;
	}

	@Before
	public void setUp() {
		request = new XMXAPITaskBullRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setMbn("XUSSPKI SAN");
		request.setXmParm(Arrays.asList(new XMXAPIArrayEntry("1", "TEST SUBJECT"), new XMXAPIArrayEntry("2", "SHARED,MAIL")));
		request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
		request.setMsg(Arrays.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));
	}

	/**
	 * Input Data: >S
	 * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(1)="TEST SUBJECT"
	 * ,XMPARM(2)="SHARED,MAIL"
	 * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST",XMINSTR=""
	 * 
	 * Procedure Call: >D
	 * TaskBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
	 * 
	 * Expected Output: >ZW RESULT RESULT=286774
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testTaskBulletin() throws VistaWebServiceFault {

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertTrue(Long.parseLong(response.getResult()) > 1);
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

		request.setMsg(Arrays.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));

		XMXAPITaskBullResponse response = service.taskBulletin(request);

		assertTrue(Long.parseLong(response.getResult()) > 1);
	}

}
