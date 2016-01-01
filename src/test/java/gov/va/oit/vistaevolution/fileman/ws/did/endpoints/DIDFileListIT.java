/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileListResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFileListIT extends VistaLinkContextITParent {

	@Autowired
	private DIDFileListEndpoint fileListDIDEndpoint;

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
	@Ignore
	public void testGetFileList() throws VistaWebServiceFault {

		// Execute request against mocked object backend.
		DIDFileListResponse response = getFileListDIDEndpoint().fileList();

		assertNotNull(response);
		assertEquals("ARCHIVE FILE", response.getFiles().get(0));
		assertEquals("AUDIT ACCESS", response.getFiles().get(1));
		assertEquals("DATE", response.getFiles().get(2));
	}

	public DIDFileListEndpoint getFileListDIDEndpoint() {
		return fileListDIDEndpoint;
	}

	public void setFileListDIDEndpoint(DIDFileListEndpoint fileListDIDEndpoint) {
		this.fileListDIDEndpoint = fileListDIDEndpoint;
	}
}
