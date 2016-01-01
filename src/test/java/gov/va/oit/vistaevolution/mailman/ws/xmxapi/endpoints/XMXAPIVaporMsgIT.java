package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVaporMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XMXAPIVaporMsgIT extends EvolutionIT<XMXAPIVaporMsgEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIVaporMsgIT.class);

    private XMXAPIVaporMsgRequest request;
    private XMDEndpoint service2;
    private String newMailMessageIEN;

    @Override
    protected Class<XMXAPIVaporMsgEndpoint> getType() {
	return XMXAPIVaporMsgEndpoint.class;
    }

    @Before
    public void setUp() {
	newMailMessageIEN = sendMessage();

	request = new XMXAPIVaporMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".6");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(newMailMessageIEN,
		"")));
	request.setXmVpDate("3140418.1320");
    }

    public String sendMessage() {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    LOGGER.info("XMXUtil2ZReadIT new ien = " + this.newMailMessageIEN);
	    return MailUtils.createMailMessage(service2, null, null, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    /**
     * create and set message to Vaporinate
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC Vapor",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286049
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC Vapor",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286050
     * 
     * >S ARR(286049)=""
     * 
     * Procedure Call: >D VAPRMSGM^XMWSOA08(.RESULT,.5,.5,.ARR,3140318.1320)
     * 
     * Expected Output: >ZW RESULT RESULT="0^1 message vaporize date set."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    @Ignore
    public void testSetMessageVaporizationDate() throws VistaWebServiceFault {
	sendMessage();
	String expectedOutput = "0^1 message vaporize date set.";
	LOGGER.debug(request);

	XMXAPIVaporMsgResponse response = service.vaporMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	// assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }

    /**
     * create and try to Vaporinate a range of messages
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC Vapor",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286051
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC Vapor",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286052
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC Vapor",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286053
     * 
     * >S ARR("286051-286053")=""
     * 
     * Procedure Call: >D VAPRMSGM^XMWSOA08(.RESULT,.5,.5,.ARR,3140318.1325)
     * 
     * Expected Output: >ZW RESULT
     * RESULT="-1^XMZ message ranges are not allowed."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    @Ignore
    public void testSetMessageRangeVaporizationDate()
	    throws VistaWebServiceFault {

	String expectedOutput = "-1^XMZ message ranges are not allowed.";

	request.setXmkza(Arrays
		.asList(new XMXAPIArrayEntry("286051-286053", "")));
	LOGGER.debug(request);

	XMXAPIVaporMsgResponse response = service.vaporMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * create and terminate messages
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286051
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286052
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=286053
     * 
     * > S ARR(286051)="",ARR(286053)=""
     * 
     * Procedure Call: >D VAPRMSGM^XMWSOA08(.RESULT,.5,.5,.ARR,3140318.1325)
     * 
     * Expected Output: >ZW RESULT RESULT="0^2 messages vaporize date set."
     */
    @Test
    @Ignore
    public void testSetVaporizationDateForMultipleMesages() throws Exception {
	String secondMessageID = sendMessage();
	String expectedOutput = "0^2 messages vaporize date set.";
	request.setXmkza(Arrays.asList(request.getXmkza().get(0),
		new XMXAPIArrayEntry(secondMessageID, "")));

	LOGGER.debug(request);

	XMXAPIVaporMsgResponse response = service.vaporMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	// assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }
}
