package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.XMBGRPResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.XMBGRPDmEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPDmEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for DM method of XMBGRP Webservice
 */
public class XMBGRPDmTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPDmTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Delete a member froman existing mail group, referencing the group by
	 * name.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmy
	 * >S xmgroup="TEST GROUP 1",xmy(83138)=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm001() throws VistaWebServiceFault {

		String expectedOutput = "0^Successful";

		XMBGRPDmRequest request = new XMBGRPDmRequest();
		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83138", ""));
		request.setXmgroup("TEST GROUP 1");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMBGRPDmEndpoint service = new XMBGRPDmEndpointImpl(
				new XMBGRPResponseFactory(), getVistaLinkContext());

		XMBGRPDmResponse response = service.dm(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Try to call the API with no mail group name or IEN.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup="",xmy(1)=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMBGRPDmRequest request = new XMBGRPDmRequest();
		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("1", ""));
		request.setXmgroup("");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMBGRPDmEndpoint service = new XMBGRPDmEndpointImpl(
				new XMBGRPResponseFactory(), getVistaLinkContext());

		XMBGRPDmResponse response = service.dm(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());
	}

}
