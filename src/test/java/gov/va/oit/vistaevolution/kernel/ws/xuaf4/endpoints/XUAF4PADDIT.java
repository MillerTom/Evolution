package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDResponse;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

public class XUAF4PADDIT extends EvolutionIT<XUAF4PADDEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XUAF4PADDIT.class);

    @Override
    protected Class<XUAF4PADDEndpoint> getType() {
	return XUAF4PADDEndpoint.class;
    }

    /**
     * <em>Retrieve site address for specified IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=516
     * 
     * Procedure Call:
     * 
     * >S DATA=$$PADD^XUAF4(IEN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="10000 BAY PINES BLVD^ST PETERSBURG^FL^33744"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveAddressForIEN() throws VistaWebServiceFault {
	String expectedResult = "VA MEDICAL CENTER^ALBANY^NY^12180-0097";

	String ien = "500";

	submitRequest(expectedResult, ien);

    }

    /**
     * <em>Retrieve site address for IEN equal to the empty string</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=””
     * 
     * Procedure Call:
     * 
     * > D PADDR^XUSOAR(.RETURN,IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveWithEmptyIEN() throws VistaWebServiceFault {

	String expectedResult = "";
	String ien = "";
	submitRequest(expectedResult, ien);

    }

    /**
     * <em>Retrieve site address for non-existent IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=201
     * 
     * Procedure Call:
     * 
     * > D PADDR^XUSOAR(.RETURN,IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN=""
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveWithBadEN() throws VistaWebServiceFault {
	String expectedResult = "";
	String ien = "201";
	submitRequest(expectedResult, ien);
    }

    /**
     * <em>Retrieve site address where complete information not available for given IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=17002
     * 
     * Procedure Call:
     * 
     * > D PADDR^XUSOAR(.RETURN,IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testRetrieveIncompleteAddress() throws Exception {
	String expectedResult = "^BAYONNE^NJ^";
	String ien = "17002";
	submitRequest(expectedResult, ien);
    }

    public void submitRequest(String expectedResult, String ien) {
	XUAF4PADDRequest request = new XUAF4PADDRequest(ien);
	LOGGER.debug(request);

	XUAF4PADDResponse response = service.PADD(request);
	LOGGER.debug(response);

	if (StrUtils.hasNoValue(expectedResult)) {
	    assertEquals("", response.getStreetAddress());
	    assertEquals("", response.getCity());
	    assertEquals("", response.getState());
	    assertEquals("", response.getZipCode());
	} else {

	    String[] splitTestResponse = expectedResult.split("\\^");

	    if (splitTestResponse.length > 0) {
		assertEquals(splitTestResponse[0], response.getStreetAddress());
	    }

	    if (splitTestResponse.length > 1) {
		assertEquals(splitTestResponse[1], response.getCity());
	    }

	    if (splitTestResponse.length > 2) {
		assertEquals(splitTestResponse[2], response.getState());
	    }

	    if (splitTestResponse.length > 3) {
		assertEquals(splitTestResponse[3], response.getZipCode());
	    }
	}
    }
}
