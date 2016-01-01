/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZSUBJEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil2ZSUBJIT extends EvolutionIT<XMXUtil2ZSUBJEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2ZSUBJIT.class);

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
     */
    @Override
    protected Class<XMXUtil2ZSUBJEndpoint> getType() {
	return XMXUtil2ZSUBJEndpoint.class;
    }

    /**
     * <em>Retrieve subject for the specified message XMX</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=58880
     * 
     * Procedure Call:
     * 
     * > D ZSUBJ^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="LEX*2.0*69 Installation"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSubjectForXmx() throws VistaWebServiceFault {
	String expectedResult = "LEX*2.0*69 Installation";

	XMXUtil2ZSUBJRequest request = new XMXUtil2ZSUBJRequest("58880");
	LOGGER.debug(request);
	XMXUtil2ZSUBJResponse response = service.zsubj(request);
	LOGGER.debug(response);
	assertEquals(expectedResult, response.getSubject());
    }

    /**
     * <em> Retrieve subject for the specified message IEN, but the IEN is not a valid message IEN.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=58777
     * 
     * Procedure Call:
     * 
     * > D ZSUBJ^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Message not found"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSubjectForInvalidXmx() throws VistaWebServiceFault {

	XMXUtil2ZSUBJRequest request = new XMXUtil2ZSUBJRequest("58777");
	LOGGER.debug(request);
	XMXUtil2ZSUBJResponse response = service.zsubj(request);
	LOGGER.debug(response);
	assertNotNull(response.getErrors());

    }

    /**
     * <em>Attempt to retrieve subject for an empty message IEN.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=””
     * 
     * Procedure Call:
     * 
     * > D ZSUBJ^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * 
     * <pre>
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSubjectForMissingXmx() throws VistaWebServiceFault {

	XMXUtil2ZSUBJRequest request = new XMXUtil2ZSUBJRequest("");
	LOGGER.debug(request);
	XMXUtil2ZSUBJResponse response = service.zsubj(request);
	LOGGER.debug(response);
	assertNotNull(response.getErrors());

    }

}
