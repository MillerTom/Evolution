/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2LineEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUTIL2LineIT extends EvolutionIT<XMXUtil2LineEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXUTIL2LineIT.class);

    @Override
    protected Class<XMXUtil2LineEndpoint> getType() {
	return XMXUtil2LineEndpoint.class;
    }

    /**
     * <em> Retrieve number of lines in the specified mail message IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=55906
     * 
     * Procedure Call:
     * 
     * >S DATA=$$LINE^XMXUTIL2(MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=4
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveNumberOfLines() throws VistaWebServiceFault {

	XMXUtil2LineRequest request = new XMXUtil2LineRequest("58880");

	LOGGER.debug(request);

	XMXUtil2LineResponse response = service.line(request);

	LOGGER.debug(response);

	assertNotNull(response.getNumOfLines());

    }

    /**
     * <em>Retrieve number of lines in the specified mail message IEN, this IEN does not correspond to a message</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=55921
     * 
     * Procedure Call:
     * 
     * > D LINE^XMWSOA07(.DATA,MSG)
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
    public void testRetrieveWithBadID() throws VistaWebServiceFault {

	XMXUtil2LineRequest request = new XMXUtil2LineRequest("55906");

	LOGGER.debug(request);

	XMXUtil2LineResponse response = service.line(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());

    }

    /**
     * <em>Retrieve number of lines in the specified mail message IEN, where the IEN is the empty string</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=””
     * 
     * Procedure Call:
     * 
     * > D LINE^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * > D LINE^XMWSOA07(.DATA,MSG)
     * DATA="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testWithEmptyIEN() throws Exception {
	XMXUtil2LineRequest request = new XMXUtil2LineRequest("");

	LOGGER.debug(request);

	XMXUtil2LineResponse response = service.line(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

}
