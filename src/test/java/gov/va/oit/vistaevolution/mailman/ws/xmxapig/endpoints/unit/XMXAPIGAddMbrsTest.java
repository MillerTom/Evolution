/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGAddMbrsEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGAddMbrsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGListEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXAPIGAddMbrsTest extends VistaLinkContextTestParent {

	XMXAPIGAddMbrsRequest request;

	@Before
	public void setUp() {
		request = new XMXAPIGAddMbrsRequest();

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em> Assign the user to a group. </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP(”ZZEVO_TEST1”)=””
	 * >Set XMMBR(”PROGRAMMER,TWENTY”)=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="0^No errors”
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAssignUserToGroup() throws Exception {
		String expectedResponse = "0^No errors";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1", "")));
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,TWENTY", "")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getResult());
	}

	/**
	 * <em>Assign a non-existent user to a group.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP(”ZZEVO_TEST1”)=””
	 * >Set XMMBR(”PROGRAMMER,BAD”)=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="-1^Addressee not found."
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddNonExistentUser() throws Exception {
		String expectedResponse = "-1^Addressee not found.";
		
	
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1", "")));
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,BAD", "")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());
		
		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(null, response.getResult());
		

	}

	/**
	 * <em>Assign a user to a non-existent group.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP(”ZZEVO_TEST1_BAD”)=””
	 * >Set XMMBR(”PROGRAMMER,TWENTY”)=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="-1^Mail group 'ZZEVO_TEST1_BAD' not found."
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddToNonExistentGroup() throws Exception {
		String expectedResponse = "-1^Mail group 'ZZEVO_TEST1_BAD' not found.";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1_BAD", "")));
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,TWENTY", "")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(null, response.getResult());

	}

	/**
	 * <em>Run RPC with an empty XMDUZ.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=""
	 * >Set XMGRP(”ZZEVO_TEST1”)=””
	 * >Set XMMBR(”PROGRAMMER,TWENTY”)=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddEmptyXMDUZ() throws Exception {
		String expectedResponse = "-1^Error in required input";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1", "")));
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,TWENTY", "")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(null, response.getResult());
	}

	/**
	 * <em>Run RPC with an empty XMGRP.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP=””
	 * >Set XMMBR(”PROGRAMMER,TWENTY”)=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddEmptyXMGRP() throws Exception {
		String expectedResponse = "-1^Error in required input";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");

		request.setXmGrp(new ArrayList<XMXAPIGListEntry>());
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,TWENTY", "")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(null, response.getResult());

	}

	/**
	 * <em>Run RPC with an empty XMMBR.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP(”ZZEVO_TEST1”)=””
	 * >Set XMMBR=””
	 * >Set XMINSTR=””
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddEmptyXMMBR() throws Exception {
		String expectedResponse = "-1^Error in required input";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1", "")));

		request.setXmMbr(new ArrayList<XMXAPIGListEntry>());

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(null, response.getResult());

	}

	/**
	 * <em> Assign the user to a group and forward messages to the user. </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set DUZ=1
	 * >Set XMDUZ=1
	 * >Set XMGRP(”ZZEVO_TEST1”)=””
	 * >Set XMMBR(”PROGRAMMER,TWENTY”)=””
	 * >Set XMINSTR("FLAGS")=”F”
	 * 
	 * Procedure Call:
	 * 
	 * > D ADDMBRS^XMWSOA08(.DATA,DUZ,XMDUZ,.XMGRP,.XMMBR,XMINSTR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * 
	 * DATA="468114”
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAssignUserToGroupAndForwardMsgs() throws Exception {
		String expectedResponse = "468114";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setDuz("1");
		request.setXmDuz("1");
		request.setXmGrp(Arrays.asList(new XMXAPIGListEntry("ZZEVO_TEST1", "")));
		request.setXmMbr(Arrays.asList(new XMXAPIGListEntry("PROGRAMMER,TWENTY", "")));
		request.setXmInstr(Arrays.asList(new XMXAPIGListEntry("FLAGS", "F")));

		XMXAPIGAddMbrsEndpoint service = new XMXAPIGAddMbrsEndpointImpl(getVistaLinkContext(), new XMXAPIGResponseFactory());

		XMXAPIGAddMbrsResponse response = service.addMbrs(request);

		assertNotNull(response);

		assertEquals(expectedResponse, response.getResult());
	}

}
