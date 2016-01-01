package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGGotLocalEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author Joshua.Zangari
 * 
 */
public class XMXAPIGGotLocalIT extends EvolutionIT<XMXAPIGGotLocalEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIGGotLocalIT.class);

    @Override
    protected Class<XMXAPIGGotLocalEndpoint> getType() {
	return XMXAPIGGotLocalEndpoint.class;
    }

    /**
     * <em>Determine if GROUP has local users</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,GROUP=”THIS IS A TEST”,XDAYS=””
     * 
     * Procedure Call:
     * 
     * >D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=1
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */

    @Test
    public void testWithValidGroupName() throws VistaWebServiceFault {
	String expectedResponse = "1";

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("THIS IS A TEST");

	LOGGER.debug(request);

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	LOGGER.debug(response);

	assertEquals(expectedResponse, response.getContainsLocalMembers());
    }

    /**
     * <em>Output if group is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DT=3140204,GROUP=””,XDAYS=””
     * 
     * Procedure Call:
     * 
     * >D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testWithEmptyGroupName() throws Exception {

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("");

	LOGGER.debug(request);

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * Determine return code if the group name is non-existent.
     * 
     * Input Data: >Set U=”^”,DT=3140204,GROUP=”ZZNOSUCHGROUP”,XDAYS=””
     * 
     * Procedure Call:
     * 
     * > D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA="-1^Mail group 'ZZNOSUCHGROUP' not found."
     * 
     * @throws Exception
     */
    @Test
    public void testWithInvalidGroupName() throws Exception {

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("ZZNOSUCHGROUP");

	LOGGER.debug(request);

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * Determine return code if the group IEN is non-existent.
     * 
     * Input Data: >Set U=”^”,DT=3140204,DUZ=53387,GROUP=2500,XDAYS=””
     * 
     * Procedure Call:
     * 
     * > D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA="-1^Mail group IEN '2500' not found."
     * 
     * @throws Exception
     */
    @Test
    public void testWithInvalidIEN() throws Exception {

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("2500");

	LOGGER.debug(request);

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * Determine return code for the group IEN
     * 
     * Input Data: >Set U=”^”,DT=3140204,GROUP=172,XDAYS=””
     * 
     * Procedure Call:
     * 
     * > D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA=1
     * 
     * @throws Exception
     */
    @Test
    public void testWithValidIEN() throws Exception {

	String expectedResponse = "1";

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("172");

	LOGGER.debug(request);

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	LOGGER.debug(response);

	assertEquals(expectedResponse, response.getContainsLocalMembers());
    }

}
