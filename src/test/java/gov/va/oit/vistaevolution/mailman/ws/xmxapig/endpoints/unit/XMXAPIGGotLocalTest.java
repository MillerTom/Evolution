package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGGotLocalEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGGotLocalEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Joshua.Zangari
 *
 */
public class XMXAPIGGotLocalTest extends VistaLinkContextTestParent {

    /**
     * <em>Determine if GROUP has local users</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,GROUP=”THIS IS A TEST”,XDAYS=””
     * 
     * Procedure Call:
     * 
     * >D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=1
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */

    @Test
    public void testWithValidGroupName() throws VistaWebServiceFault {
	String expectedResponse = "1";

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("THIS IS A TEST");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResponse);

	XMXAPIGGotLocalEndpoint service = new XMXAPIGGotLocalEndpointImpl(
		new XMXAPIGResponseFactory(), getVistaLinkContext());

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	assertEquals(expectedResponse, response.getContainsLocalMembers());

    }

    /**
     * <em>Output if group is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DT=3140204,GROUP=””,XDAYS=””
     * 
     * Procedure Call:
     * 
     * >D GOTLOCAL^XMWSOA01(.DATA,GROUP,XDAYS)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testWithEmptyGroupName() throws Exception {
	String expectedResponse = "-1^Error in required input";

	XMXAPIGGotLocalRequest request = new XMXAPIGGotLocalRequest();
	request.setGROUP("THIS IS A TEST");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResponse);

	XMXAPIGGotLocalEndpoint service = new XMXAPIGGotLocalEndpointImpl(
		new XMXAPIGResponseFactory(), getVistaLinkContext());

	XMXAPIGGotLocalResponse response = service.GotLocal(request);

	assertNotNull(response.getErrors());
    }
} 