/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2KSeqNEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil2KSeqNIT extends EvolutionIT<XMXUtil2KSeqNEndpoint> {

    private static final String DUZ = ".5";

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2KSeqNIT.class);

    private XMDEndpoint service2;

    private XMXUtil2KSeqNRequest request;

    @Override
    protected Class<XMXUtil2KSeqNEndpoint> getType() {
	return XMXUtil2KSeqNEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXUtil2KSeqNRequest();
	request.setDuz(DUZ);
	request.setXmk("1");
    }

    /**
     * Sends message with XMD API.
     * 
     * @param xmDuz
     * @return
     */
    public String sendMessage(String xmDuz) {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    return MailUtils.createMailMessage(service2, null, xmDuz, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    /**
     * Input Data: >Set DUZ=.5,XMK=1,XMZ=59130
     * 
     * Procedure Call:
     * 
     * > D KSEQN^XMWSOA07(.DATA,DUZ,XMK,XMZ)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA=12
     * 
     * 
     * @throws VistaWebServiceFault
     * @throws InterruptedException
     */
    @Test
    public void testRetrieveSequenceNumber() throws Exception {
	// Waiting for 2 seconds after send to give the message time to show up
	// in bskt1.
	request.setXmz(sendMessage(DUZ));
	Thread.sleep(2000);

	LOGGER.debug(request);
	XMXUtil2KSeqNResponse response = service.kseqn(request);
	LOGGER.debug(response);

	assertTrue(response.getSequenceNumber().isEmpty()
		|| (Long.parseLong(response.getSequenceNumber()) > 1));
    }

    /**
     * Input Data: >Set U=”^”,DUZ=””,XMK=1,XMZ=59130
     * 
     * Procedure Call:
     * 
     * > D KSEQN^XMWSOA07(.DATA,DUZ,XMK,XMZ)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA="-1^Error in required input"
     */
    @Test
    public void testRetrieveSequenceNumberWithEmptyDuz() throws Exception {
	request.setDuz("");
	request.setXmz("50000");
	Thread.sleep(2000);

	LOGGER.debug(request);
	XMXUtil2KSeqNResponse response = service.kseqn(request);
	LOGGER.debug(response);

	assertEquals("-1", response.getStatus());
	assertEquals("Error in required input", response.getErrors().get(0));
    }

    /**
     * Input Data: >Set U=”^”,DUZ=1,XMK=15,XMZ=59130
     * 
     * Procedure Call:
     * 
     * > D KSEQN^XMWSOA07(.DATA,DUZ,XMK,XMZ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * 
     * @throws Exception
     */
    @Test
    public void testRetrieveSequenceNumberWithBadXMK() throws Exception {
	// Waiting for 2 seconds after send to give the message time to show up
	// in bskt1.
	request.setXmk("15");
	request.setXmz(sendMessage(DUZ));
	Thread.sleep(2000);

	LOGGER.debug(request);
	XMXUtil2KSeqNResponse response = service.kseqn(request);
	LOGGER.debug(response);

	assertTrue(response.getSequenceNumber().isEmpty());
    }

    /**
     * Input Data: >Set U=”^”,DUZ=1,XMK=1,XMZ=55508
     * 
     * Procedure Call:
     * 
     * > D KSEQN^XMWSOA07(.DATA,DUZ,XMK,XMZ)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA=””
     */
    @Test
    public void testRetrieveSequenceNumberWithBadDUZ() throws Exception {
	// Waiting for 2 seconds after send to give the message time to show up
	// in bskt1.
	request.setDuz("1");
	request.setXmz(sendMessage(DUZ));
	Thread.sleep(2000);

	LOGGER.debug(request);
	XMXUtil2KSeqNResponse response = service.kseqn(request);
	LOGGER.debug(response);

	assertTrue(response.getSequenceNumber().isEmpty());
    }
}
