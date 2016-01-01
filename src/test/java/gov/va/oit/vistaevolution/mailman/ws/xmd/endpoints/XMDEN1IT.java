/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMDEN1IT extends EvolutionIT<XMDEN1Endpoint> {
    private ArrayList<String> message = null;

    private static final Logger LOGGER = Logger.getLogger(XMDEN1IT.class);

    @Before
    public void setUp() {
	message = new ArrayList<String>();
	message.add("Hello Dr. House");
	message.add("");
	message.add("This is a test to check if your e-mail is working.");
	message.add("Good bye.");

    }

    @After
    public void tearDown() {
	message = null;
    }

    @Override
    protected Class<XMDEN1Endpoint> getType() {
	return XMDEN1Endpoint.class;
    }

    /**
     * 
     * <em>Call the VistALink procedure with a short 2 character subject:</em>
     * 
     * <pre>
     * >S U=”^”,DUZ=1,XMY(“983”),XMSUB=”Ab”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to check if your e-mail is working.”
     * >S MSG(4)=”Good bye.”
     * 
     * >D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * >ZW DATA
     * DATA="-1^SUBJECT must be at least 3 characters long.^Ab"
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testShortSubjectSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1", message, XMY, "Ab");
	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);
	assertEquals("SUBJECT must be at least 3 characters long.", response
		.getErrors().get(0));

    }

    /**
     * 
     * <em>This is an example sending a message to one user from the user passed in the “DUZ” variable:</em>
     * 
     * <pre>
     * >S U=”^”,DUZ=1,XMY(“983”),XMSUB=”Ab”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to check if your e-mail is working.”
     * >S MSG(4)=”Good bye.”
     * 
     * >D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * >ZW DATA
     * DATA="0^Successful"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSuccessfulSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1", message, XMY,
		"This is a test message");

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("Successful", response.getResponse());
    }

    /**
     * <em>Call the VistALink procedure with a long 66 character subject:</em>
     * 
     * <pre>
     * >S U=”^”,DUZ=1,XMY(“983”),XMSUB=”AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABC”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to check if your e-mail is working.”
     * >S MSG(4)=”Good bye.”
     * 
     * >D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * >ZW DATA
     * DATA="0^Successful"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testLongSubjectSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1", message, XMY,
		"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABC");

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);
	assertEquals("Entered SUBJECT too long, 1 characters longer than 65.",
		response.getErrors().get(0));

    }

    /**
     * <em>Call the VistALink procedure with a subject that contains control characters:</em>
     * 
     * <pre>
     * Input Data:
     * > S U=”^”,DUZ=1,XMY(“983”)=””,XMSUB=”Control Test”_$C(22)_$C(23)
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=   ”  
     * >S MSG(3)=”This is a test to check if control characters get through.”
     * >S MSG(4)=”Good bye.”
     * 
     * 
     * Procedure Call:
     * 
     * > D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Subject cannot contain control characters.^Control Test"
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    @Ignore
    public void testBadCharsInSubjectSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1", message, XMY,
		"Control Test" + (char) 0x0127 + (char) 0x0128);

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("Subject cannot contain control characters.", response
		.getErrors().get(0));

    }

    /**
     * <em>Call the VistALink procedure with a subject that is the reserved format of Rnnn:</em>
     * 
     * <pre>
     * Input Data:
     * > S U=”^”,DUZ=1,XMY(“983”)=””,XMSUB=”R456”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to check if a subject of R456 will get through.”
     * >S MSG(4)=”Good bye.”
     * 
     * 
     * Procedure Call:
     * 
     * > D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Subject names of this format (1"R"1.N) are RESERVED^R456"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReservedSubjectSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1", message, XMY, "R456");
	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("Subject names of this format (1\"R\"1.N) are RESERVED",
		response.getErrors().get(0));

    }

    /**
     * <em>Call the VistALink procedure with a DUZ that does not exist on the system:</em>
     * 
     * <pre>
     * Input Data:
     * >S U=”^”,DUZ=53467,XMY(“983”)=””,XMSUB=”No such sender test”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to see if a non-existent user can send an e-mail.”
     * >S MSG(4)=”Good bye.”
     * 
     * 
     * Procedure Call:
     * 
     * > D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^DUZ not found"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testInvalidDUZSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("53467", message, XMY,
		"No such sender test");

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("DUZ not found", response.getErrors().get(0));

    }

    /**
     * <em>Call the VistALink procedure with a DUZ that is not active. The user appears to be able to send e-mail:</em>
     * 
     * <pre>
     * Input Data:
     * >S U=”^”,DUZ=1000,XMY(“983”)=””,XMSUB=”Non-active sender test”
     * >S MSG(1)=”Hello Dr. House”
     * >S MSG(2)=””
     * >S MSG(3)=”This is a test to see if a non-active user can send an e-mail.”
     * >S MSG(4)=”Good bye.”
     * 
     * 
     * Procedure Call:
     * 
     * > D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0^Successful"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testInactiveDUZSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));

	XMDEN1Request request = new XMDEN1Request("1000", message, XMY,
		"Non-active sender test");

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("Successful", response.getResponse());

    }

    /**
     * <em>Call the VistALink procedure with multiple recipients in XMY, it returns successful but only sends to the canonically first user in the array:</em>
     * 
     * <pre>
     * Input Data:
     * >S U=”^”,DUZ=1,XMY(“983”)=””, XMY(“987”)=””
     * >S XMSUB=”Multiple to recipients test”
     * >S MSG(1)=”Hello Dr. House, Dr. Howser”
     * >S MSG(2)=””
     * >S MSG(3)="This is a test to see two users can be sent the message.
     * >S MSG(4)=”Good bye.”
     * 
     * 
     * Procedure Call:
     * 
     * > D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0^Successful"
     * 
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testMultipleRecipientsDUZSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("983", ""));
	XMY.add(new XMYEntry("987", ""));

	XMDEN1Request request = new XMDEN1Request("1000", message, XMY,
		"Multiple to recipients test");

	LOGGER.debug(request);
	XMDResponse response = service.en1(request);
	LOGGER.debug(response);

	assertEquals("Successful", response.getResponse());

    }

}
