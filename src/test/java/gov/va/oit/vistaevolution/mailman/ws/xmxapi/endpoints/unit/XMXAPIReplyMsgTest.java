package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIReplyMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIReplyMsgTest extends VistaLinkContextTestParent {

    private XMXAPIReplyMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIReplyMsgRequest();

	List<String> msg = new LinkedList<String>();
	msg.add("TEST MESSAGE LINE 1e");
	msg.add("");
	msg.add("");
	msg.add("THE END");

	List<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("53467", ""));

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmkz("285884");
	request.setXmBody(msg);
    }

    /**
     * 
     * RPLYMSGM^XMWSOA03(RETURN,DUZ,XMDUZ,XMKZ,MSG,XMINSTR)
     * RPLYMSGS^XMWSOA03(RETURN,DUZ,XMDUZ,XMK,XMKZ,MSG,XMINSTR)
     * 
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285883
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.5,.5,RETURN,.RPLY)
     * 
     * Expected Output: >ZW RESULT RESULT=285884
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReplyToMessage() throws VistaWebServiceFault {
	String expectedOutput = "285884";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIReplyMsgEndpoint service = new XMXAPIReplyMsgEndpointImpl(
		getVistaLinkContext(), new XMXAPIResponseFactory());

	XMXAPIReplyMsgResponse response = service.replyMsg(request);

	assertNotNull(response);
	assertEquals(expectedOutput, response.getXmz());

    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285888
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.6,.6,RETURN,.RPLY)
     * 
     * Expected Output: >ZW RESULT
     * RESULT="-1^SHARED,MAIL may not Reply to a message."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReplyToMessageWithSharedMail() throws VistaWebServiceFault {
	String expectedOutput = "-1^SHARED,MAIL may not Reply to a message.";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIReplyMsgEndpoint service = new XMXAPIReplyMsgEndpointImpl(
		getVistaLinkContext(), new XMXAPIResponseFactory());

	XMXAPIReplyMsgResponse response = service.replyMsg(request);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));

    }
}
