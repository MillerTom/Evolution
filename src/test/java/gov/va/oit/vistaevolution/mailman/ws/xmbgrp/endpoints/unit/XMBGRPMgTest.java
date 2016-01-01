package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.XMBGRPResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.XMBGRPMgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPMgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for MG method of XMBGRP Webservice
 */
public class XMBGRPMgTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPMgTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Create a new public mail group with two members, allowing
	 * self-enrollment.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST GROUP 1",xmtype=0,xmorg=1,xmself=1,xmy(.5)=””,xmy(.6)=””,xmdesc(1)="This is a mailgroup created for",xmdesc(2)="jTestMgXMWSOA02001."
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN=1820
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg001() throws VistaWebServiceFault {

		String expectedOutput = "1820";

		XMBGRPMgRequest request = new XMBGRPMgRequest();
		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		xmy.add(new XMYEntry(".6", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("This is a mailgroup created for");
		xmdesc.add("jTestMgXMWSOA02001.");
		request.setXmgroup("TEST GROUP 1");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("1");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMBGRPMgEndpoint service = new XMBGRPMgEndpointImpl(
				new XMBGRPResponseFactory(), getVistaLinkContext());

		XMBGRPMgResponse response = service.mg(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Try to add to an existingmail group using a null input parameter. Even if
	 * the parameter is one that the API ignores for a call to an existing
	 * group, the RPC will flag an error. All parameters are required to be
	 * non-null for the RPC.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 *  >S xmgroup="TEST GROUP 1",xmtype="",xmorg=1,xmself=0,xmy(83197)="",xmdesc(1)=""
	 *  
	 *  Procedure Call:
	 *  >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 *  
	 *  Expected Output:
	 *  >ZW XMGIEN
	 *  XMGIEN="1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg002() throws VistaWebServiceFault {

		String expectedOutput = "1^Error in required input";

		XMBGRPMgRequest request = new XMBGRPMgRequest();
		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83197", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");
		request.setXmgroup("TEST GROUP 1");
		request.setXmtype("");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMBGRPMgEndpoint service = new XMBGRPMgEndpointImpl(
				new XMBGRPResponseFactory(), getVistaLinkContext());

		XMBGRPMgResponse response = service.mg(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}
}
