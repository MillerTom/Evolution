package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

public class XUAF4NNTIT extends EvolutionIT<XUAF4NNTEndpoint> {
    private static final Logger LOGGER = Logger.getLogger(XUAF4NNTIT.class);

    @Override
    protected Class<XUAF4NNTEndpoint> getType() {
	return XUAF4NNTEndpoint.class;
    }

    public XUAF4NNTIT() {
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
	String expectedResult = "BAY PINES VAMC^516^VAMC";

	XUAF4NNTRequest request = new XUAF4NNTRequest("516");
	LOGGER.debug(request);

	XUAF4NNTResponse response = service.NNT(request);
	LOGGER.debug(response);

	String[] splitTestResponse = expectedResult.split("\\^");
	assertEquals(splitTestResponse[0], response.getInstitutionName());
	assertEquals(splitTestResponse[1], response.getSiteNumber());
	assertEquals(splitTestResponse[2], response.getInstitutionType());

    }

    /**
     * <em>Retrieve empty string for IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=””
     * 
     * Procedure Call:
     * 
     * >D NNTR^XUSOAR(.RETURN,IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveWithEmptyIEN() throws VistaWebServiceFault {
	XUAF4NNTRequest request = new XUAF4NNTRequest("");
	LOGGER.debug(request);

	XUAF4NNTResponse response = service.NNT(request);
	LOGGER.debug(response);

	assertEquals(null, response.getInstitutionName());

    }

    /**
     * <em>Retrieve data for non-existent IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=201
     * 
     * Procedure Call:
     * 
     * >S DATA=$$NNT^XUAF4(IEN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="^^"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveWithBadIEN() throws VistaWebServiceFault {

	XUAF4NNTRequest request = new XUAF4NNTRequest("201");
	LOGGER.debug(request);

	XUAF4NNTResponse response = service.NNT(request);
	LOGGER.debug(response);

	assertEquals("", response.getInstitutionName());

    }

    /**
     * <em>Retrieve data for IEN without a site number</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=8075
     * 
     * Procedure Call:
     * 
     * >S DATA=$$NNT^XUAF4(IEN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="COLUMBIA SC PHARMACY^^PHARM"
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveIncompleteSiteData() throws VistaWebServiceFault {
	String testResponse = "CENTRAL PLAINS NETWORK (636)^^HCS";

	XUAF4NNTRequest request = new XUAF4NNTRequest("18900");

	XUAF4NNTResponse response = service.NNT(request);

	String[] splitTestResponse = testResponse.split("\\^");
	assertEquals(splitTestResponse[0], response.getInstitutionName());
	assertEquals(splitTestResponse[1], response.getSiteNumber());
	assertEquals(splitTestResponse[2], response.getInstitutionType());

    }

    /**
     * <em>Retrieve data for IEN with a non-numeric site number</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=18891
     * 
     * Procedure Call:
     * 
     * > D NNTR^XUSOAR(.RETURN,IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="BAXTER SPRINGS^897IU^SL"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveNonNumbericSite() throws VistaWebServiceFault {
	String expectedResult = "BAXTER SPRINGS^897IU^SL";

	XUAF4NNTRequest request = new XUAF4NNTRequest("18891");
	LOGGER.debug(request);

	XUAF4NNTResponse response = service.NNT(request);
	LOGGER.debug(response);

	String[] splitTestResponse = expectedResult.split("\\^");
	assertEquals(splitTestResponse[0], response.getInstitutionName());
	assertEquals(splitTestResponse[1], response.getSiteNumber());
	assertEquals(splitTestResponse[2], response.getInstitutionType());

    }

}
