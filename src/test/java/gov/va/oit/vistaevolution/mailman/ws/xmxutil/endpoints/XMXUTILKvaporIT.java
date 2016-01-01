/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILKvaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 * 
 */
public class XMXUTILKvaporIT extends EvolutionIT<XMXUTILKvaporEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUTILKvaporIT.class);

    /**
     * Test Case #1 - RPC w/ valid input
     * 
     * @throws VistaWebServiceFault
     *             , Exception
     */
    @Test
    public void testKvapor001() throws VistaWebServiceFault, Exception {
	/*
	 * XMXAPIAddrNSndEndpoint service2 =
	 * this.getEndpointImpl(XMXAPIAddrNSndEndpoint.class);
	 * 
	 * List<String> msg = new ArrayList<String>(); msg.add("LINE 1");
	 * msg.add("LINE 2"); List<String> xmto = new ArrayList<String>();
	 * xmto.add(""); List<XMInstr> xmInstr = Arrays.asList(new
	 * XMInstr("ADDR FLAGS", "I"));
	 * 
	 * XMXAPIAddrNSndResponse response2 = MailmanUtils.addrNSndMsg(service2,
	 * ".6", ".6", "INFO TOGGLE TEST", msg, "", xmto, xmInstr);
	 * 
	 * LOGGER.debug("msg ien: " + response2.getMsgIen());
	 */

	XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

	String newMailMessageIEN = MailUtils.createMailMessage(service2,
		null, null, null);

	XMXUTILKvaporRequest request = new XMXUTILKvaporRequest(".6", "1",
		newMailMessageIEN, "3140317");

	XMXUTILKvaporResponse response = service.kvapor(request);

	assertNotNull(response);
	assertTrue(response.getXmiu().equals("0^Successful"));

    }

    /**
     * Test Case #2 - Error in required input
     */
    @Test
    public void testKvapor002() {
	XMXUTILKvaporRequest request = new XMXUTILKvaporRequest("", "1",
		"74457", "3140317");

	XMXUTILKvaporResponse response = service.kvapor(request);

	assertNotNull(response);
	assertTrue(response.getXmiu().equals("-1^Error in required input"));
    }

    /**
     * Test Case #3 - Not a valid user
     */
    @Test
    public void testKvapor003() {
	XMXUTILKvaporRequest request = new XMXUTILKvaporRequest("9999", "1",
		"74457", "3140317");

	XMXUTILKvaporResponse response = service.kvapor(request);

	assertNotNull(response);
	assertTrue(response.getXmiu().equals("-1^Not a valid user"));
    }

    @Override
    protected Class<XMXUTILKvaporEndpoint> getType() {
	return XMXUTILKvaporEndpoint.class;
    }

}
