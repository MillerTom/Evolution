/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.XMVVITAEResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.XMVVITAEInitEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEInitEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for INIT method of XMVVITAE Webservice
 */
public class XMVVITAEInitTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAEInitTest() {
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

		String expectedOutput = "ERROR,-1^Error in required input";

		XMVVITAEInitRequest request = new XMVVITAEInitRequest();
		request.setDuz("");
		request.setXmduz(".5");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAEInitEndpoint service = new XMVVITAEInitEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAEInitResponse response = service.init(request);

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #2  </em>
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
	public void testInit002() throws VistaWebServiceFault {

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

		String expectedOutput = "0^No errors or warnings";

		XMVVITAEInitRequest request = new XMVVITAEInitRequest();
		request.setDuz(".5");
		request.setXmduz(".6");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAEInitEndpoint service = new XMVVITAEInitEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAEInitResponse response = service.init(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));
	}

}
