/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.XMAD2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for MOVEMSGS method of XMXAPI Webservice
 */
public class XMXAPIMovemsgsIT extends EvolutionIT<XMXAPIMovemsgsEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIMovemsgsIT.class);

	private XMXAPIMovemsgsRequest request;
	private XMXAPIMovemsgsResponse response;

	private XMAD2BsktEndpoint bsktService;
	private XMDEndpoint xmdService;
	private XMA1BS2Endpoint s2Service;

	@Override
	protected Class<XMXAPIMovemsgsEndpoint> getType() {
		return XMXAPIMovemsgsEndpoint.class;
	}

	@Before
	public void setup() throws Exception {
		request = new XMXAPIMovemsgsRequest();

		bsktService = getEndpointImpl(XMAD2BsktEndpoint.class);
		xmdService = getEndpointImpl(XMDEndpoint.class);
		s2Service = getEndpointImpl(XMA1BS2Endpoint.class);
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIMovemsgsIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=""
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs001() throws VistaWebServiceFault {

		String result = "ERROR,-1^Error in required input";

		request.setDuz("");
		request.setXmDuz(".5");
		request.setXmk(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsgs(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. XMDUZ in null
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=""
	 * >S XMK=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs002() throws VistaWebServiceFault {

		String result = "ERROR,-1^Error in required input";

		request.setDuz(".5");
		request.setXmDuz("");
		request.setXmk(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsgs(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. The user is not a recipient of the mail message.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^You are neither the originator nor a recipient of this message. ^If you need to see it, ask someone to forward it to you."
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs003() throws VistaWebServiceFault {

		String result = "-1^You are neither the originator nor a recipient of this message. ^If you need to see it, ask someone to forward it to you.";

		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmk(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsgs(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Move the created test messages from the Delete basket to the In basket.
	 * 
	 * <pre>
	 * 1.	******* Create a Test Mail Box
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMKN="ZVE TEST"   *** Will use this Basket Name for Test’s
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN) 
	 * 
	 * Expected Output:
	 * ZW RETURN
	 * RETURN=2      *** Basket IEN may be different. Will use this for test case.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 2.	******* Create two Test Messages    (Will need the IEN’s of both Test Messages)
	 * 
	 * Input Data:
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMSUBJ="ZVISTA 1 API EXPOSURE MOVEMSGS-XMXAPI"
	 * >S XMMSG(1,0)=" Test API MOVEMSGS^XMXAPI."
	 * >S XMMSG(1,1)=" Line 2 MOVEMSGS^XMXAPI."
	 * >S XMY(.6)=""
	 * >S XMINSTR=""
	 * 
	 * Procedure Call:
	 * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUBJ,.XMMSG,.XMY,.XMINSTR) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=286463    ***DBITPRO message IEN will be different. Use your returned IEN for the next test case.
	 * 
	 * 
	 * Input Data:
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMSUBJ="ZVISTA 2 API EXPOSURE MOVEMSGS-XMXAPI"
	 * >S XMMSG(1,0)=" Test API MOVEMSGS^XMXAPI."
	 * >S XMMSG(1,1)=" Line 2 MOVEMSGS^XMXAPI."
	 * >S XMY(.6)=""
	 * >S XMINSTR=""
	 * 
	 * Procedure Call:
	 * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUBJ,.XMMSG,.XMY,.XMINSTR) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=286464    ***DBITPRO message IEN will be different. Use your returned IEN for the next test case.
	 * 
	 * 
	 * 
	 * 
	 * 3.	*******  Move Both Test messages into the TEST MAIL BOX
	 * 
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMKM=2         *** The IEN of the created Test Mail Box
	 * >S XMZ=286463     *** The IEN of the created Test Message.
	 * 
	 * Procedure Call:
	 * >D S2^XMWSOA02(.RETURN,XMDUZ,XMKM,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * 
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMKM=2          *** The IEN of the created Test Mail Box
	 * >S XMZ=286464      *** The IEN of the created Test Message.
	 * 
	 * Procedure Call:
	 * >D S2^XMWSOA02(.RETURN,XMDUZ,XMKM,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 4.	******* Move Both Test Messages from "ZVE TEST" basket to the "WASTE" basket
	 * Input Data:
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMK="ZVE TEST"
	 * >S XMMKZA("1,2")=""
	 * >S XMTO="WASTE"
	 * 
	 * Procedure Call:
	 * >D MOVEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,,XMTO) 
	 * 
	 * Expected Output:
	 * ZW RETURN	
	 * RETURN="0^2 messages saved"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsgs004() throws VistaWebServiceFault {

		// Create a Test Mail Box
		String testMailBox = this.createTestMailBox(".5", "ZVE TEST");

		// Create two Test Messages
		ArrayList<String> messages = new ArrayList<String>();
		messages.add(" Test API MOVEMSGS^XMXAPI.");
		messages.add(" Line 2 MOVEMSGS^XMXAPI.");
		ArrayList<XMYEntry> xmy = new ArrayList<XMYEntry>();
		xmy.add(new XMYEntry(".6", ""));
		String testmessage1 = this.createTestMessage(".5", ".5",
				"ZVISTA 1 API EXPOSURE MOVEMSGS-XMXAPI", messages, xmy);

		ArrayList<String> messages2 = new ArrayList<String>();
		messages2.add(" Test API MOVEMSGS^XMXAPI.");
		messages2.add(" Line 2 MOVEMSGS^XMXAPI.");
		ArrayList<XMYEntry> xmy2 = new ArrayList<XMYEntry>();
		xmy2.add(new XMYEntry(".6", ""));
		String testmessage2 = this.createTestMessage(".5", ".5",
				"ZVISTA 2 API EXPOSURE MOVEMSGS-XMXAPI", messages2, xmy2);

		// Move Both Test messages into the TEST MAIL BOX
		String moveMessage1 = this.moveTestMsgToTestMailbox(".5", testMailBox,
				testmessage1);

		String moveMessage2 = this.moveTestMsgToTestMailbox(".5", testMailBox,
				testmessage2);

		String result = "0^2 messages saved";

		// Move Both Test Messages from "ZVE TEST" basket to the "WASTE" basket
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmk("ZVE TEST");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("1,2", ""));
		request.setXmkza(xmkza);
		request.setXmkto("WASTE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsgs(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * Create a Test Mail Box
	 * 
	 * @param xmduz
	 * @param xmkn
	 * @return IEN of basket
	 */
	private String createTestMailBox(String xmduz, String xmkn) {

		XMAD2BsktRequest bsktRequest = new XMAD2BsktRequest();
		bsktRequest.setXmduz(xmduz);
		bsktRequest.setXmkn(xmkn);
		XMAD2BsktResponse bsktResponse = bsktService.bskt(bsktRequest);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("@@@@@@@@@@@@@@@@@@ bsktResponse= "
					+ bsktResponse.getResult());
		}
		return bsktResponse.getResult();

	}

	/**
	 * Create a Test Message
	 * 
	 * @param duz
	 * @param xmduz
	 * @param xmsub
	 * @param messages
	 * @param xmy
	 * 
	 * @return IEN of message (#3.9)
	 */
	private String createTestMessage(String duz, String xmduz, String xmsub,
			List<String> messages, List<XMYEntry> xmy) {

		XMDRequest xmdRequest = new XMDRequest();
		xmdRequest.setDuz(duz);
		xmdRequest.setXmDuz(xmduz);
		xmdRequest.setXmSub(xmsub);
		xmdRequest.setMessage(messages);
		xmdRequest.setxMY(xmy);
		XMDResponse xmdResponse = xmdService.xmd(xmdRequest);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("@@@@@@@@@@@@@@@@@@xmdResponse1= "
					+ xmdResponse.getResponse());
		}
		return xmdResponse.getResponse();
	}

	/**
	 * Move test Messages to test Mail Box
	 * 
	 * @param xmduz
	 * @param xmkm
	 * @param xmz
	 * 
	 * @return Successful
	 */
	private String moveTestMsgToTestMailbox(String xmduz, String xmkm,
			String xmz) {

		XMA1BS2Request s2Request = new XMA1BS2Request();
		s2Request.setXmduz(xmduz);
		s2Request.setXmkm(xmkm);
		s2Request.setXmz(xmz);
		XMA1BS2Response s2Response = s2Service.s2(s2Request);
		assertNotNull(s2Response);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("@@@@@@@@@@@@@@@@@@s2Response1= "
					+ s2Response.getResponse());
		}
		return s2Response.getResponse();
	}
}
