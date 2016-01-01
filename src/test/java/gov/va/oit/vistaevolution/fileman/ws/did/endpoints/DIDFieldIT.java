/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFieldIT extends VistaLinkContextITParent {

	@Autowired
	private DIDFieldEndpoint fieldDIDEndpoint;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Retrieve LABEL Attribute from the .01 field and file 80.
	 * 
	 * >DO FIELD^DID(80,.01,"","LABEL","TEST") >ZW TEST
	 * TEST("LABEL")="CODE NUMBER"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	@Ignore
	public void testGetLabelAttributeForFieldInFile()
			throws VistaWebServiceFault {
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("LABEL");

		assertEquals(
				"CODE NUMBER",
				this.fieldDIDEndpoint
						.field(new DIDFieldRequest("80", ".01", attributes))
						.getDidAttributes().get(0).toString());
	}

	/**
	 * Retrive LABEL, TYPE attributes from .01 field and file 80.
	 * 
	 * >DO FIELD^DID(80,.01,"","LABEL;SOURCE","TEST") >ZW TEST
	 * TEST("LABEL")="CODE NUMBER" TEST("SOURCE")=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testGetMultipleLabelsForFieldInFile()
			throws VistaWebServiceFault {
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("LABEL");
		attributes.add("SOURCE");

		DIDFieldResponse response = this.fieldDIDEndpoint
				.field(new DIDFieldRequest("80", ".01", attributes));

		assertEquals("CODE NUMBER", response.getDidAttributes().get(0)
				.toString());
	}

	/**
	 * In this test case, the file # is an invalid nagtive -80. After running
	 * the FIELD^DID() procedure the error will be catched in the msg_root array
	 * “ERROR”. And show the error code 202 is the value of error array.
	 * 
	 * >DO FIELD^DID(-80,.01,"","AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=202
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "The input parameter that identifies the FILE is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testInvalidFile202Error1() throws VistaWebServiceFault {
		// TODO Should we really be throwing a VistaWebServiceFault since there
		// is no data as a result of invalid input....
		fail();
	}

	/**
	 * In this test case, the file # is mssing. After running the FIELD^DID()
	 * procedure the error will be catched in the array “ERROR”. And show the
	 * error code 202.
	 * 
	 * >DO FIELD^DID(“ ”,.01,"","AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=202
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "The input parameter that identifies the FILE is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test @Ignore
	public void testMissingFile202Error() throws VistaWebServiceFault {
		// TODO Is this a valid test, since we can specify if a field is
		// required or not in the XSD for the request obejct.
		fail();
	}

	/**
	 * In this test case, the file # is an ivalid number 8907666. After running
	 * the FIELD^DID() procedure the error will be catched in the array “ERROR”.
	 * And show the error code 202.
	 * 
	 * >DO FIELD^DID(8907666,.01,"","AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=202
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "The input parameter that identifies the FILE is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testInvalidFile202Error2() throws VistaWebServiceFault {
		// TODO Should we really be throwing a VistaWebServiceFault since there
		// is no data as a result of invalid input....
		fail();
	}

	/**
	 * In this test case, the file # is 80 and the field “-.01” is invalid.
	 * After running the FIELD^DID() procedur error will be catched in the array
	 * “ERROR”. And show the error code 200.
	 * 
	 * >DO FIELD^DID(80,"-.01","","AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=200
	 * ERROR("DIERR"
	 * ,1,"TEXT",1)="An input variable or parameter is missing or invalid."
	 * ERROR("DIERR","E",200,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testInvalidField200Error() throws VistaWebServiceFault {
		// TODO Should we really be throwing a VistaWebServiceFault since there
		// is no data as a result of invalid input....
		fail();
	}

	/**
	 * In this test case, the file # is 80 and the field paramenter is missing.
	 * After running the FIELD^DID() procedur error will be catched in the array
	 * “ERROR”. And show the error code 202.
	 * 
	 * >DO FIELD^DID(80,"","","AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=202
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "The input parameter that identifies the FIELD is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testMissingField202Error() throws VistaWebServiceFault {
		// TODO Again, the field is specified as required, so this test is
		// invalid.?
		fail();
	}

	/**
	 * In this test case, the file # is 80 and the field .01. And the attributes
	 * list "  AUDIT;FIELD LENGTH;TITLE" contains an empty space at begining.
	 * After running the FIELD^DID() procedur error will be catched in the
	 * “ERROR” array. And show the error code 200.
	 * 
	 * >DO FIELD^DID(80,.01,""," AUDIT;FIELD LENGTH;TITLE","OUDATA","ERROR")
	 * Output Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=200
	 * ERROR("DIERR"
	 * ,1,"TEXT",1)="An input variable or parameter is missing or invalid."
	 * ERROR("DIERR","E",200,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */

	@Test @Ignore
	public void testBadAttributeList200Error() throws VistaWebServiceFault {
		// TODO This is impossible to simulate because of the way we define the
		// request.
		fail();
	}

	/**
	 * In this test case, the file # is 80 and the field #.01. And the
	 * attributes “My Field” is invalid. After running the FIELD^DID() procedur
	 * error will be catched in the “ERROR” array. And show the error code 200.
	 * 
	 * >DO FIELD^DID(80,.01,"","My Field","OUDATA","ERROR") Output Error >ZW
	 * ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=200
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "An input variable or parameter is missing or invalid."
	 * ERROR("DIERR","E",200,1)="" *
	 */
	@Test @Ignore
	public void testInvalidAttribute200Error() {
		// TODO This is impossible to simulate because of the way we define the
		// request.
		fail();
	}

	/**
	 * In this test case, the file # is 80 and the field #.01. And the
	 * target_root is missing . After running the FIELD^DID() procedur error
	 * will be catched in the “ERROR” array. And show the error code 202.
	 * 
	 * >DO FIELD^DID(80,.01,"","AUDIT;FIELD LENGTH;TITLE","","ERROR") Output
	 * Error >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=202
	 * ERROR("DIERR",1,"TEXT",1)=
	 * "The input parameter that identifies the TARGET ARRAY is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 */
	@Test @Ignore
	public void testNoTargetRoot202Error() {
		// Thus far we wont be required to specify a target root through the
		// true RPC
		fail();
	}

}
