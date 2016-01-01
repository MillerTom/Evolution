package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBQBsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQBsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBQBsktTest extends VistaLinkContextTestParent {

    private XMXAPIBQBsktRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIBQBsktRequest();
	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmk(".5");
    }

    /**
     * Successful call
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=.5,XMK=.5
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN=".5^WASTE^0^0"
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfo() throws Exception {

	String expectedOutput = ".5^WASTE^0^0";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBQBsktEndpoint service = new XMXAPIBQBsktEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBQBsktResponse response = service.qBskt(request);

	assertEquals(expectedOutput.split("\\^")[0], response.getIen());
	assertEquals(expectedOutput.split("\\^")[1], response.getName());
	assertEquals(expectedOutput.split("\\^")[2], response.getNumOfMsgs());
	assertEquals(expectedOutput.split("\\^")[3], response.getNumOfNewMsgs());
    }

    /**
     * <em>Missing DUZ</em>
     * 
     * Input Data: >S U="^",RETURN="",DUZ=””,XMDUZ=.5,XMK=.5
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     * 
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfoWithEmptyDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIBQBsktEndpoint service = new XMXAPIBQBsktEndpointImpl(
		getVistaLinkContext(), new XMXAPIBResponseFactory());

	XMXAPIBQBsktResponse response = service.qBskt(request);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
