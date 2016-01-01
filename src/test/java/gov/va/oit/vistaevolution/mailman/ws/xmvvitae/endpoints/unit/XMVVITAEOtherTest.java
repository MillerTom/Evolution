/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.XMVVITAEResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.XMVVITAEOtherEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEOtherEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for for OTHER method of XMVVITAE Webservice
 */
public class XMVVITAEOtherTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAEOtherTest() {
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

		String expectedOutput = "ERROR,-1^Error in required input";

		XMVVITAEOtherRequest request = new XMVVITAEOtherRequest();
		request.setDuz("");
		request.setXmduz(".5");
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAEOtherEndpoint service = new XMVVITAEOtherEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAEOtherResponse response = service.other(request);

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());
	}

	/**
	 * <em>Test Case #2  </em>
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
	public void testOther002() throws VistaWebServiceFault {

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

		String expectedOutput = "0^No errors or warnings";

		XMVVITAEOtherRequest request = new XMVVITAEOtherRequest();
		request.setDuz("1");
		request.setXmduz("11720");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAEOtherEndpoint service = new XMVVITAEOtherEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAEOtherResponse response = service.other(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));
	}

}
