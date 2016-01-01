/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgResponse;
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
 *         Integration Test for MOVEMSG method of XMXAPI Webservice
 */
public class XMXAPIMovemsgIT extends EvolutionIT<XMXAPIMovemsgEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIMovemsgIT.class);

	private XMXAPIMovemsgRequest request;
	private XMXAPIMovemsgResponse response;
	private XMXAPIAddrNSndEndpoint addrnsndService;

	@Override
	protected Class<XMXAPIMovemsgEndpoint> getType() {
		return XMXAPIMovemsgEndpoint.class;
	}

	@Before
	public void setup() throws Exception {
		request = new XMXAPIMovemsgRequest();
		addrnsndService = getEndpointImpl(XMXAPIAddrNSndEndpoint.class);
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIMovemsgIT() {
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
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg001() throws VistaWebServiceFault {

		String result = "ERROR,-1^Error in required input";

		request.setDuz("");
		request.setXmDuz(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsg(request);

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
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg002() throws VistaWebServiceFault {

		String result = "ERROR,-1^Error in required input";

		request.setDuz(".5");
		request.setXmDuz("");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. The user is not a recipient of the mail message
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMKZA(100)=""
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^You are neither the originator nor a recipient of this message.^If you need to see it, ask someone to forward it to you."
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg003() throws VistaWebServiceFault {

		String result = "-1^You are neither the originator nor a recipient of this message.^If you need to see it, ask someone to forward it to you.";

		request.setDuz(".5");
		request.setXmDuz(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry("100", ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Move the created test message from the Delete basket to the In basket.
	 * 
	 * <pre>
	 * ******* Set up a Test Message
	 * Input Data:
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMSUBJ="ZVISTA API EXPOSURE MOVEMSG-XMXAPI"
	 * >S XMMSG(1)=" Test API MOVEMSG^XMXAPI."
	 * >S XMSTRIP=""
	 * >S XMTO(.5)=""
	 * >S XMTO(.6)=""
	 * >S XMINSTR("ADDR FLAGS")="R"
	 * >S XMINSTR("FLAGS")="IS"
	 * 
	 * Procedure Call:
	 * >D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.XMMSG,XMSTRIP,.XMTO,.XMINSTR) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^285409"    ***DBITPRO message IEN will be different. Use your returned IEN for the next test case.
	 * 
	 * 
	 * 
	 * ******  RPC Test Case.
	 * 
	 * Input Data:
	 * >K XMKZA
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * >S XMKZA(285409)=""   Use the returned IEN from the created Test message
	 * >S XMKTO=1
	 * 
	 * Procedure Call:
	 * >D MOVEMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMKZA,XMKTO)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^1 message saved."
	 * 
	 * </pre>
	 */
	@Test
	public void testMovemsg004() throws VistaWebServiceFault {

		String result = "0^1 message saved.";
		
		XMXAPIAddrNSndRequest addrnsndRequest = new XMXAPIAddrNSndRequest();
		addrnsndRequest.setDuz(".5");
		addrnsndRequest.setXmDuz(".5");
		addrnsndRequest.setXmSubj("ZVISTA API EXPOSURE MOVEMSG-XMXAPI");
		ArrayList<String> msg = new ArrayList<String>();
		msg.add(" Test API MOVEMSG^XMXAPI.");
		addrnsndRequest.setMsg(msg);
		addrnsndRequest.setXmStrip("");
		ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
		xmto.add(new XMXAPIArrayEntry(".5", ""));
		xmto.add(new XMXAPIArrayEntry(".6", ""));
		addrnsndRequest.setXmTo(xmto);
		ArrayList<XMXAPIArrayEntry> xminstr = new ArrayList<XMXAPIArrayEntry>();
		xminstr.add(new XMXAPIArrayEntry("ADDR FLAGS", "R"));
		xminstr.add(new XMXAPIArrayEntry("FLAGS", "IS"));
		addrnsndRequest.setXmInstr(xminstr);
		
		XMXAPIAddrNSndResponse addrnsndResponse = addrnsndService.addrNSnd(addrnsndRequest);
		assertNotNull(addrnsndResponse);
		assertNotNull(addrnsndResponse.getMsgIen());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("MSGIEN= " + addrnsndResponse.getMsgIen());
		}
		
		request.setDuz(".5");
		request.setXmDuz(".5");
		List<XMXAPIArrayEntry> xmkza = new ArrayList<XMXAPIArrayEntry>();
		xmkza.add(new XMXAPIArrayEntry(addrnsndResponse.getMsgIen(), ""));
		request.setXmkza(xmkza);
		request.setXmkto("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.movemsg(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}
