package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIVaporMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVaporMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIVaporMsgTest extends VistaLinkContextTestParent {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIVaporMsgTest.class);

    private XMXAPIVaporMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIVaporMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".6");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("285893", "")));
	request.setXmVpDate("3140318.1320");
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
    public void testSetMessageVaporizationDate() throws VistaWebServiceFault {

	String expectedOutput = "0^1 message vaporize date set.";
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIVaporMsgEndpoint service = new XMXAPIVaporMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());
	XMXAPIVaporMsgResponse response = service.vaporMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
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
    public void testSetMessageRangeVaporizationDate()
	    throws VistaWebServiceFault {

	String expectedOutput = "-1^XMZ message ranges are not allowed.";
	request.setXmkza(Arrays
		.asList(new XMXAPIArrayEntry("286051-286053", "")));

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIVaporMsgEndpoint service = new XMXAPIVaporMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());
	XMXAPIVaporMsgResponse response = service.vaporMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
