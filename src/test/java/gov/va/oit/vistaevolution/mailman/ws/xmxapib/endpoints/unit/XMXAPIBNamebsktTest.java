/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBNamebsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBNamebsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for NAMEBSKT method of XMXAPIB Webservice
 */
public class XMXAPIBNamebsktTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIBNamebsktTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=""
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNamebskt001() throws VistaWebServiceFault {

		String expectedOutput = "ERROR,-1^Error in required input";

		XMXAPIBNamebsktRequest request = new XMXAPIBNamebsktRequest("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIBNamebsktEndpoint service = new XMXAPIBNamebsktEndpointImpl(
				getVistaLinkContext(), new XMXAPIBResponseFactory());

		XMXAPIBNamebsktResponse response = service.namebskt(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getErrors().get(1));
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Set up User’s Vital Information. Use DUZ=.5
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
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
	public void testNamebskt002() throws VistaWebServiceFault {

		String expectedOutput = "WARNING,1^Priority Mail";

		XMXAPIBNamebsktRequest request = new XMXAPIBNamebsktRequest(".5");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXAPIBNamebsktEndpoint service = new XMXAPIBNamebsktEndpointImpl(
				getVistaLinkContext(), new XMXAPIBResponseFactory());

		XMXAPIBNamebsktResponse response = service.namebskt(request);

		assertNotNull(response);
		assertEquals("WARNING,1^Priority Mail",
				response.getSettingsList().get(0));
	}
}
