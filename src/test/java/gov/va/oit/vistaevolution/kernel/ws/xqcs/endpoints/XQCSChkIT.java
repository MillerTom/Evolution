/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSChkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for CHK method of XQCS Webservice
 */
public class XQCSChkIT extends EvolutionIT<XQCSChkEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XQCSChkIT.class);

	private XQCSChkRequest request;
	private XQCSChkResponse response;

	@Override
	protected Class<XQCSChkEndpoint> getType() {
		return XQCSChkEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XQCSChkRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XQCSChkIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check whether a user has access to a menu option. Use the IEN of the menu
	 * option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=7
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk001() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("1");
		request.setXuopt("7");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check whether a user has access to a menu option. Use the name of the
	 * menu option.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="XUHALT"
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk002() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("1");
		request.setXuopt("XUHALT");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Check whether a non-existent user has access to a menu option. (For some
	 * reason, the call comes back successful.)
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=99999
	 * >S XUOPT=7
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk003() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("99999");
		request.setXuopt("7");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Check whether a user has access to a non-existent menu option. Use a name
	 * for the menu option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="FAKE OPTION"
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No such option in the ""B"" cross reference of the Option File."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk004() throws VistaWebServiceFault {

		String result = "No such option in the \"B\" cross reference of the Option File.";

		request.setXuien("1");
		request.setXuopt("FAKE OPTION");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Check whether a user has access to a non-existent menu option. Use an IEN
	 * for the menu option. An error occurs.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=99999 
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * 
	 * I '$D(^TMP("XQCS",$J)) S XQOPT=$$OPTLK($P(^DIC(19,XQOPT,0),U))
	 *                         ^
	 * <UNDEFINED>OPT+4^XQCS ^DIC(19,99999,0)
	 * >
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk005() throws VistaWebServiceFault {

		String result = "I '$D(^TMP(" + "XQCS"
				+ ",$J)) S XQOPT=$$OPTLK($P(^DIC(19,XQOPT,0),U))\n"
				+ "<UNDEFINED>OPT+4^XQCS ^DIC(19,99999,0)\n" + ">";

		request.setXuien("1");
		request.setXuopt("99999");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Check whether a user has access to an RPC that is not registered to the
	 * menu option. Use IENs for both the option and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=7
	 * >S XURPC=1
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="The remote procedure XWB EGCHO STRING is not registered to the option XUHALT."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk006() throws VistaWebServiceFault {

		String result = "The remote procedure XWB EGCHO STRING is not registered to the option XUHALT.";

		request.setXuien("1");
		request.setXuopt("7");
		request.setXurpc("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Check whether a user has access to an RPC that is not registered to the
	 * menu option. Use an IEN for the option and a name for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=7
	 * >S XURPC="XWB EGCHO STRING"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="The remote procedure XWB EGCHO STRING is not registered to the option XUHALT."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk007() throws VistaWebServiceFault {

		String result = "The remote procedure XWB EGCHO STRING is not registered to the option XUHALT.";

		request.setXuien("1");
		request.setXuopt("7");
		request.setXurpc("XWB EGCHO STRING");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #8  </em>
	 * 
	 * Check whether a user has access to an RPC that is not registered to the
	 * menu option. Use a name for the option and an IEN for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="XUHALT"
	 * >S XURPC=1
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="The remote procedure XWB EGCHO STRING is not registered to the option XUHALT."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk008() throws VistaWebServiceFault {

		String result = "The remote procedure XWB EGCHO STRING is not registered to the option XUHALT.";

		request.setXuien("1");
		request.setXuopt("XUHALT");
		request.setXurpc("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9  </em>
	 * 
	 * Check whether a user has access to an RPC that is not registered to the
	 * menu option. Use names for both the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="XUHALT"
	 * >S XURPC="XWB EGCHO STRING"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="The remote procedure XWB EGCHO STRING is not registered to the option XUHALT."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk009() throws VistaWebServiceFault {

		String result = "The remote procedure XWB EGCHO STRING is not registered to the option XUHALT.";

		request.setXuien("1");
		request.setXuopt("XUHALT");
		request.setXurpc("XWB EGCHO STRING");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #10  </em>
	 * 
	 * Check whether a user has access to a menu option for which the user does
	 * not have access. Use an IEN for the option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=18
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option PSO P"
	 * 
	 * </pre>
	 */
	@Test
	public void testChk010() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option PSO P";

		request.setXuien("1");
		request.setXuopt("18");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #11  </em>
	 * 
	 * Check whether a user has access to a menu option for which the user does
	 * not have access. Use a name for the option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="PSO P"
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option PSO P"
	 * 
	 * </pre>
	 */
	@Test
	public void testChk011() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option PSO P";

		request.setXuien("1");
		request.setXuopt("PSO P");
		request.setXurpc("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #12  </em>
	 * 
	 * Check whether a user has access to an RPC for a menu option the user
	 * cannot access. Use IENs for both the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=17211
	 * >S XURPC=2621
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB"
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk012() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB";

		request.setXuien("1");
		request.setXuopt("17211");
		request.setXurpc("2621");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #13  </em>
	 * 
	 * Check whether a user has access to an RPC for a menu option the user
	 * cannot access. Use an IEN for the option and a name for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=17211
	 * >S XURPC="ANRV CREATE ENCOUNTER"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB"
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk013() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB";

		request.setXuien("1");
		request.setXuopt("17211");
		request.setXurpc("ANRV CREATE ENCOUNTER");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #14  </em>
	 * 
	 * Check whether a user has access to an RPC for a menu option the user
	 * cannot access. Use a name for the option and an IEN for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="ANRVJ_BLINDREHAB"
	 * >S XURPC=2621
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB"
	 * 
	 * </pre>
	 */
	@Test
	public void testChk014() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB";

		request.setXuien("1");
		request.setXuopt("ANRVJ_BLINDREHAB");
		request.setXurpc("2621");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #15  </em>
	 * 
	 * Check whether a user has access to an RPC for a menu option the user
	 * cannot access. Use names for both the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="ANRVJ_BLINDREHAB"
	 * >S XURPC="ANRV CREATE ENCOUNTER"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB"
	 * 
	 * </pre>
	 */
	@Test
	public void testChk015() throws VistaWebServiceFault {

		String result = "User TEST,APPLICATION PROXY does not have access to option ANRVJ_BLINDREHAB";

		request.setXuien("1");
		request.setXuopt("ANRVJ_BLINDREHAB");
		request.setXurpc("ANRV CREATE ENCOUNTER");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #16  </em>
	 * 
	 * Check whether an RPC is valid and the user can access the menu option.
	 * Use IENs for both the option and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC=572
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk016() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("572");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #17  </em>
	 * 
	 * Check whether an RPC is valid and the user can access the menu option.
	 * Use an IEN for the option and a name for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC="XUS GET USER INFO"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk017() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("XUS GET USER INFO");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #18  </em>
	 * 
	 * Check whether an RPC is valid and the user can access the menu option.
	 * Use a name for the option and an IEN for the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC=572
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk018() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("572");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #19  </em>
	 * 
	 * Check whether an RPC is valid and the user can access the menu option.
	 * Use names for both the option and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC="XUS GET USER INFO"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk019() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("XUS GET USER INFO");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #20  </em>
	 * 
	 * Check whether a user has access to a non-existent RPC. Use IENs for both
	 * the option and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC=99999
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No such procedure in the Remote Procedure File."
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk020() throws VistaWebServiceFault {

		String result = "No such procedure in the Remote Procedure File.";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("99999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #21  </em>
	 * 
	 * Check whether a user has access to a non-existent RPC. Use an IEN for the
	 * option and a name for the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC="FAKE RPC"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No RPC by that name in the ""B"" cross-reference of the Remote Procedure File."
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk021() throws VistaWebServiceFault {

		String result = "No RPC by that name in the \"B\" cross-reference of the Remote Procedure File.";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("FAKE RPC");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #22  </em>
	 * 
	 * Check whether a user has access to a non-existent RPC. Use a name for the
	 * option and an IEN for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC=99999
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No such procedure in the Remote Procedure File."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk022() throws VistaWebServiceFault {

		String result = "No such procedure in the Remote Procedure File.";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("99999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #23  </em>
	 * 
	 * Check whether a user has access to a non-existent RPC. Use names for both
	 * the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC="FAKE RPC"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No RPC by that name in the ""B"" cross-reference of the Remote Procedure File."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk023() throws VistaWebServiceFault {

		String result = "No RPC by that name in the \"B\" cross-reference of the Remote Procedure File.";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("FAKE RPC");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #24  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * screen out this user, even though the user can access the menu option.
	 * Check whether the user can access the RPC. Use IENs for both the option
	 * and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC=43039
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="Remote procedure request failed rules test."
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk024() throws VistaWebServiceFault {

		String result = "Remote procedure request failed rules test.";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("43039");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #25  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * screen out this user, even though the user can access the menu option.
	 * Check whether the user can access the RPC. Use an IEN for the option and
	 * a name for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC="IB VALIDATE NPI"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="Remote procedure request failed rules test."
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk025() throws VistaWebServiceFault {

		String result = "Remote procedure request failed rules test.";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("IB VALIDATE NPI");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #26  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * screen out this user, even though the user can access the menu option.
	 * Check whether the user can access the RPC. Use a name for the option and
	 * an IEN for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC=43039
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="Remote procedure request failed rules test."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk026() throws VistaWebServiceFault {

		String result = "Remote procedure request failed rules test.";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("43039");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #27  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * screen out this user, even though the user can access the menu option.
	 * Check whether the user can access the RPC. Use names for both the option
	 * and the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC="IB VALIDATE NPI"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="Remote procedure request failed rules test."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk027() throws VistaWebServiceFault {

		String result = "Remote procedure request failed rules test.";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("IB VALIDATE NPI");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #28  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * allow this user to access it. Check whether the user can access the RPC.
	 * Use IENs for both the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC=3152
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk028() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("3152");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #29  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * allow this user to access it. Check whether the user can access the RPC.
	 * Use an IEN for the option and a name for the RPC.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT=18266
	 * >S XURPC="IB INSBUF CREATE"
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChk029() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("18266");
		request.setXurpc("IB INSBUF CREATE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #30  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * allow this user to access it. Check whether the user can access the RPC.
	 * Use a name for the option and an IEN for the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC=3152
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk030() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("3152");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #31  </em>
	 * 
	 * The RPC in the following example has had its RULES field modified to
	 * allow this user to access it. Check whether the user can access the RPC.
	 * Use names for both the option and the RPC.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XUIEN=83288
	 * >S XUOPT="IB VISTALINK USER"
	 * >S XURPC="IB INSBUF CREATE"
	 * 
	 * Procedure Call:
	 * >S RETURN=$$CHK^XQCS(XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testChk031() throws VistaWebServiceFault {

		String result = "1";

		request.setXuien("83288");
		request.setXuopt("IB VISTALINK USER");
		request.setXurpc("IB INSBUF CREATE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.chk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

}
