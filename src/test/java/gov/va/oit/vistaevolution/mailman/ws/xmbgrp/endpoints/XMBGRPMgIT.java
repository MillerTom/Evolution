package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPMgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMYEntry;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for MG Method of XMBGRP Webservice
 */
public class XMBGRPMgIT extends EvolutionIT<XMBGRPMgEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMBGRPMgIT.class);

	private XMBGRPMgResponse response;
	private XMBGRPMgRequest request;

	@Override
	protected Class<XMBGRPMgEndpoint> getType() {
		return XMBGRPMgEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMBGRPMgRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPMgIT() {
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

		String result = "1820";

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

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Add a new member to the mail group created above, referencing the group
	 * by name. Try changing the parameters that are supposed to be ignored for
	 * existing groups.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST GROUP 1",xmtype=1,xmorg=2,xmself=0,xmy(83138)="",xmdesc(1)="This is a description that should be ignored for",xmdesc(2)="jTestMgXMWSOA02002."
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * >ZW XMGIEN
	 * XMGIEN=1820
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg002() throws VistaWebServiceFault {

		String result = "1820";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83138", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("This is a description that should be ignored for");
		xmdesc.add("jTestMgXMWSOA02002.");

		request.setXmgroup("TEST GROUP 1");
		request.setXmtype("1");
		request.setXmorg("2");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Create a new private mail group with three members, disallowing
	 * self-enrollment
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST GROUP 2",xmtype=1,xmorg=1,xmself=0,xmy(.5)="",xmy(.6)="",xmy(83138)="",xmdesc(1)="This is a mailgroup created for",xmdesc(2)="jTestMgXMWSOA02003."
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * >ZW XMGIEN
	 * XMGIEN=1821
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg003() throws VistaWebServiceFault {

		String result = "1821";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		xmy.add(new XMYEntry(".6", ""));
		xmy.add(new XMYEntry("83138", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("This is a mailgroup created for");
		xmdesc.add("jTestMgXMWSOA02003.");

		request.setXmgroup("TEST GROUP 2");
		request.setXmtype("1");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Add a new member to the mail group created above, referencing the group
	 * by IEN.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup=1821,xmtype=1,xmorg=1,xmself=0,xmy(83197)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * >ZW XMGIEN
	 * XMGIEN=1821
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg004() throws VistaWebServiceFault {

		String result = "1821";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83197", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("1821");
		request.setXmtype("1");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Try to call the RPC with a mail group name of fewer than three
	 * characters.
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="A",xmtype=1,xmorg=1,xmself=0,xmy(.5)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN=0
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg005() throws VistaWebServiceFault {

		String result = "0";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("A");
		request.setXmtype("1");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

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
	public void testMg006() throws VistaWebServiceFault {

		String result = "1^Error in required input";

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

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Call anexisting mail group without adding any new members.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST GROUP 1",xmtype=0,xmorg=1,xmself=0,xmy="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN="1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg007() throws VistaWebServiceFault {

		String result = "1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("TEST GROUP 1");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Try to add a new member using a name instead of a DUZ.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup=1820,xmtype=0,xmorg=1,xmself=0,xmy("NURSE,SUPER")="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN="1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg008() throws VistaWebServiceFault {

		String result = "1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("NURSE,SUPER", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("1820");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * Try to create a mail group with a name that is more than thirty
	 * characters long.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="THIS MAIL GROUP NAME IS MORE THAN THIRTY CHARACTERS LONG.",xmtype=0,xmorg=1,xmself=0,xmy(.5)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN=0
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg009() throws VistaWebServiceFault {

		String result = "0";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("THIS MAIL GROUP NAME IS MORE THAN THIRTY CHARACTERS LONG.");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * Try to create a mail group with an invalid xmorg parameter (a
	 * non-existent user IEN).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST BAD PARAMETERS",xmtype=0,xmorg=99999,xmself=0,xmy(83197)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN="-1^XMORG DUZ not found"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg0010() throws VistaWebServiceFault {

		String result = "-1^XMORG DUZ not found";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83197", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("TEST BAD PARAMETERS");
		request.setXmtype("0");
		request.setXmorg("99999");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * Try to create a mail group with an invalid xmy parameter (a non-existent
	 * user IEN).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST BAD PARAMETERS 2",xmtype=0,xmorg=1,xmself=0,xmy(99999)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN="-1^99999 is an inactive or invalid user"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg0011() throws VistaWebServiceFault {

		String result = "-1^99999 is an inactive or invalid user";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("99999", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("TEST BAD PARAMETERS 2");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * Try to add a member to an existing group using an invalid xmy parameter.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmdesc,xmy
	 * >S xmgroup="TEST GROUP 2",xmtype=0,xmorg=1,xmself=0,xmy(99999)="",xmdesc(1)=""
	 * 
	 * Procedure Call:
	 * >D MG^XMWSOA02(.XMGIEN,xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XMGIEN
	 * XMGIEN="-1^99999 is an inactive or invalid user"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMg0012() throws VistaWebServiceFault {

		String result = "-1^99999 is an inactive or invalid user";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("99999", ""));
		ArrayList<String> xmdesc = new ArrayList<String>();
		xmdesc.add("");

		request.setXmgroup("TEST GROUP 2");
		request.setXmtype("0");
		request.setXmorg("1");
		request.setXmself("0");
		request.setXmy(xmy);
		request.setXmdesc(xmdesc);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.mg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}
}
