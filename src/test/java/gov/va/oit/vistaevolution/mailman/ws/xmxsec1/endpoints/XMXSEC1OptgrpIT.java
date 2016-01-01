/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEInitEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1OptgrpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpResponse;
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
 *         Integration Test for OPTGRP method of XMXSEC1 Webservice
 */
public class XMXSEC1OptgrpIT extends EvolutionIT<XMXSEC1OptgrpEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC1OptgrpIT.class);

	private XMXSEC1OptgrpRequest request;
	private XMXSEC1OptgrpResponse response;
	private XMVVITAEInitEndpoint initService;

	@Override
	protected Class<XMXSEC1OptgrpEndpoint> getType() {
		return XMXSEC1OptgrpEndpoint.class;
	}

	@Before
	public void setUp() throws Exception {
		request = new XMXSEC1OptgrpRequest();
		initService = getEndpointImpl(XMVVITAEInitEndpoint.class);
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC1OptgrpIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. Set XMDUZ to null.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=""
	 * >S XMK=1
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Error in required input");

		request.setXmduz("");
		request.setXmk("1");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optgrp(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Set XMK to null.
	 * 
	 * <pre>
	 *   Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=83323
	 * >S XMK=""
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Error in required input");

		request.setXmduz("83323");
		request.setXmk("");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optgrp(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Use an invalid user.
	 * 
	 * <pre>
	 *   Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=999999
	 * >S XMK=1
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,0)="-1^Not a valid user"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Not a valid user");

		request.setXmduz("999999");
		request.setXmk("1");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optgrp(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Return what the user can do at the basket or group level.
	 * 
	 * <pre>
	 *   **** ***Set up the User’s Vital Information******
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
	 * XMV("BANNER")="MR. MAILMAN"   **DBITPRO  XMV("BANNER")="POSTMASTER"
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
	 * 
	 * 
	 * 
	 * ****** Conduct the RPC Test Case******
	 * 
	 * Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=.5
	 * >S XMK=1
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,"C")="XMOPT(""C"")=Change the name of this basket"
	 * ^TMP("XMLIST",544233156,"C","?")="XMOPT(""C"",""?"")=The name of this basket may not be changed."
	 * ^TMP("XMLIST",544233156,"D")="XMOPT(""D"")=Delete messages"
	 *                         "F")="XMOPT(""F"")=Forward messages"
	 *                        "FI")="XMOPT(""FI"")=Filter messages"
	 *                         "H")="XMOPT(""H"")=Headerless Print messages"
	 *                         "L")="XMOPT(""L"")=Later messages"
	 *                         "N")="XMOPT(""N"")=New message list"
	 *                        "NT")="XMOPT(""NT"")=New Toggle messages"
	 *                         "P")="XMOPT(""P"")=Print messages"
	 *                         "Q")="XMOPT(""Q"")=Query (search for) messages"
	 *                         "R")="XMOPT(""R"")=Resequence messages"
	 *                         "S")="XMOPT(""S"")=Save messages to another basket"
	 *                         "T")="XMOPT(""T"")=Terminate messages"
	 *                         "V")="XMOPT(""V"")=Vaporize date set messages"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp004() throws VistaWebServiceFault {

		XMVVITAEInitRequest initRequest = new XMVVITAEInitRequest(".5", ".5");
		XMVVITAEInitResponse initResponse = initService.init(initRequest);
		assertNotNull(initResponse);

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMOPT(\"C\")=Change the name of this basket");
		results.add("XMOPT(\"C\",\"?\")=The name of this basket may not be changed.");
		results.add("XMOPT(\"D\")=Delete messages");
		results.add("XMOPT(\"F\")=Forward messages");
		results.add("XMOPT(\"FI\")=Filter messages");
		results.add("XMOPT(\"H\")=Headerless Print messages");
		results.add("XMOPT(\"L\")=Later messages");
		results.add("XMOPT(\"N\")=New message list");
		results.add("XMOPT(\"NT\")=New Toggle messages");
		results.add("XMOPT(\"P\")=Print messages");
		results.add("XMOPT(\"Q\")=Query (search for) messages");
		results.add("XMOPT(\"R\")=Resequence messages");
		results.add("XMOPT(\"S\")=Save messages to another basket");
		results.add("XMOPT(\"T\")=Terminate messages");
		results.add("XMOPT(\"V\")=Vaporize date set messages");

		request.setXmduz(".5");
		request.setXmk("1");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optgrp(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOptionsDataList().get(0));
	}
}
