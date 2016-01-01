/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2FromEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class XMXUTIL2FromIT extends EvolutionIT<XMXUtil2FromEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXUTIL2FromIT.class);
    private XMDEndpoint service2;
    private XMXUtil2FromRequest request;

    @Override
    protected Class<XMXUtil2FromEndpoint> getType() {
	return XMXUtil2FromEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXUtil2FromRequest();
    }

    /**
     * Sends message with XMD API.
     * 
     * @param xmDuz
     * @return
     */
    public String sendMessage(String duz, String xmDuz) {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    return MailUtils.createMailMessageWithFrom(service2, duz, null,
		    xmDuz, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    /**
     * Input Data: >Set MSG=58880
     * 
     * Procedure Call:
     * 
     * >D FROM^XMWSOA06(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA="POSTMASTER"
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveFromByXMZ() throws VistaWebServiceFault {
	request.setXmz(sendMessage(".5", ".5"));
	LOGGER.debug(request);

	XMXUtil2FromResponse response = service.from(request);

	LOGGER.debug(response);

	assertEquals("POSTMASTER", response.getName());

    }

    /**
     * Input Data: >Set MSG=””
     * 
     * Procedure Call:
     * 
     * >D FROM^XMWSOA06(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * 
     * DATA="-1^Error in required input"
     */
    @Test
    public void testRetrieveFromWithEmptyXMZ() throws Exception {
	request.setXmz("");
	LOGGER.debug(request);

	XMXUtil2FromResponse response = service.from(request);

	LOGGER.debug(response);

	assertEquals("-1", response.getStatus());
	assertEquals("Error in required input", response.getErrors().get(0));

    }

}
