package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4NameEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NameEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4NameTest extends VistaLinkContextTestParent {

    public XUAF4NameTest() {
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
     * >S DATA=$$Name^XUAF4(IEN)
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
	String testResponse = "BAY PINES VA HCS";

	XUAF4NameRequest request = new XUAF4NameRequest("516");

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(testResponse);

	// set up endpoint for testing
	XUAF4NameEndpoint service = new XUAF4NameEndpointImpl(
		new XUAF4ResponseFactory(), getVistaLinkContext());

	XUAF4NameResponse response = service.name(request);

	assertNotNull(response);
	assertEquals(testResponse, response.getInstitutionName());

    }

}
