package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4NNTEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4NNTTest extends VistaLinkContextTestParent {

    public XUAF4NNTTest() {
	super();
    }

    /**
     * <em>Retrieve site information for specified IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=516
     * 
     * Procedure Call:
     * >S DATA=$$NNT^XUAF4(IEN)
     * 
     * Expected Output:
     * >ZW DATA
     * DATA="BAY PINES VA HCS^516^VAMC"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveWithIEN() throws VistaWebServiceFault {
	String testResponse = "BAY PINES VA HCS^516^VAMC";

	XUAF4NNTRequest request = new XUAF4NNTRequest("516");

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(
			new RPCIdentifier("EVOLUTION", ""), null)).thenReturn(
		testResponse);

	// set up endpoint for testing
	XUAF4NNTEndpoint service = new XUAF4NNTEndpointImpl(
		new XUAF4ResponseFactory(), getVistaLinkContext());

	XUAF4NNTResponse response = service.NNT(request);

	assertEquals("BAY PINES VA HCS", response.getInstitutionName());
    }

    @Test
    public void testRetrieveWithBadIEN() throws VistaWebServiceFault {
	String testResponse = "^^";

	XUAF4NNTRequest request = new XUAF4NNTRequest("AAA");

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(
			new RPCIdentifier("EVOLUTION", ""), null)).thenReturn(
		testResponse);

	// set up endpoint for testing
	XUAF4NNTEndpoint service = new XUAF4NNTEndpointImpl(
		new XUAF4ResponseFactory(), getVistaLinkContext());
	XUAF4NNTResponse response = service.NNT(request);

	assertEquals("", response.getInstitutionName());
    }

}
