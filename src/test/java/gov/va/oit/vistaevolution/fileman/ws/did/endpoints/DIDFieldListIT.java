/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldListResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFieldListIT extends VistaLinkContextITParent {

	@Autowired
	protected DIDFieldListEndpoint fieldDIDListEndpoint;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * The procedure call FIELDLST^DID(“TESTDATA”) takes target_root “TESTDATA”
	 * as paramenter and created a array root “TESTDATA” which is used to store
	 * a list of field – level attributes as output.
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
	 * TESTDATA("READ ACCESS")="" TESTDATA("SOURCE")=""
	 * 
	 * TESTDATA("SPECIFIER")="" TESTDATA("TECHNICAL DESCRIPTION")=""
	 * TESTDATA("TECHNICAL DESCRIPTION","#(word-processing)")=""
	 * TESTDATA("TITLE")="" TESTDATA("TYPE")="" TESTDATA("WRITE ACCESS")=""
	 * TESTDATA("XECUTABLE HELP")=""
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	@Ignore
	public void testGetFieldList() throws VistaWebServiceFault {

		// Execute request against mocked object backend.
		DIDFieldListResponse response = fieldDIDListEndpoint.fieldList();

		assertNotNull(response);
		assertEquals("AUDIT", response.getFields().get(0));
		assertEquals("AUDIT CONDITION", response.getFields().get(1));
		assertEquals("COMPUTE ALGORITHM", response.getFields().get(2));
	}

}
