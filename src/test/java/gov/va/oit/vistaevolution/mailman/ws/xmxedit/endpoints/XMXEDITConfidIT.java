/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfidEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITConfidIT extends EvolutionIT<XMXEDITConfidEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITConfidIT.class);
	
	/**
	 *  Test Case #1: -1^Message not found
	 */
	@Test
	public void testConfid001() {
		XMXEDITConfidRequest request = new XMXEDITConfidRequest(); 
		
		request.setXmz("999");
		request.setXminstr("C");
		
		XMXEDITConfidResponse response = service.confid(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getXmmsg() + " " + response.getXminstr());
		
		assertTrue(response.getXmmsg().equals("-1^Message not found"));
	}

	/**
	 *  Test Case #2: -1^Error in required input
	 */
	@Test
	public void testConfid002() {
		XMXEDITConfidRequest request = new XMXEDITConfidRequest(); 

		request.setXmz("73994");
		request.setXminstr("");
		
		XMXEDITConfidResponse response = service.confid(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getXmmsg() + " " + response.getXminstr());
		
		assertTrue(response.getXmmsg().equals("-1^Error in required input"));
	}

	/**
	 *  Test Case #3: Set the confidential flag for a message
	 */
	@Ignore
	@Test
	public void testConfid003() {
		/*
		XMXAPIAddrNSndResponse msgResponse = msgService.AddrNSnd(msgRequest);
		
		request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("C");
		
		XMXEDITConfidResponse response = service.confid(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getXmmsg() + " " + response.getXminstr());
		
		assertTrue(response.getXmmsg().equals("0^'Confidential' flag removed.^"));
		*/
	}

	/**
	 *  Test Case #4: Set the closed flag for a message w/ all flags passed in
	 */
	@Ignore
	@Test
	public void testConfid004() {
		/*
		XMXAPIAddrNSndResponse msgResponse = msgService.AddrNSnd(msgRequest);
		
		request.setXmz(msgResponse.getMsgIen());
		request.setXminstr("PIXCSRF");
		
		XMXEDITConfidResponse response = service.confid(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getXmmsg() + " " + response.getXminstr());
		
		assertTrue(response.getXmmsg().equals("0^'Confidential' flag removed.^PIXSRF"));
		*/
	}
	/*
	private static void createMsgRequest() {
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
		msg.add("ZZ BASE Test case for API XMXAPI-ADDRNSND");
		
		ArrayList<String> xmto = new ArrayList<String>();
		xmto.add("POSTMASTER");
		
		String duz = ".5";
		String xmDuz = ".5";
		String xmSubj = "ZZ VISTA API EXPOSURE XMXAPI-ADDRNSND";
		String xmStrip = "";
		String xmInstr = "I";
		msgRequest  = new XMXAPIAddrNSndRequest();
		msgRequest.setDuz(duz);
		msgRequest.setXmDuz(xmDuz);
		msgRequest.setXmSubj(xmSubj);
		msgRequest.setXmz(msg);
		msgRequest.setXmStrip(xmStrip);
		msgRequest.setXmto(xmto);
		msgRequest.setXmInstr(xmInstr);
	}
	*/

	@Override
	protected Class<XMXEDITConfidEndpoint> getType() {
		return XMXEDITConfidEndpoint.class;
	}
}
