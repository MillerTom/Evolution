package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBValidAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
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
 *         Integration Test for VALIDAV method of XUSRB Webservice
 */
public class XUSRBValidAVIT extends EvolutionIT<XUSRBValidAVEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUSRBValidAVIT.class);

	private XUSRBValidAVRequest request;
	private XUSRBValidAVResponse response;

	@Override
	protected Class<XUSRBValidAVEndpoint> getType() {
		return XUSRBValidAVEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUSRBValidAVRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUSRBValidAVIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. "Not a valid ACCESS CODE/VERIFY CODE pair."
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S AV="123,456"
	 * >D SETUP^XUSRB(.RETURN)
	 * 
	 * Procedure Call:
	 * >D VALIDAV^XUSRB(.RETURN,AV)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)=0
	 * RETURN(1)=0
	 * RETURN(2)=0
	 * RETURN(3)="Not a valid ACCESS CODE/VERIFY CODE pair."
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)="VAHACG.FO-ALBANY.MED.VA.GOV"
	 * RETURN(7)=0
	 * </pre>
	 */
	@Test
	public void testValidAV001() throws VistaWebServiceFault {

		List<String> results = new ArrayList<String>();
		results.add("0");
		results.add("0");
		results.add("0");
		results.add("Not a valid ACCESS CODE/VERIFY CODE pair.");
		results.add("0");
		results.add("0");
		results.add("VAHACG.FO-ALBANY.MED.VA.GOV");
		results.add("0");

		request.setAvcode("123,456");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.validAV(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error.
	 * "Device/IP address is locked due to too many invalid signon attempts."
	 * Repeat the following test scenario 4 times so as to attempt to logon 4
	 * times.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S AV="123,456"
	 * >D SETUP^XUSRB(.RETURN)
	 * 
	 * Procedure Call:
	 * >D VALIDAV^XUSRB(.RETURN,AV)
	 * 
	 * Expected Output:  (First 3 attempts.  Repeat the “Input Data/Procedure Call” 4 times.)
	 * >ZW RETURN
	 * RETURN(0)=0
	 * RETURN(1)=0
	 * RETURN(2)=0
	 * RETURN(3)=" Not a valid ACCESS CODE/VERIFY CODE pair."
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)="VAHACG.FO-ALBANY.MED.VA.GOV"
	 * RETURN(7)=0
	 * 
	 * 
	 * Expected Output: (The fourth attempt to logon)
	 * >ZW RETURN
	 * RETURN(0)=0
	 * RETURN(1)=1
	 * RETURN(2)=0
	 * RETURN(3)="Device/IP address is locked due to too many invalid signon attempts."
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)="VAHACG.FO-ALBANY.MED.VA.GOV"
	 * RETURN(7)=0
	 * 
	 * </pre>
	 */
	@Test
	public void testValidAV002() throws VistaWebServiceFault {

		List<String> results1 = new ArrayList<String>();
		results1.add("0");
		results1.add("0");
		results1.add("0");
		results1.add(" Not a valid ACCESS CODE/VERIFY CODE pair.");
		results1.add("0");
		results1.add("0");
		results1.add("VAHACG.FO-ALBANY.MED.VA.GOV");
		results1.add("0");

		List<String> results2 = new ArrayList<String>();
		results2.add("0");
		results2.add("1");
		results2.add("0");
		results2.add("Device/IP address is locked due to too many invalid signon attempts.");
		results2.add("0");
		results2.add("0");
		results2.add("VAHACG.FO-ALBANY.MED.VA.GOV");
		results2.add("0");

		/*
		 * request.setAvcode("123,456"); if (LOGGER.isDebugEnabled()) {
		 * LOGGER.debug("request= " + request); }
		 * 
		 * for (int i = 0; i < 3; i++) { response = service.validAV(request); }
		 * 
		 * if (LOGGER.isDebugEnabled()) { LOGGER.debug("response= " + response);
		 * }
		 * 
		 * assertNotNull(response); assertEquals(results1.get(0),
		 * response.getOutputDataList().get(0));
		 */

		request.setAvcode("123,456");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.validAV(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Successful silent Log-on after validating the User’s access/verify codes.
	 * Display any messages that user might have after logon.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S AV==" xxxxxxxx;yyyyyyyy "
	 * >D SETUP^XUSRB(.RETURN)
	 * 
	 * Procedure Call:
	 * >D VALIDAV^XUSRB(.RETURN,AV)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)=53467
	 * RETURN(1)=0
	 * RETURN(2)=0
	 * RETURN(3)=""
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)=""
	 * RETURN(7)="Good morning DAOU,PATCHUSER"
	 * RETURN(8)="     You last signed on today at 04:17"
	 * RETURN(9)="You have 43 new messages. (43 in the 'IN' basket)"
	 * RETURN(10)=""
	 * RETURN(11)="Enter '^NML' to read your new messages."
	 * RETURN(12)=$c(27)_"[7mYou've got PRIORITY mail!"_$c(27)_"[27m"
	 * 
	 * </pre>
	 */
	@Test
	public void testValidAV003() throws VistaWebServiceFault {

		List<String> results = new ArrayList<String>();
		results.add("53467");
		results.add("0");
		results.add("0");
		results.add("");
		results.add("0");
		results.add("0");
		results.add("");
		results.add("Good morning DAOU,PATCHUSER");
		results.add("     You last signed on today at 04:17");
		results.add("You have 43 new messages. (43 in the 'IN' basket)");
		results.add("");
		results.add("Enter '^NML' to read your new messages.");
		results.add("Enter '^NML' to read your new messages.");
		results.add("$c(27)_\"[7mYou've got PRIORITY mail!\"_$c(27)_\"[27m\"");

		request.setAvcode(" xxxxxxxx;yyyyyyyy ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.validAV(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

}
