package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQMBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIBQMBoxIT extends EvolutionIT<XMXAPIBQMBoxEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXAPIBQMBoxIT.class);

    private XMXAPIBQMBoxRequest request;

    @Override
    protected Class<XMXAPIBQMBoxEndpoint> getType() {
	return XMXAPIBQMBoxEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPIBQMBoxRequest();
	request.setDuz("1");
	request.setXmDuz("1");
    }

    /**
     * Test Send Successful Request
     * 
     * Input Data: >S DUZ=1,XMDUZ=1
     * 
     * Procedure Call: > D QMBOX^XMWSOA08(.DATA,DUZ,XMDUZ)
     * 
     * Expected Output: >ZW DATA DATA="448^1^447^3140319.205724^0^447^1^IN"
     * 
     * @throws Exception
     */
    @Test
    public void testGetMailBoxInfo() throws Exception {

	LOGGER.debug(request);

	XMXAPIBQMBoxResponse response = service.qMBox(request);

	LOGGER.debug(response);

	assertNotNull(response.getNumOfNewMsgs());

	assertNotNull(response.getNewPriorityMail());

	assertNotNull(response.getNumOfNewMsgsForINBskt());

	assertNotNull(response.getDateLastMsgRecieved());

	assertNotNull(response.getNewMessagesSinceLastChecked());

	assertNotNull(response.getBasketIen());

	assertNotNull(response.getBasketName());
    }

    /**
     * Test with Empty DUZ.
     * 
     * Input Data: >S DUZ=1,XMDUZ=””
     * 
     * Procedure Call: > D QMBOX^XMWSOA08(.DATA,DUZ,XMDUZ)
     * 
     * Expected Output: >ZW DATA DATA="-1^Error in required input"
     */
    @Test
    public void testGetMailBoxInfoWithEmptyDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setDuz("");

	LOGGER.debug(request);

	XMXAPIBQMBoxResponse response = service.qMBox(request);

	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Input Data: >S DUZ=2,XMDUZ=2
     * 
     * Procedure Call: > D QMBOX^XMWSOA08(.DATA,DUZ,XMDUZ)
     * 
     * Expected Output: >ZW DATA DATA="-1^DUZ not found"
     */
    @Test
    public void testGetMailBoxInfoWithBadDUZ() throws Exception {
	String expectedOutput = "-1^DUZ not found";

	request.setDuz("2");
	request.setXmDuz("2");

	LOGGER.debug(request);

	XMXAPIBQMBoxResponse response = service.qMBox(request);

	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
