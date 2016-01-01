package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPDmEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmResponse;
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
 *         Integration Test for DM method of XMBGRP Webservice
 */
public class XMBGRPDmIT extends EvolutionIT<XMBGRPDmEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMBGRPDmIT.class);

	private XMBGRPDmResponse response;
	private XMBGRPDmRequest request;

	@Override
	protected Class<XMBGRPDmEndpoint> getType() {
		return XMBGRPDmEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMBGRPDmRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPDmIT() {
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

		String result = "0^Successful";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83138", ""));
		request.setXmgroup("TEST GROUP 1");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Delete a member froman existing mail group, referencing the group by IEN.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1820,xmy(.6)=""
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
	public void testDm002() throws VistaWebServiceFault {

		String result = "0^Successful";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".6", ""));
		request.setXmgroup("1820");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Delete a member froma non-existent mail group.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmy
	 * >S xmgroup="TEST GROUP 9999",xmy(.6)=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Mail Group TEST GROUP 9999 not found"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm003() throws VistaWebServiceFault {

		String result = "-1^Mail Group TEST GROUP 9999 not found";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".6", ""));
		request.setXmgroup("TEST GROUP 9999");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Delete anon-existent member froma mail group. Note that if the member was
	 * not in the mail group, nothing will be added or deleted.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmy
	 * >S xmgroup="TEST GROUP 1",xmy(1)=""
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
	public void testDm004() throws VistaWebServiceFault {

		String result = "0^Successful";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("1", ""));
		request.setXmgroup("TEST GROUP 1");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Delete oneexisting and one non-existent member froma mail group. Note
	 * that if one member was not in the mail group, the other member will still
	 * be deleted.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1821,xmy(83197)="",xmy(1)=""
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
	public void testDm005() throws VistaWebServiceFault {

		String result = "0^Successful";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("83197", ""));
		xmy.add(new XMYEntry("1", ""));
		request.setXmgroup("1821");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Delete twoexisting membersfroma mail group.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmy
	 * >S xmgroup=1821,xmy(.5)="",xmy(.6)=""
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
	public void testDm006() throws VistaWebServiceFault {

		String result = "0^Successful";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		xmy.add(new XMYEntry(".6", ""));
		request.setXmgroup("1821");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

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
	public void testDm007() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("1", ""));
		request.setXmgroup("");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Try to call the API with no users to delete.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1820,xmy=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm008() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		request.setXmgroup("1820");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * Try to delete a member using a name instead of a DUZ.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1820,xmy("VISTA,DBA")=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm009() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("VISTA,DBA", ""));
		request.setXmgroup("1820");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * Try to call the API with an invalid xmy parameter.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1821,xmy="A"
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm0010() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("A", ""));
		request.setXmgroup("1821");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * Try to delete two members, one of them using a name instead of a DUZ.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K xmy
	 * >S xmgroup=1820,xmy(.5)="",xmy("VISTA,DBA")=""
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^XMY recipient array has non-numeric values"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm0011() throws VistaWebServiceFault {

		String result = "-1^XMY recipient array has non-numeric values";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".5", ""));
		xmy.add(new XMYEntry("VISTA,DBA", ""));
		request.setXmgroup("1820");
		request.setXmy(xmy);
		request.setDuz("DUZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());
		// assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * Try to call the API with an invalid DUZ parameter.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K xmy
	 * >S xmgroup=1820,xmy(1)="",DUZ=99999
	 * 
	 * Procedure Call:
	 * >D DM^XMWSOA02(.RETURN,xmgroup,.xmy,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^DUZ not found"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDm0012() throws VistaWebServiceFault {

		String result = "-1^DUZ not found";

		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry("1", ""));
		request.setXmgroup("1820");
		request.setXmy(xmy);
		request.setDuz("99999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dm(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}
