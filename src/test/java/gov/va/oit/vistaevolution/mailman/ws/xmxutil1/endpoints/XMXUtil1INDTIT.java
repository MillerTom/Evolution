/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1INDTEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil1INDTIT extends EvolutionIT<XMXUtil1INDTEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXUtil1INDTIT.class);

    @Override
    protected Class<XMXUtil1INDTEndpoint> getType() {
	return XMXUtil1INDTEndpoint.class;
    }
    
    /**
     * Submits a request with logging and tests response.
     * 
     * @param expectedResult
     * @param vistaDate
     */
    public void submitRequest(String expectedResult, String vistaDate) {
	XMXUtil1INDTRequest request = new XMXUtil1INDTRequest(vistaDate);
	LOGGER.debug(request);

	XMXUtil1INDTResponse response = service.indt(request);
	LOGGER.debug(response);
	assertEquals(expectedResult, response.getDate());
    }

    /**
     * <em>Retrieve external date from a Fileman date</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,INDT=”3140113.133624”
     * 
     * Procedure Call:
     * 
     * >S DATA=$$INDT^XMXUTIL1(INDT)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="13 Jan 2014 13:36:24 -0500 (EST)"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testConvertFulleDateTime() throws VistaWebServiceFault {
	String expectedResult = "13 Jan 2014 13:36:24 -0500 (EST)";

	String vistaDate = "3140113.133624";

	submitRequest(expectedResult, vistaDate);
    }

    /**
     * <em>Retrieve external date from a Fileman date where input is “”</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,INDT=””
     * 
     * Procedure Call:
     * 
     * > D INDT^XMWSOA06(.DATA,INDT)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testEmptyInput() throws VistaWebServiceFault {

	XMXUtil1INDTRequest request = new XMXUtil1INDTRequest("");
	LOGGER.debug(request);

	XMXUtil1INDTResponse response = service.indt(request);
	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * <em> Retrieve external date from a Fileman date where input is just contains date, no time component </em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,INDT=”3140113”
     * 
     * Procedure Call:
     * 
     * > D INDT^XMWSOA06(.DATA,INDT)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="13 Jan 2014 00:00:00 -0500 (EST)"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testConvertDateOnly() throws VistaWebServiceFault {
	String expectedResult = "13 Jan 2014 00:00:00 -0500 (EST)";

	String vistaDate = "3140113";
	submitRequest(expectedResult, vistaDate);

    }

    /**
     * <em>Retrieve external date from a Fileman date where input is just contains
     * time, no date component</em>
     * 
     * <pre>
     * Input Data: >Set U=”^”,INDT=”.133624”
     * 
     * Procedure Call:
     * 
     * > D INDT^XMWSOA06(.DATA,INDT)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0 .133624 0 00:00:00 -0500 (EST)"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testConvertTimeOnly() throws VistaWebServiceFault {
	String expectedResult = "0 .133624 0 00:00:00 -0500 (EST)";

	String vistaDate = ".133624";
	submitRequest(expectedResult, vistaDate);

    }


}
