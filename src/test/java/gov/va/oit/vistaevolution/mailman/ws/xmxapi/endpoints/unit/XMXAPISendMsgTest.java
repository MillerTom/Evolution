package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPISendMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class XMXAPISendMsgTest extends VistaLinkContextTestParent {

    private XMXAPISendMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPISendMsgRequest();

	List<String> msg = new LinkedList<String>();
	msg.add("TEST 1");
	msg.add("TEST 2");

	List<XMXAPIArrayEntry> xmTo = new LinkedList<XMXAPIArrayEntry>();
	xmTo.add(new XMXAPIArrayEntry(".6", ""));

	List<XMXAPIArrayEntry> xmInstr = new LinkedList<XMXAPIArrayEntry>();

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmSubj("TEST");
	request.setMsg(msg);
	request.setXmTo(xmTo);
	request.setXmInstr(xmInstr);
    }

    /**
     * <em>Normal successful message</em>
     * 
     * <pre>
     * Input Data:
     * > S DUZ=.5
     * > S XMDUZ=.5
     * > S XMSUBJ="TEST"
     * > S MSG(1)="TEST 1"
     * > S MSG(2)="TEST 2"
     * > S XMTO(.6)=""
     * > S XMINSTR=""
     * > S U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN=55758
     * </pre>
     */
    @Test
    public void testSendMessageSuccessfully() throws VistaWebServiceFault {

	String expectedOutput = "55758";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPISendMsgEndpoint service = new XMXAPISendMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPISendMsgResponse response = service.sendMsg(request);

	assertEquals(expectedOutput, response.getXmz());

    }

    /**
     * <em> DUZ not found</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=9999999,XMDUZ=.5,XMSUBJ="TEST",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^DUZ not found"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithBadDUZ() throws Exception {
	String expectedOutput = "-1^DUZ not found";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPISendMsgEndpoint service = new XMXAPISendMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPISendMsgResponse response = service.sendMsg(request);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
