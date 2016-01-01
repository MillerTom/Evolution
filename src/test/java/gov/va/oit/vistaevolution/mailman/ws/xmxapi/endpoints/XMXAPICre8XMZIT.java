package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPICre8XMZEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPICre8XMZIT extends EvolutionIT<XMXAPICre8XMZEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPICre8XMZIT.class);

    private XMXAPICre8XMZRequest request;

    @Override
    protected Class<XMXAPICre8XMZEndpoint> getType() {
	return XMXAPICre8XMZEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPICre8XMZRequest();
    }

    /**
     * <em>Create a message stub with the given subject.</em>
     * 
     * <pre>
     * Input Data:
     * >Set SUBJ=”ZZEVO Test Subject CRE8XMZ”
     * 
     * Procedure Call:
     * 
     * >D CRE8XMZ^XMWSOA08(.DATA,SUBJ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=283527
     * 
     * </pre>
     */
    @Test
    public void testCreateMessageStubWithSubject() throws VistaWebServiceFault {
	request.setXmSubj("ZZEVO Test Subject CRE8XMZ");
	LOGGER.debug(request);
	XMXAPICre8XMZResponse response = service.cre8Xmz(request);
	LOGGER.debug(response);
	assertNotNull(response.getMessageNumber());
    }

    /**
     * <em>Create a message stub with the given subject empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set SUBJ=””
     * 
     * Procedure Call:
     * 
     * >D CRE8XMZ^XMWSOA08(.DATA,SUBJ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=283530
     * </pre>
     */
    @Test
    public void testCreateMessageStubWithEmptySubject() throws Exception {
	request.setXmSubj("");
	LOGGER.debug(request);
	XMXAPICre8XMZResponse response = service.cre8Xmz(request);
	LOGGER.debug(response);
	assertNotNull(response.getMessageNumber());
    }

    /**
     * <em>Try to create a message stub with the given subject that is under 3 characters.</em>
     * 
     * <pre>
     * Input Data:
     * >Set SUBJ=”AA”
     * 
     * Procedure Call:
     * 
     * >D CRE8XMZ^XMWSOA08(.DATA,SUBJ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Subject must be from 3 to 65 characters long."
     * </pre>
     */
    @Test
    public void testCreateMessageStubWithShortSubject() throws Exception {
	String expectedOutput = "-1^Subject must be from 3 to 65 characters long.";

	request.setXmSubj("AA");

	LOGGER.debug(request);
	XMXAPICre8XMZResponse response = service.cre8Xmz(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * <em> Try to create a message stub with the given subject that is over 65 characters.</em>
     * 
     * <pre>
     * Input Data:
     * >Set SUBJ=””,$P(SUBJ,”B”,66)=”A”
     * 
     * Procedure Call:
     * 
     * >D CRE8XMZ^XMWSOA08(.DATA,SUBJ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Subject must be from 3 to 65 characters long."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testCreateMessageStubWithLongSubject() throws Exception {
	String expectedOutput = "-1^Subject must be from 3 to 65 characters long.";

	request.setXmSubj("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

	LOGGER.debug(request);
	XMXAPICre8XMZResponse response = service.cre8Xmz(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
