/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEOtherEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherResponse;
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
 *         Integration Test for OTHER method of XMVVITAE Webservice
 */
public class XMVVITAEOtherIT extends EvolutionIT<XMVVITAEOtherEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMVVITAEOtherIT.class);

	private XMVVITAEOtherRequest request;
	private XMVVITAEOtherResponse response;

	@Override
	protected Class<XMVVITAEOtherEndpoint> getType() {
		return XMVVITAEOtherEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMVVITAEOtherRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAEOtherIT() {
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
	 * >D OTHER^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOther001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("Error in required input");

		request.setDuz("");
		request.setXmduz(".5");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.other(request);

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
	 * >D OTHER^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOther002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("Error in required input");

		request.setDuz(".5");
		request.setXmduz("");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.other(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. User .5 is not a surrogate for 999999.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * >S XMDUZ="999999"
	 * 
	 * Procedure Call:
	 * >D OTHER^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^.5 is not a surrogate for 999999"
	 * 
	 * </pre>
	 */
	@Test
	public void testOther003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add(".5 is not a surrogate for 999999");

		request.setDuz(".5");
		request.setXmduz("999999");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.other(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Error. DUZ 999999 is not an active user.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=999999
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D OTHER^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^DUZ 999999 is not an active user"
	 * 
	 * </pre>
	 */
	@Test
	public void testOther004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1");
		results.add("DUZ 999999 is not an active user");

		request.setDuz("999999");
		request.setXmduz(".5");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.other(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Display settings when user is a surrogate.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=99      ***DBITPRO use  >S DUZ=1
	 * >S XMDUZ=.5    ***DBITPRO use  >S XMDUZ=11720
	 * 
	 * 
	 * Procedure Call:
	 * >D OTHER^XMWSOA03(.RETURN,DUZ,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="0^No errors or warnings"   
	 * 
	 * >ZW XMDISPI
	 * XMDISPI="XIA^I"
	 * 
	 * >ZW XMDUN
	 * XMDUN="POSTMASTER"     **DBITPRO  XMDUN="PATCH,USER"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMPRIV
	 * XMPRIV="99^y^y"
	 * 
	 * ****=DBITPRO WILL HAVE DIFFERENT VALUES FOR THE RETURNED DATA
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"
	 * XMV("DUZ NAME")="CXRYST,BUDT G"
	 * XMV("LAST USE")="03/05/14@14:28:23 (Surrogate: CXRYST,BUDT G)"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="POSTMASTER"
	 * XMV("NETNAME")=POSTMASTER@DEVNCH.VACO.VA.GOV
	 * XMV("NEW MSGS")=2191
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("RDR ASK")="N"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=1
	 * XMV("VERSION")="VA MailMan 8.0"
	 * 
	 * </pre>
	 */
	@Test
	public void testOther005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^No errors or warnings");
		results.add("XIA^I");
		results.add("PATCH,USER");
		results.add("");
		results.add("99^y^y");
		results.add("1");
		results.add("MR. MAILMAN");
		results.add("CXRYST,BUDT G");
		results.add("03/05/14@14:28:23 (Surrogate: CXRYST,BUDT G)");
		results.add("I");
		results.add("POSTMASTER");
		results.add("POSTMASTER@DEVNCH.VACO.VA.GOV");
		results.add("2191");
		results.add("R");
		results.add("1");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("N");
		results.add("C");
		results.add("0");
		results.add("1");
		results.add("1");
		results.add("VA MailMan 8.0");

		request.setDuz("1");
		request.setXmduz("11720");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.other(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));
	}

}
