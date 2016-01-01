package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBQMBoxEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQMBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBQMBoxTest extends VistaLinkContextTestParent {

    private XMXAPIBQMBoxRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIBQMBoxRequest();
	request.setDuz("1");
	request.setXmDuz("1");
    }

    /**
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

	String expectedOutput = "448^1^447^3140319.205724^0^447^1^IN";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBQMBoxEndpoint service = new XMXAPIBQMBoxEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBQMBoxResponse response = service.qMBox(request);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getNumOfNewMsgs());

	assertEquals(expectedOutput.split("\\^")[1],
		response.getNewPriorityMail());

	assertEquals(expectedOutput.split("\\^")[2],
		response.getNumOfNewMsgsForINBskt());

	assertEquals(expectedOutput.split("\\^")[3],
		response.getDateLastMsgRecieved());

	assertEquals(expectedOutput.split("\\^")[4],
		response.getNewMessagesSinceLastChecked());

	assertEquals(expectedOutput.split("\\^")[6], response.getBasketIen());

	assertEquals(expectedOutput.split("\\^")[7], response.getBasketName());
    }

    /**
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
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBQMBoxEndpoint service = new XMXAPIBQMBoxEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBQMBoxResponse response = service.qMBox(request);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
