/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEInitEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
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
 *         Integration Test for INIT method of XMVVITAE Webservice
 */
public class XMVVITAEInitIT extends EvolutionIT<XMVVITAEInitEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMVVITAEInitIT.class);

	private XMVVITAEInitRequest request;
	private XMVVITAEInitResponse response;

	@Override
	protected Class<XMVVITAEInitEndpoint> getType() {
		return XMVVITAEInitEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMVVITAEInitRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAEInitIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=""
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testInit001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("Error in required input");

		request.setDuz("");
		request.setXmduz(".5");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. User XMDUZ is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * >S XMDUZ=""
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("Error in required input");

		request.setDuz(".5");
		request.setXmduz("");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Use an invalid XMDUZ.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * >S XMDUZ="999999"
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,2^There is no person with DUZ 999999."
	 * 
	 * </pre>
	 */
	@Test
	public void testInit003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,2");
		results.add("There is no person with DUZ 999999.");

		request.setDuz(".5");
		request.setXmduz("999999");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * User read the original message only
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=999999
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^DUZ 999999 is not an active user"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("DUZ 999999 is not an active user");

		request.setDuz("999999");
		request.setXmduz(".5");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Set up User’s Vital Information. Use IEN (.5) and XMDUZ IEN (.6).
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * >S XMDUZ=.6
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="0^No errors or warnings"
	 * 
	 * >ZW XMDISPI
	 * XMDISPI="XIA^I"
	 * 
	 * >ZW XMDUN
	 * XMDUN="SHARED,MAIL"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMPRIV
	 * XMPRIV="y^n"
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"
	 * XMV("DUZ NAME")="POSTMASTER"
	 * XMV("LAST USE")="02/27/14@15:33:44"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="SHARED,MAIL"
	 * XMV("NETNAME")=SHARED.MAIL@DEVNCH.VACO.VA.GOV  
	 * XMV("NETNAME")="SHARED.MAIL@DBITTEST.DBITPRO.COM"   *** DBITPRO
	 * 
	 * XMV("NEW MSGS")=6            ***DBITPRO   XMV("NEW MSGS")=43
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("PRIV")="R"
	 * XMV("RDR ASK")="N"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^No errors or warnings");
		results.add("XIA^I");
		results.add("SHARED,MAIL");
		results.add("");
		results.add("y^n");
		results.add("1");
		results.add("MR. MAILMAN");
		results.add("POSTMASTER");
		results.add("02/27/14@15:33:44");
		results.add("I");
		results.add("SHARED,MAIL");
		results.add("SHARED.MAIL@DBITTEST.DBITPRO.COM");
		results.add("43");
		results.add("R");
		results.add("1");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("R");
		results.add("N");
		results.add("C");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("VA MailMan 8.0");

		request.setDuz(".5");
		request.setXmduz(".6");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Set up User’s Vital Information. Use IEN (.5) and XMDUZ IEN (.5).
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D INIT^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="0^No errors or warnings"   
	 * RETURN(1)="WARNING,1^Priority Mail"     ***DBITPRO
	 * 
	 * >ZW XMDISPI
	 * XMDISPI="XIA^I"
	 * 
	 * >ZW XMDUN
	 * XMDUN="POSTMASTER"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMPRIV
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"   **DNITPRO  XMV("BANNER")="POSTMASTER"
	 * XMV("DUZ NAME")="POSTMASTER"
	 * XMV("LAST USE")="02/27/14@14:54:31"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="POSTMASTER"
	 * XMV("NETNAME")="POSTMASTER@DEVNCH.VACO.VA.GOV"
	 * XMV("NETNAME")="SHARED.MAIL@DBITTEST.DBITPRO.COM"   *** DBITPRO
	 * 
	 * XMV("NEW MSGS")=2191     **DBITPRO  XMV("NEW MSGS")=244
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("RDR ASK")="N"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("WARNING,1^Priority Mail");
		results.add("XIA^I");
		results.add("POSTMASTER");
		results.add("");
		results.add("");
		results.add("1");
		results.add("POSTMASTER");
		results.add("POSTMASTER");
		results.add("02/27/14@14:54:31");
		results.add("I");
		results.add("POSTMASTER");
		results.add("SHARED.MAIL@DBITTEST.DBITPRO.COM");
		results.add("244");
		results.add("R");
		results.add("1");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("N");
		results.add("C");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("VA MailMan 8.0");

		request.setDuz(".5");
		request.setXmduz(".5");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.init(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

}
