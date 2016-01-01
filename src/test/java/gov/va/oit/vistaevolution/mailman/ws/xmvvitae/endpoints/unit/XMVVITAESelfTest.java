/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.XMVVITAEResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.XMVVITAESelfEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAESelfEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for SELF method of XMVVITAE Webservice
 */
public class XMVVITAESelfTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAESelfTest() {
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

		String expectedOutput = "ERROR,-1^Error in required input\n" + "\n"
				+ "\n" + "";

		XMVVITAESelfRequest request = new XMVVITAESelfRequest();
		request.setDuz("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAESelfEndpoint service = new XMVVITAESelfEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAESelfResponse response = service.self(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

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
	public void testSelf002() throws VistaWebServiceFault {

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

		String expectedOutput = "WARNING,1^Priority Mail\n"
				+ "CUNNINGHAM,ALLEN\n" + "\n" + "1\n" + "CUNNINGHAM,ALLEN\n"
				+ "03/18/14@18:10:08\n" + "I\n" + "CUNNINGHAM,ALLEN\n"
				+ "CUNNINGHAM.ALLEN@DEVNCH.VACO.VA.GOV\n" + "23\n" + "R\n"
				+ "1\n" + "0\n" + "1\n" + "0\n" + "Y\n" + "C\n" + "0\n" + "1\n"
				+ "0\n" + "VA MailMan 8.0\n" + "Priority Mail";

		XMVVITAESelfRequest request = new XMVVITAESelfRequest();
		request.setDuz("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMVVITAESelfEndpoint service = new XMVVITAESelfEndpointImpl(
				getVistaLinkContext(), new XMVVITAEResponseFactory());

		XMVVITAESelfResponse response = service.self(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

}
