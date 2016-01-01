/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.DIDFieldListEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldListResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFieldListTest extends VistaLinkContextTestParent {

	/**
	 * The procedure call FIELDLST^DID(“TESTDATA”) takes target_root “TESTDATA”
	 * as parameter and created a array root “TESTDATA” which is used to store a
	 * list of field – level attributes as output.
	 * 
	 * >DO FIELDLST^DID("TESTDATA")
	 * 
	 * Output >ZW TESTDATA TESTDATA("AUDIT")="" TESTDATA("AUDIT CONDITION")=""
	 * TESTDATA("COMPUTE ALGORITHM")="" TESTDATA("COMPUTED FIELDS USED")=""
	 * TESTDATA("DATE FIELD LAST EDITED")="" TESTDATA("DECIMAL DEFAULT")=""
	 * TESTDATA("DELETE ACCESS")="" TESTDATA("DESCRIPTION")=""
	 * TESTDATA("DESCRIPTION","#(word-processing)")=""
	 * TESTDATA("FIELD LENGTH")="" TESTDATA("GLOBAL SUBSCRIPT LOCATION")=""
	 * TESTDATA("HELP-PROMPT")="" TESTDATA("INPUT TRANSFORM")=""
	 * TESTDATA("LABEL")="" TESTDATA("MULTIPLE-VALUED")=""
	 * TESTDATA("OUTPUT TRANSFORM")="" TESTDATA("POINTER")=""
	 * TESTDATA("READ ACCESS")="" TESTDATA("SOURCE")="" TESTDATA("SPECIFIER")=""
	 * TESTDATA("TECHNICAL DESCRIPTION")=""
	 * TESTDATA("TECHNICAL DESCRIPTION","#(word-processing)")=""
	 * TESTDATA("TITLE")="" TESTDATA("TYPE")="" TESTDATA("WRITE ACCESS")=""
	 * TESTDATA("XECUTABLE HELP")=""
	 * 
	 */
	@Test
	public void testGetFieldList() throws VistaWebServiceFault {

		String testResponse = "AUDIT\nAUDIT CONDITION\nCOMPUTE ALGORITHM\nCOMPUTED FIELDS USED\nDATE FIELD LAST EDITED\nDECIMAL DEFAULT\nDELETE ACCESS\nDESCRIPTION\nDESCRIPTION #(word-processing)\nFIELD LENGTH\nGLOBAL SUBSCRIPT LOCATION\nHELP-PROMPT\nINPUT TRANSFORM\nLABEL\nMULTIPLE-VALUED\nOUTPUT TRANSFORM\nPOINTER\nREAD ACCESS\nSOURCE\nSPECIFIER\nTECHNICAL DESCRIPTION\nTECHNICAL DESCRIPTION #(word-processing)\nTITLE\nTYPE\nWRITE ACCESS\nXECUTABLE HELP";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// Setup the endpoint for testing.
		DIDFieldListEndpointImpl fieldListDIDEndpoint = new DIDFieldListEndpointImpl(
				getVistaLinkContext(), new DIDResponseFactory());

		// Execute request against mocked object backend.
		DIDFieldListResponse response = fieldListDIDEndpoint.fieldList();

		assertNotNull(response);
		assertEquals("AUDIT", response.getFields().get(0));
		assertEquals("AUDIT CONDITION", response.getFields().get(1));
		assertEquals("COMPUTE ALGORITHM", response.getFields().get(2));
	}
}
