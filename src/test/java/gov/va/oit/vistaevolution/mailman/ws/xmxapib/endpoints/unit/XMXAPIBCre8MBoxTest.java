package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBCre8MBoxEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8MBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBCre8MBoxTest extends VistaLinkContextTestParent {

    private XMXAPIBCre8MBoxRequest request;

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

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBCre8MBoxEndpoint service = new XMXAPIBCre8MBoxEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);

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

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBCre8MBoxEndpoint service = new XMXAPIBCre8MBoxEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBCre8MBoxResponse response = service.cr8MBox(request);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
