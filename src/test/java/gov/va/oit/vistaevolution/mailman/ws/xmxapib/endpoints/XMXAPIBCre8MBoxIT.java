package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8MBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIBCre8MBoxIT extends EvolutionIT<XMXAPIBCre8MBoxEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBCre8MBoxIT.class);
    
    private XMXAPIBCre8MBoxRequest request;

    @Override
    protected Class<XMXAPIBCre8MBoxEndpoint> getType() {
	return XMXAPIBCre8MBoxEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPIBCre8MBoxRequest();
	request.setDuz(".5");
	request.setXmDuz("9026");
	request.setXmDate("");
    }

    /**
     * <em>Create a mailbox for the specified user DUZ.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=.5,XMDUZ=9026,XMDATE=””
     * 
     * Procedure Call:
     * 
     * >D CRE8MBOX^XMWSOA08(.DATA,DUZ,XMDUZ,XMDATE)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0^No errors"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testCreateMailbox() throws Exception {

	String expectedOutput = "0^No errors";

	LOGGER.debug(request);
	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[1], response.getResult());
    }

    /**
     * <em>Attempt to create a mailbox for the specified user XMDUZ and the user’s DUZ is not Postmaster or a surrogate.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=9027,XMDATE=””
     * 
     * Procedure Call:
     * 
     * >D CRE8MBOX^XMWSOA08(.DATA,DUZ,XMDUZ,XMDATE)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^User must be Postmaster or a surrogate"
     * </pre>
     */
    @Test
    public void testCreateMailboxAsBadUser() throws Exception {
	String expectedOutput = "-1^User must be Postmaster or a surrogate";

	request.setDuz("1");

	LOGGER.debug(request);
	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * <em>Attempt to create a mailbox for the specified user XMDUZ and the DUZ is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ="",XMDUZ=9027,XMDATE=””
     * 
     * Procedure Call:
     * 
     * >D CRE8MBOX^XMWSOA08(.DATA,DUZ,XMDUZ,XMDATE)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     */
    @Test
    public void testCreateMailboxWithEmptyDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setDuz("");

	LOGGER.debug(request);
	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * <em>Attempt to create a mailbox for the specified user, but XMDUZ is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=.5,XMDUZ=””,XMDATE=””
     * 
     * Procedure Call:
     * 
     * >D CRE8MBOX^XMWSOA08(.DATA,DUZ,XMDUZ,XMDATE)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     */
    @Test
    public void testCreateMailboxWithEmptyXMDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setXmDuz("");

	LOGGER.debug(request);
	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);
	LOGGER.debug(response);
	
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
