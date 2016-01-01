package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NameEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

public class XUAF4NameIT extends EvolutionIT<XUAF4NameEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XUAF4NameIT.class);

    @Override
    protected Class<XUAF4NameEndpoint> getType() {
	return XUAF4NameEndpoint.class;
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
	String expectedResult = "BAY PINES VAMC";
	String ien = "516";
	submitAndTestRequest(expectedResult, ien);

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
     * > D NAMER^XUSOAR(.RETURN IEN)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN=””
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveForEmptyIEN() throws VistaWebServiceFault {
	String expectedResult = "";
	String ien = "";
	submitAndTestRequest(expectedResult, ien);
    }

    /**
     * <em>Retrieve name for non-existent IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=201
     * 
     * Procedure Call:
     * 
     * > D NAMER^XUSOAR(.RETURN IEN)
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
    public void testRetrieveForBadIEN() throws VistaWebServiceFault {
	String expectedResult = "";
	String ien = "201";
	submitAndTestRequest(expectedResult, ien);
    }

    /**
     * <em>Retrieve name for a non-numeric IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,IEN=”AA”
     * 
     * Procedure Call:
     * 
     * > D NAMER^XUSOAR(.RETURN IEN)
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
    public void testRetrieveForNonNumericIEN() throws VistaWebServiceFault {
	String expectedResult = "";
	String ien = "AA";
	submitAndTestRequest(expectedResult, ien);
    }

    public void submitAndTestRequest(String expectedResult, String ien) {
	XUAF4NameRequest request = new XUAF4NameRequest(ien);
	LOGGER.debug(request);

	XUAF4NameResponse response = service.name(request);
	LOGGER.debug(response);

	assertEquals(expectedResult, response.getInstitutionName());
    }
}
