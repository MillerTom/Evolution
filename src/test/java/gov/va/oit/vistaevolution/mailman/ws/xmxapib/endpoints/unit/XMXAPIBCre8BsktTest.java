package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBCre8BsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBCre8BsktTest extends VistaLinkContextTestParent {

    private XMXAPIBCre8BsktRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIBCre8BsktRequest();
	request.setDuz("1");
	request.setXmDuz("1");
	request.setXmkn("ZZ_NEWBASKET");
    }

    /**
     * <em>Retrieve create a basket for a user</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=1,XMKN=”ZZ_NEWBASKET”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0^6"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testCreateBasketForUser() throws Exception {

	String expectedOutput = "0^6";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBCre8BsktEndpoint service = new XMXAPIBCre8BsktEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBCre8BsktResponse response = service.cre8Bskt(request);

	assertEquals("6", response.getIen());
    }

    /**
     * <em>Attempt to create a basket for a user where the logged in user does not have surrogate abilities.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=.5,XMDUZ=1,XMKN=”ZZ_NEWBASKET_2”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^You are not authorized to be a surrogate of DUZ 1."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testCreateBasketWithNoSurrogateAbilities() throws Exception {

	String expectedOutput = "-1^You are not authorized to be a surrogate of DUZ 1.";

	request.setDuz(".5");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBCre8BsktEndpoint service = new XMXAPIBCre8BsktEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBCre8BsktResponse response = service.cre8Bskt(request);

	assertEquals("You are not authorized to be a surrogate of DUZ 1.",
		response.getErrors().get(0));
    }

}
