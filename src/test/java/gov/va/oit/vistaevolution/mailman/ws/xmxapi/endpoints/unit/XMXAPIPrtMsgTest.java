package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIPrtMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPrtMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIPrtMsgTest extends VistaLinkContextTestParent {

    private XMXAPIPrtMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIPrtMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("", "")));
	request.setXmPrtTo("NLA0");
    }

    /**
     * <em>Send a single message to the printer</em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=.5,XMKZA=468949,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="1 message sent to printer.^402”
     * 
     * </pre>
     */
    @Test
    public void testSendMessageToPrinter() throws VistaWebServiceFault {

	String expectedOutput = "1 message sent to printer.^402";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIPrtMsgEndpoint service = new XMXAPIPrtMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPIPrtMsgResponse response = service.prtMsg(request);

	assertNotNull(expectedOutput.split("\\^")[0], response.getStatus());
	assertNotNull(expectedOutput.split("\\^")[1], response.getTaskNumber());
    }

    /**
     * <em> API sending back an error message</em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=.5,XMKZA=99999999,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="-1^Message ‘99999999’ does not exist."
     * </pre>
     */
    @Test
    public void testSendMessageToPrinterWithBadXMKZA()
	    throws VistaWebServiceFault {

	String expectedOutput = "-1^Message ‘99999999’ does not exist.";

	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("99999999", "")));

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIPrtMsgEndpoint service = new XMXAPIPrtMsgEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPIPrtMsgResponse response = service.prtMsg(request);

	assertNotNull(expectedOutput.split("\\^")[0], response.getStatus());
	assertNotNull(expectedOutput.split("\\^")[1],
		response.getErrors().get(0));
    }
}
