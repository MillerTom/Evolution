/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for Get1 function of DID Web Ser
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDGet1IT {

	/**
	 * Retrieve LABEL Attribute for the .01 Field >W
	 * $$GET1^DID(80,.01,"","LABEL") CODE NUMBER
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGetFieldLabelAttr() {
		// this.DIDRequest = new DIDRequest("80", ".01", null, "LABEL", null,
		// null);
		// assertNotNull(DIDEndpoint.get1(DIDRequest));

	}

	/**
	 * Retrieve GLOBAL NAME Attribute for a File >W
	 * $$GET1^DID(80,,"","GLOBAL NAME") ICD9
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGetFileGlobalNameAttr() {
		// this.DIDRequest = new DIDRequest("80", null, null, "GLOBAL NAME",
		// null, null);
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Retrieve DESCRIPTION Attribute for the 2 (IDENTIFIER) Field which will be
	 * returned in the DATA array because it is a word processing field
	 * 
	 * > W $$GET1^DID(80,2,"","DESCRIPTION","DATA","ERROR") DATA >zw DATA
	 * DATA(1)=
	 * "This field contains Identifier codes providing more detail on the DRG."
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGetWordProcessingFieldDescriptionAttrByNum() {
		// this.DIDRequest = new DIDRequest("80", "2", null, "DESCRIPTION",
		// "DATA", "ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Retrieve DESCRIPTION Attribute for the IDENTIFIER (2) by Field Name which
	 * will be returned in the DATA array because it is a word processing field
	 * 
	 * > W $$GET1^DID(80,"IDENTIFIER","","DESCRIPTION","DATA","ERROR") DATA >zw
	 * DATA DATA(1)=
	 * "This field contains Identifier codes providing more detail on the DRG."W
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGetWordProcessingFieldDescriptionAttrByName() {
		// this.DIDRequest = new DIDRequest("80", "INDENTIFIER", null,
		// "DESCRIPTION", "DATA", "ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Retrieve the number of entries in the File >W
	 * $$GET1^DID(80,.01,"","ENTRIES", “DATA”,”ERRORS”) 15559
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGetNumberofEntriesInFile() {
		// this.DIDRequest = new
		// DIDRequest("80",".01","","ENTRIES","DATA","ERRORS");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Retrieve TYPE Attribute for the .01 Field >W
	 * $$GET1^DID(80,.01,"","TYPE","DATA","ERROR") FREE TEXT
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGet01FieldTypeAttr() {
		// this.DIDRequest = new
		// DIDRequest("80",".01","","TYPE","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Retrieve TYPE Attribute for the 68 Field >W
	 * $$GET1^DID(80,68,"","TYPE","DATA","ERROR") DATE/TIME
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testGet68FieldTypeAttr() {
		// this.DIDRequest = new DIDRequest("80","68","","TYPE","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Show error code 200 for incorrect information passed to function >W
	 * $$GET1^DID(80,"NOFIELD","","TYPE","DATA","ERROR")
	 * 
	 * >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR","1")=200
	 * ERROR("DIERR","1","TEXT"
	 * ,1)="An input variable or parameter is missing or invalid."
	 * ERROR("DIERR","E",200,1)=""
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testShowGenericError200ForBadParams() {
		// this.DIDRequest = new
		// DIDRequest("80","NOFIELD","","TYPE","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Show error code 202 for incorrect FILE information passed to function
	 * 
	 * >W $$GET1^DID(-1,.01,"","LABEL","DATA","ERROR")
	 * 
	 * >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR","1")=202
	 * ERROR("DIERR","1","TEXT",1)=
	 * "The input parameter that identifies the FILE is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testShowError202ForBadFileParam() {
		// this.DIDRequest = new
		// DIDRequest("-1",".01","","LABEL","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Show error code 202 for incorrect FIELD (NULL value) information passed
	 * to function
	 * 
	 * >W $$GET1^DID(80,,"","LABEL",”DATA”,”ERROR”)
	 * 
	 * >ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR","1")=202
	 * ERROR("DIERR","1","TEXT",1)=
	 * "The input parameter that identifies the ATTRIBUTE is missing or invalid."
	 * ERROR("DIERR","E",202,1)=""
	 * 
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testShowError202ForBadFieldParam() {
		// this.DIDRequest = new
		// DIDRequest("80",null,"","LABEL","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

	/**
	 * Generated error code 601 for incorrect information passed to function,
	 * this error code is not a documented error code for the function
	 * 
	 * > W $$GET1^DID(80,.99,"","LABEL","DATA","ERROR")
	 * 
	 * > ZW ERROR ERROR("DIERR")="1^1" ERROR("DIERR",1)=601
	 * ERROR("DIERR",1,"TEXT",1)="The entry does not exist."
	 * ERROR("DIERR","E",601,1)=""
	 */
	@Test
	@Ignore
	// TODO Finish for integration
	public void testShowError601Undocumented() {
		// this.DIDRequest = new
		// DIDRequest("80",".99","","LABEL","DATA","ERROR");
		// assertNotNull(DIDEndpoint.get1(DIDRequest));
	}

}
