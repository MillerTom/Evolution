/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test for File function of DID Webservice
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFileIT extends VistaLinkContextITParent {

	@Autowired
	private DIDFileEndpoint fileDIDEndpoint;

	/**
	 * Retrieve single attribute from the specified file
	 * 
	 * Input Data: >Set FILE=80,FLAGS=��,ATTRIBUTES=�GLOBAL NAME�
	 * 
	 * Procedure Call:
	 * 
	 * >D FILE^DID(FILE,FLAGS,ATTRIBUTES,"DATA","ERRORS")
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA DATA("GLOBAL NAME")="^ICD9("
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testGetSingleAttrFromFile() throws VistaWebServiceFault {
		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("GLOBAL NAME");
		DIDFileRequest request = new DIDFileRequest("80", attributes);

		// Execute request against mocked object backend.
		DIDFileResponse response = fileDIDEndpoint.file(request);

		assertNotNull(response);
		assertEquals("^ICD9(", response.getDidAttributes().get(0).toString());

		// Fail
		fail("This is a rough implemenation before knowing the details of the RPC for this API.");
	}

	/**
	 * Retrieve multiple attributes from the specified file
	 * 
	 * Input Data: >Set FILE=80,FLAGS=��,ATTRIBUTES=�GLOBAL
	 * NAME;DATE;DESCRIPTION�
	 * 
	 * Procedure Call:
	 * 
	 * >D FILE^DID(FILE,FLAGS,ATTRIBUTES,"DATA","ERRORS")
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA DATA("DATE")="" DATA("DESCRIPTION")="DATA(""DESCRIPTION"")"
	 * DATA("DESCRIPTION",1)="Contains all valid ICD diagnosis codes."
	 * DATA("DESCRIPTION",2)=" " DATA("DESCRIPTION",3)=
	 * "If an entry needs to be added, modified or deleted, a patch will be issued"
	 * DATA("DESCRIPTION",4)="containing the change.  "
	 * DATA("DESCRIPTION",5)=" " DATA("DESCRIPTION",6)=
	 * "This table file should not be edited in anyway by the site."
	 * DATA("GLOBAL NAME")="^ICD9("
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testGetMultipleAttrFromFile1() throws VistaWebServiceFault {
		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("GLOBAL NAME");
		attributes.add("DATE");
		attributes.add("DESCRIPTION");
		DIDFileRequest request = new DIDFileRequest("80", attributes);

		// Execute request against mocked object backend.
		DIDFileResponse response = fileDIDEndpoint.file(request);

		assertNotNull(response.getDidAttributes());
		assertNotNull(response.getDidAttributes().get(0));
		assertEquals("DESCRIPTION", response.getDidAttributes().get(0)
				.toString());
		assertEquals("Contains all valid ICD diagnosis codes.", response
				.getDidAttributes().get(1).toString());
		assertEquals(" ", response.getDidAttributes().get(2).toString());

		// Fail
		fail("This is a rough implemenation before knowing the details of the RPC for this API.");
	}

	/**
	 * Retrieve multiple attributes from the specified file
	 * 
	 * Input Data: >Set FILE=80,FLAGS=��,ATTRIBUTES=�NAME;REQUIRED
	 * IDENTIFIERS;VERSION�
	 * 
	 * Procedure Call:
	 * 
	 * >D FILE^DID(FILE,FLAGS,ATTRIBUTES,"DATA","ERRORS")
	 * 
	 * Expected Output: >ZW DATA DATA("NAME")="ICD DIAGNOSIS"
	 * DATA("REQUIRED IDENTIFIERS")="DATA(""REQUIRED IDENTIFIERS"")"
	 * DATA("REQUIRED IDENTIFIERS",1,"FIELD")=.01
	 * DATA("REQUIRED IDENTIFIERS",2,"FIELD")=3 DATA("VERSION")="18.0"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testGetMultipleAttrFromFile2() throws VistaWebServiceFault {

		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("NAME");
		attributes.add("REQUIRED IDENTIFIERS");
		attributes.add("VERSION");
		DIDFileRequest request = new DIDFileRequest("80", attributes);

		// Execute request against mocked object backend.
		DIDFileResponse response = fileDIDEndpoint.file(request);

		assertNotNull(response.getDidAttributes());
		assertNotNull(response.getDidAttributes().get(0));
		assertEquals("ICD DIAGNOSIS", response.getDidAttributes().get(0)
				.toString());
		assertEquals("REQUIRED IDENTIFIERS", response.getDidAttributes().get(1)
				.toString());
		assertEquals(".01", response.getDidAttributes().get(2).toString());

		// Fail
		fail("This is a rough implemenation before knowing the details of the RPC for this API.");
	}

	/**
	 * Generate 200 error with invalid file attribute
	 * 
	 * Input Data: >Set FILE=80,FLAGS=��,ATTRIBUTES=�BADNAME�
	 * 
	 * Procedure Call:
	 * 
	 * >D FILE^DID(FILE,FLAGS,ATTRIBUTES,"DATA","ERRORS")
	 * 
	 * Expected Output:
	 * 
	 * >ZW ERRORS ERRORS("DIERR")="1^1" ERRORS("DIERR","1")=200
	 * ERRORS("DIERR","1"
	 * ,"TEXT",1)="An input variable or parameter is missing or invalid."
	 * ERRORS("DIERR","E",200,1)=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test @Ignore
	public void testGenerate200ErrorWithBadFileAttr() {

		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("BADNAME");
		DIDFileRequest request = new DIDFileRequest("80", attributes);

		// Execute request against mocked object backend.
		try {
			fileDIDEndpoint.file(request);
		} catch (VistaWebServiceFault e) {
			assertEquals(
					"An input variable or parameter is missing or invalid.",
					e.getMessage());
		}

		// Fail
		fail("This is a rough implemenation before knowing the details of the RPC for this API.");
	}

	/**
	 * Generate 202 error with invalid file number
	 * 
	 * Input Data: >Set FILE=-1,FLAGS=��,ATTRIBUTES=�BADNAME�
	 * 
	 * Procedure Call:
	 * 
	 * >D FILE^DID(FILE,FLAGS,ATTRIBUTES,"DATA","ERRORS")
	 * 
	 * Expected Output:
	 * 
	 * >ZW ERRORS ERRORS("DIERR")="1^1" ERRORS("DIERR","1")=202
	 * ERRORS("DIERR","1","TEXT",1)=
	 * "The input parameter that identifies the FILE is missing or invalid."
	 * ERRORS("DIERR","E",202,1)=""
	 * 
	 */
	@Test @Ignore
	public void testGenerate202ErrorWithBadFile() {

		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("BADNAME");
		DIDFileRequest request = new DIDFileRequest("80", attributes);

		// Execute request against mocked object backend.
		try {
			fileDIDEndpoint.file(request);
		} catch (VistaWebServiceFault e) {
			assertEquals(
					"The input parameter that identifies the FILE is missing or invalid.",
					e.getMessage());
		}
		// Fail
		fail("This is a rough implemenation before knowing the details of the RPC for this API.");
	}

}
