/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAESelfEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfResponse;
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
 *         Integration Test for SELF method of XMVVITAE Webservice
 */
public class XMVVITAESelfIT extends EvolutionIT<XMVVITAESelfEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMVVITAESelfIT.class);

	private XMVVITAESelfRequest request;
	private XMVVITAESelfResponse response;

	@Override
	protected Class<XMVVITAESelfEndpoint> getType() {
		return XMVVITAESelfEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMVVITAESelfRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAESelfIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >K XMDUN
	 * >K XMNOSEND
	 * >S DUZ=""
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * >ZW XMDUN
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMV
	 * 
	 * </pre>
	 */
	@Test
	public void testSelf001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1^Error in required input");
		results.add("");
		results.add("");
		results.add("");

		request.setDuz("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.self(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. User 9999999 is not an Active user.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >K XMDUN
	 * >K XMNOSEND
	 * >S DUZ=9999999
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^DUZ 9999999 is not an active user"
	 * 
	 * >ZW XMDUN
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMV
	 * 
	 * </pre>
	 */
	@Test
	public void testSelf002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ERROR,-1^DUZ 9999999 is not an active user");
		results.add("");
		results.add("");
		results.add("");

		request.setDuz("9999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.self(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * No errors or warnings. Use DUZ=.5
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >K XMDUN
	 * >K XMNOSEND
	 * >S DUZ=.5
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="0^No errors or warnings"
	 * 
	 * >ZW XMDUN
	 * XMDUN="POSTMASTER"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"
	 * XMV("DUZ NAME")="POSTMASTER"
	 * XMV("LAST USE")="03/18/14@18:13:39"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="POSTMASTER"
	 * XMV("NETNAME")="POSTMASTER@DEVNCH.VACO.VA.GOV"
	 * XMV("NEW MSGS")=2235
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
	public void testSelf003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^No errors or warnings");
		results.add("");
		results.add("");
		results.add("1");
		results.add("MR. MAILMAN");
		results.add("POSTMASTER");
		results.add("03/18/14@18:13:39");
		results.add("I");
		results.add("POSTMASTER");
		results.add("POSTMASTER@DEVNCH.VACO.VA.GOV");
		results.add("2235");
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

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.self(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * No errors or warnings. Use DUZ=83323
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >K XMDUN
	 * >K XMNOSEND
	 * >S DUZ=83323    <- **DBITPRO use:  >S DUZ=1
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="WARNING,1^Priority Mail"
	 * 
	 * >ZW XMDUN
	 * XMDUN="CUNNINGHAM,ALLEN"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("DUZ NAME")="CUNNINGHAM,ALLEN"
	 * XMV("LAST USE")="03/18/14@18:10:08"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="CUNNINGHAM,ALLEN"
	 * XMV("NETNAME")="CUNNINGHAM.ALLEN@DEVNCH.VACO.VA.GOV"
	 * XMV("NEW MSGS")=23
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("RDR ASK")="Y"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * XMV("WARNING",1)="Priority Mail"
	 * 
	 * </pre>
	 */
	@Test
	public void testSelf004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("WARNING,1^Priority Mail");
		results.add("CUNNINGHAM,ALLEN");
		results.add("");
		results.add("1");
		results.add("CUNNINGHAM,ALLEN");
		results.add("03/18/14@18:10:08");
		results.add("I");
		results.add("CUNNINGHAM,ALLEN");
		results.add("CUNNINGHAM.ALLEN@DEVNCH.VACO.VA.GOV");
		results.add("23");
		results.add("R");
		results.add("1");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("Y");
		results.add("C");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("VA MailMan 8.0");
		results.add("Priority Mail");

		request.setDuz("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.self(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * No errors or warnings. Use DUZ=.6
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >K XMDUN
	 * >K XMNOSEND
	 * >S DUZ=.6
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="WARNING,1^Priority Mail"
	 * 
	 * >ZW XMDUN
	 * XMDUN="SHARED,MAIL"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("DUZ NAME")="SHARED,MAIL"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="SHARED,MAIL"
	 * XMV("NETNAME")="SHARED.MAIL@DEVNCH.VACO.VA.GOV"
	 * XMV("NEW MSGS")=16
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("RDR ASK")="Y"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * XMV("WARNING",1)="Priority Mail"
	 * 
	 * </pre>
	 */
	@Test
	public void testSelf005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("WARNING,1^Priority Mail");
		results.add("SHARED,MAIL");
		results.add("");
		results.add("1");
		results.add("SHARED,MAIL");
		results.add("I");
		results.add("CUNNINGHAM,ALLEN");
		results.add("SHARED.MAIL@DEVNCH.VACO.VA.GOV");
		results.add("16");
		results.add("R");
		results.add("1");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("Y");
		results.add("C");
		results.add("0");
		results.add("1");
		results.add("0");
		results.add("VA MailMan 8.0");
		results.add("Priority Mail");

		request.setDuz(".6");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.self(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

}
