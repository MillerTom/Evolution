/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.utils.MailmanUtils;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAnsrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2QrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 * 
 */
public class XMXUTIL2QrespIT extends EvolutionIT<XMXUTIL2QrespEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUTIL2QrespIT.class);

    /**
     * Use Case #1: -1^Message not found
     */
    @Test
    public void testQresp001() throws VistaWebServiceFault {

	XMXUTIL2QrespRequest request = new XMXUTIL2QrespRequest();

	request.setXmz("999");
	request.setXmwhich("");

	XMXUTIL2QrespResponse response = service.qresp(request);

	LOGGER.debug("Msg ien: " + response.getResponse());

	assertNotNull(response);
	assertTrue(response.getResponse().startsWith("-1"));
    }

    /**
     * Use Case #2: Check the response status for a message that’s not a
     * response
     */
    @Ignore
    @Test
    public void testQresp002() throws VistaWebServiceFault, Exception {
	/*
	 * XMXAPIAddrNSndEndpoint service2 =
	 * this.getEndpointImpl(XMXAPIAddrNSndEndpoint.class);
	 * 
	 * List<String> msg = new ArrayList<String>();
	 * msg.add("CONFIRM TOGGLE"); List<String> xmto = new
	 * ArrayList<String>(); xmto.add(""); List<XMInstr> xmInstr =
	 * Arrays.asList(new XMInstr("ADDR FLAGS", "I"));
	 * 
	 * XMXAPIAddrNSndResponse response2 = MailmanUtils.addrNSndMsg(service2,
	 * "1", "1", "XMWSOA CONFIRM TOGGLE TEST", msg, "", xmto, xmInstr);
	 * 
	 * LOGGER.debug("msg ien: " + response2.getMsgIen());
	 */
    }
    /**
     * Use Case #3: Check response status for message
     */
    @Ignore
    @Test
    public void testQresp003() throws VistaWebServiceFault, Exception {
	/*
	 * XMXAPIAddrNSndEndpoint service2 =
	 * this.getEndpointImpl(XMXAPIAddrNSndEndpoint.class);
	 * 
	 * List<String> msg = new ArrayList<String>();
	 * msg.add("IS MSG RESPONSE 1"); List<String> xmto = new
	 * ArrayList<String>(); xmto.add(""); List<XMInstr> xmInstr =
	 * Arrays.asList(new XMInstr("ADDR FLAGS", "I"));
	 * 
	 * XMXAPIAddrNSndResponse response2 = MailmanUtils.addrNSndMsg(service2,
	 * "1", "1", "XMWSOA IS MSG RESPONSE TEST", msg, "", xmto, xmInstr);
	 * 
	 * LOGGER.debug("msg ien: " + response2.getMsgIen());
	 */
	XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

	String newMailMessageIEN = MailUtils.createMailMessage(service2,
		null, null, null);

	List<String> msg = new ArrayList<String>();
	msg.add("RESPONSE LINE 1");

	List<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry(newMailMessageIEN, ""));

	XMXAPIAnsrMsgEndpoint service3 = this
		.getEndpointImpl(XMXAPIAnsrMsgEndpoint.class);

	XMXAPIAnsrMsgResponse response3 = MailmanUtils.ansrMsgM(service3, "1",
		"1", newMailMessageIEN, "RESPONSE SUBJECT", msg, xmto);

	XMXUTIL2QrespRequest request = new XMXUTIL2QrespRequest(
		response3.getXmz());

	XMXUTIL2QrespResponse response = service.qresp(request);

	LOGGER.debug("response: " + response.getResponse());

	assertNotNull(response);
	assertTrue(response.getResponse().startsWith("0"));

    }

    @Override
    protected Class<XMXUTIL2QrespEndpoint> getType() {
	return XMXUTIL2QrespEndpoint.class;
    }

}
