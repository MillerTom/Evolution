/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for OPTEDIT method of XMXSEC2 Webservice
 */
public class XMXSEC2OpteditIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSEC2OpteditEndpointImpl service;

	private XMXSEC2OpteditRequest request;
	private XMXSEC2OpteditResponse response;

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC2OpteditIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. Set XMDUZ to null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=""
	 * >S XMK=.5
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTEDIT^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544315969)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544315969,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptedit001() throws VistaWebServiceFault {

		request = new XMXSEC2OpteditRequest("", ".5", "100");

		response = service.optedit(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Set XMK to null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=.5
	 * >S XMK=""
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTEDIT^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544269449,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptedit002() throws VistaWebServiceFault {

		request = new XMXSEC2OpteditRequest(".5", "", "100");

		response = service.optedit(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Use an invalid user.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=999999
	 * >S XMK=.5
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTEDIT^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544269449,0)="-1^Not a valid user"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptedit003() throws VistaWebServiceFault {

		request = new XMXSEC2OpteditRequest("999999", ".5", "100");

		response = service.optedit(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Not a valid user", response.getMsgRoot().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Return what the user can do with the message.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=.5
	 * >S XMK=1
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTEDIT^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * Global ^TMP("XMLIST",$J
	 * ^TMP("XMLIST",544315969,"A")="XMOPT(""A"")=Answer"
	 * ^TMP("XMLIST",544315969,"A","?")="XMOPT(""A"",""?"")=You must have a Network Signature to Answer a message."
	 * ^TMP("XMLIST",544315969,"AA")="XMOPT(""AA"")=Access Attachments"
	 * ^TMP("XMLIST",544315969,"AA","?")="XMOPT(""AA"",""?"")=This message has no attachments."
	 * ^TMP("XMLIST",544315969,"B")="XMOPT(""B"")=Backup"
	 *                         "C")="XMOPT(""C"")=Confidential (surrogate can't read)"
	 *                         "D")="XMOPT(""D"")=Delivery basket set"
	 *                         "E")="XMOPT(""E"")=Edit"
	 * ^TMP("XMLIST",544315969,"E","?")="XMOPT(""E"",""?"")=Only the originator may Edit a message."
	 * ^TMP("XMLIST",544315969,"ES")="XMOPT(""ES"")=Edit Subject"
	 *                         "ET")="XMOPT(""ET"")=Edit Text"
	 *                          "F")="XMOPT(""F"")=Forward"
	 *                          "H")="XMOPT(""H"")=Headerless Print"
	 *                          "I")="XMOPT(""I"")=Information only (recipients may not reply)"
	 *                         "IN")="XMOPT(""IN"")=Information only"
	 * ^TMP("XMLIST",544315969,"IN","?")="XMOPT(""IN"",""?"")=Only the originator may t
	 * oggle 'Information only'."
	 * ^TMP("XMLIST",544315969,"K")="XMOPT(""K"")=Priority replies"
	 * ^TMP("XMLIST",544315969,"K","?")="XMOPT(""K"",""?"")=The message must be 'priori
	 * ty' in order to toggle 'Priority replies'."
	 * ^TMP("XMLIST",544315969,"L")="XMOPT(""L"")=Later"
	 *                         "N")="XMOPT(""N"")=New"
	 *                        "NS")="XMOPT(""NS"")=Add Network Signature"
	 * ^TMP("XMLIST",544315969,"NS","?")="XMOPT(""NS"",""?"")=You have no Network Signature."
	 * ^TMP("XMLIST",544315969,"P")="XMOPT(""P"")=Priority delivery"
	 *                         "Q")="XMOPT(""Q"")=Query"
	 *                        "QC")="XMOPT(""QC"")=Query Current"
	 *                        "QD")="XMOPT(""QD"")=Query Detailed"
	 *                        "QN")="XMOPT(""QN"")=Query Network"
	 *                       "QNC")="XMOPT(""QNC"")=Query Not Current"
	 *                        "QR")="XMOPT(""QR"")=Query Recipients"
	 *                        "QT")="XMOPT(""QT"")=Query Terminated"
	 *                         "R")="XMOPT(""R"")=Confirm Receipt"
	 *                         "S")="XMOPT(""S"")=Scramble text with password"
	 *                         "T")="XMOPT(""T"")=Terminate"
	 *                         "V")="XMOPT(""V"")=Vaporize date set"
	 *                         "W")="XMOPT(""W"")=Write"
	 *                         "X")="XMOPT(""X"")=Close (no forward allowed)"
	 * ^TMP("XMLIST",544315969,"X","?")="XMOPT(""X"",""?"")=This message is neither KIDS nor Packman."
	 * 
	 * </pre>
	 */
	@Test
	public void testOptedit004() throws VistaWebServiceFault {

		request = new XMXSEC2OpteditRequest(".5", "1", "100");

		response = service.optedit(request);

		assertNotNull(response);
		if (response.getOptionsList() != null) {
			assertEquals("Access Attachments", response.getOptionsList().get(2));
		} else {
			fail("optionsList is NULL, Error Message Returned : "
					+ response.getMsgRoot().get(1));
		}
	}
}
