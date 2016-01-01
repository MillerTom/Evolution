package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPITermMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITermMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPITermMsgTest extends VistaLinkContextTestParent {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPITermMsgTest.class);

    private XMXAPITermMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPITermMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".6");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("285893", "")));
    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285893
     * 
     * >S ARR(285893)=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT RESULT="0^1 message terminated."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testTerminateMessage() throws VistaWebServiceFault {

	String expectedOutput = "0^1 message terminated.";
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPITermMsgEndpoint service = new XMXAPITermMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285893
     * 
     * >S ARR=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT RESULT="-1^Error in required input"
     * 
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testTerminateMessageWithBadXMKZA() throws VistaWebServiceFault {

	String expectedOutput = "-1^Error in required input";
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("", "")));

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPITermMsgEndpoint service = new XMXAPITermMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
