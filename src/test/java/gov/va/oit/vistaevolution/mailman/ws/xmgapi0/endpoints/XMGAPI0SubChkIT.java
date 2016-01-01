package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMGAPI0SubChkIT extends EvolutionIT<XMGAPI0SubChkEndpoint> {
    private static final Logger LOGGER = Logger
	    .getLogger(XMGAPI0SubChkIT.class);

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
     */
    @Override
    protected Class<XMGAPI0SubChkEndpoint> getType() {
	return XMGAPI0SubChkEndpoint.class;
    }

    /**
     * This function executions a known successful request and asserts on the
     * validity of the results.
     * 
     * @param request
     */
    public void testSuccessfulRequest(XMGAPI0SubChkRequest request) {
	XMGAPI0SubChkResponse response = submitRequestAndLog(request);
	assertNotNull(response.getResults());
	assertEquals("0", response.getStatus());
    }

    /**
     * This function executions a known successful request and asserts on the
     * validity of the results.
     * 
     * @param request
     */
    public void testSuccessfulCorrectionRequest(XMGAPI0SubChkRequest request,
	    String expectedResult) {
	XMGAPI0SubChkResponse response = submitRequestAndLog(request);
	assertNotNull(response.getResults());
	assertEquals(expectedResult, response.getResults().getValue());
    }

    /**
     * This function executions a known successful request and asserts on the
     * validity of the results.
     * 
     * @param request
     */
    public void testFailingRequest(XMGAPI0SubChkRequest request) {
	XMGAPI0SubChkResponse response = submitRequestAndLog(request);
	assertNotNull(response.getErrors());
	assertEquals("-1", response.getStatus());
    }

    /**
     * 
     * @param request
     * @return
     */
    public XMGAPI0SubChkResponse submitRequestAndLog(
	    XMGAPI0SubChkRequest request) {
	LOGGER.debug(request);
	XMGAPI0SubChkResponse response = service.subChk(request);
	LOGGER.debug(response);
	return response;
    }

    /**
     * 
     * <em>Test case with a successful return.</em>
     * 
     * <pre>
     * >S U="^" Input >S MSG="This is my subject of message!!"
     * 
     * Function call >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output >ZW OUTPUT OUTPUT="0^Successful"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     * 
     */
    @Test
    public void testGoodMessageSubject() throws VistaWebServiceFault {
	// Execute request against mocked object backend.
	XMGAPI0SubChkRequest request = new XMGAPI0SubChkRequest(
		"This is my subject of message!!");

	testSuccessfulRequest(request);
    }

    /**
     * 
     * <em> Test case, the subject of message MSG contains exactly 66 characters.</em>
     * 
     * <pre>
     * >S U="^" Input >S $P(MSG,”A”,66)=”B”
     * 
     * Function call >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output >ZW OUTPUT
     * OUTPUT="-1^Entered SUBJECT too long, 1 characters longer than 65."
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testLongMessageSubject() throws VistaWebServiceFault {
	XMGAPI0SubChkRequest request = new XMGAPI0SubChkRequest(
		"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

	testFailingRequest(request);
    }

    /**
     * <em> Test case, the subject of message MSG contains leading spaces. The returned data is a “corrected” message first piece is empty and the second piece is the corrected message.</em>
     * 
     * <pre>
     * 
     * >S U="^"
     * Input  
     * >S MSG="   This is my subject of message!!"
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="^This is my subject of message!!"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testMessageSubjectWithLeadingSpaces()
	    throws VistaWebServiceFault {
	XMGAPI0SubChkRequest request = new XMGAPI0SubChkRequest(
		"   This is my subject of message!!");
	testSuccessfulCorrectionRequest(request,
		"This is my subject of message!!");

    }

    /**
     * <em>Test case, the subject of message MSG contains 2 characters.</em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S MSG="AB"
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="-1^SUBJECT must be at least 3 characters long."
     * </pre>
     */
    @Test
    public void testShortMessageSubject() throws VistaWebServiceFault {
	testFailingRequest(new XMGAPI0SubChkRequest("AB"));
    }

    /**
     * <em>Test case, the subject of message MSG contains control characters.</em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S MSG=$C(22)_$C(23)_"ABC"
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="-1^Subject cannot contain control characters."
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    @Ignore
    // TODO: This test should fail. Bug
    public void testMessageSubjectWithControlChars()
	    throws VistaWebServiceFault {
	StringWriter sw = new StringWriter();
	sw.append((char) 0x127);
	sw.append((char) 0x128);
	sw.append("ABC");
	testFailingRequest(new XMGAPI0SubChkRequest(sw.toString()));
    }

    
    /**
     * <em>Test case, the subject of message MSG contains trailing spaces. The returned data is a “corrected” message first piece is empty and the second piece is the corrected message.</em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S MSG="This is my subject of message!! "
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="^This is my subject of message!!"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testMessageSubjectWithTrailingSpaces()
	    throws VistaWebServiceFault {
	testSuccessfulCorrectionRequest(new XMGAPI0SubChkRequest(
		"This is my subject of message!!     "),
		"This is my subject of message!!");
    }

    /**
     * <em>Test case, the subject of message MSG starts with the letter “R” and then 2 or more digits. This is a reserved subject.</em>
     * 
     * <pre>
     * 
     * >S U="^"
     * Input  
     * >S MSG="R12"
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="-1^Subject names of this format (1""R""1.N) are RESERVED"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReservedMessageSubject() throws VistaWebServiceFault {
	testFailingRequest(new XMGAPI0SubChkRequest("R12"));
    }

    /**
     * <em> Test case, the subject of message MSG starts with the letter “R” and then 2 or more digits and followed by anything else is an acceptable subject.</em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S MSG="R23 Extra"
     *  
     * Function call 
     * >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
     * 
     * Output 
     * >ZW OUTPUT
     * OUTPUT="0^Successful"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testFakeReservedMessageSubject() throws VistaWebServiceFault {
	testSuccessfulRequest(new XMGAPI0SubChkRequest("R23 Extra"));
    }

}
