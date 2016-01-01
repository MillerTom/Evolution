/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITPriorityEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITPriorityIT extends EvolutionIT<XMXEDITPriorityEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITPriorityIT.class);

	/**
	 * Test Case #1 - Set priority flag with valid input
	 */
	@Test
	public void testPriority001() throws VistaWebServiceFault, Exception {
		/*
		XMXAPIAddrNSndEndpoint service2 = this.getEndpointImpl(XMXAPIAddrNSndEndpoint.class);
		
		List<String> msg = new ArrayList<String>();
		msg.add("LINE 1");
		msg.add("LINE 2");
		List<String> xmto = new ArrayList<String>();
		xmto.add("");
		List<XMInstr> xmInstr = Arrays.asList(new XMInstr("ADDR FLAGS", "I"));
		
		XMXAPIAddrNSndResponse response2 = MailmanUtils.addrNSndMsg(service2, ".6", ".6", "INFO TOGGLE TEST", msg, "", xmto, xmInstr);
		
		LOGGER.debug("msg ien: " + response2.getMsgIen());
		*/
		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);
		
		String newMailMessageIEN = MailUtils.createMailMessage(service2, null, null, null);
		XMXEDITPriorityRequest request = new XMXEDITPriorityRequest(newMailMessageIEN);
		
		XMXEDITPriorityResponse response = service.priority(request);
		
		LOGGER.debug("response: " + response.getXmmsg());
		
		assertNotNull(response);      
        assertTrue(response.getXmmsg().equals("0^Successful"));
	}

	/**
	 * Test Case #2 - Set priority flag with valid input
	 */
	@Test
	public void testPriority002() throws VistaWebServiceFault {
		XMXEDITPriorityRequest request = new XMXEDITPriorityRequest("0");
		
		XMXEDITPriorityResponse response = service.priority(request);
		
		LOGGER.debug("response: " + response.getXmmsg());
		
		assertNotNull(response);      
        assertTrue(response.getXmmsg().equals("-1^Error in required input"));
	}

	/**
	 * Test Case #3 - Set priority flag with valid input
	 */
	@Test
	public void testPriority003() throws VistaWebServiceFault {
		XMXEDITPriorityRequest request = new XMXEDITPriorityRequest("-9999");
		
		XMXEDITPriorityResponse response = service.priority(request);
		
		LOGGER.debug("response: " + response.getXmmsg());
		
		assertNotNull(response);      
        assertTrue(response.getXmmsg().equals("-1^Message not found"));
	}

	@Override
	protected Class<XMXEDITPriorityEndpoint> getType() {
		return XMXEDITPriorityEndpoint.class;
	}

}
