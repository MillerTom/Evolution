/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.DIDFileListEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileListResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFileListTest extends VistaLinkContextTestParent {

	/**
	 * 
	 * Retrieve Attributes for any File >D FILELST^DID(“DATA”)
	 * 
	 * >ZW DATA DATA("ARCHIVE FILE")="" DATA("AUDIT ACCESS")="" DATA("DATE")=""
	 * DATA("DD ACCESS")="" DATA("DEL ACCESS")="" DATA("DESCRIPTION")=""
	 * DATA("DESCRIPTION","#(word-processing)")="" DATA("DEVELOPER")=""
	 * DATA("DISTRIBUTION PACKAGE")="" DATA("ENTRIES")="" DATA("GLOBAL NAME")=""
	 * DATA("LAYGO ACCESS")="" DATA("LOOKUP PROGRAM")="" DATA("NAME")=""
	 * DATA("PACKAGE REVISION DATA")="" DATA("RD ACCESS")=""
	 * DATA("REQUIRED IDENTIFIERS")=""
	 * DATA("REQUIRED IDENTIFIERS","#","FIELD")="" DATA("VERSION")=""
	 * DATA("WR ACCESS")=""
	 * 
	 */
	@Test
	public void testGetFileList() throws VistaWebServiceFault {

		String testResponse = "ARCHIVE FILE\n" + "AUDIT ACCESS\n" + "DATE\n"
				+ "DD ACCESS\n" + "DEL ACCESS\n" + "DESCRIPTION\n" + "\n"
				+ "DEVELOPER" + "DISTRIBUTION PACKAGE\n" + "ENTRIES\n"
				+ "GLOBAL NAME" + "LAYGO ACCESS\n" + "LOOKUP PROGRAM\n"
				+ "NAME" + "PACKAGE REVISION DATA\n" + "RD ACCESS"
				+ "REQUIRED IDENTIFIERS\n" + "\n" + "VERSION\n" + "WR ACCESS";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// Setup the endpoint for testing.
		DIDFileListEndpointImpl fileListDIDEndpoint = new DIDFileListEndpointImpl(
				getVistaLinkContext(), new DIDResponseFactory());

		// Execute request against mocked object backend.
		DIDFileListResponse response = fileListDIDEndpoint.fileList();

		assertNotNull(response);
		assertEquals("ARCHIVE FILE", response.getFiles().get(0));
		assertEquals("AUDIT ACCESS", response.getFiles().get(1));
		assertEquals("DATE", response.getFiles().get(2));
	}
}
