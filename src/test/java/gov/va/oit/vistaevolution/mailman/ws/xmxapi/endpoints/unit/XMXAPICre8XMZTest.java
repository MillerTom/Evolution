package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPICre8XMZEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPICre8XMZEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXAPICre8XMZTest extends VistaLinkContextTestParent {

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
    public void testCreateMessageSubWithSubject() throws VistaWebServiceFault {

	String expectedOutput = "283527";

	XMXAPICre8XMZRequest request = new XMXAPICre8XMZRequest();
	request.setXmSubj("ZZEVO Test Subject CRE8XMZ");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPICre8XMZEndpoint service = new XMXAPICre8XMZEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPICre8XMZResponse response = service.cre8Xmz(request);

	assertEquals(expectedOutput, response.getMessageNumber());

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
    public void testCreateMessageNameWithShortSubject() throws Exception {
	String expectedOutput = "-1^Subject must be from 3 to 65 characters long.";

	XMXAPICre8XMZRequest request = new XMXAPICre8XMZRequest();
	request.setXmSubj("AA");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPICre8XMZEndpoint service = new XMXAPICre8XMZEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPICre8XMZResponse response = service.cre8Xmz(request);

	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
